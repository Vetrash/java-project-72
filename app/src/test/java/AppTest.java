
import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.repository.BaseRepository;
import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.App;
import hexlet.code.utils.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.testtools.JavalinTest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    private static MockWebServer mockWebServer;
    private static String normalizedMockServerUrl;

    private Javalin app;

    @BeforeAll
    static void beforeAll() throws IOException, SQLException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        URI uri = URI.create(mockWebServer.url("/").toString());
        normalizedMockServerUrl = String.format("%s://%s%s",
                uri.getScheme(),
                uri.getHost(),
                uri.getPort() == -1 ? "" : ":" + uri.getPort()
        );
    }

    @AfterAll
    static void afterAll() throws IOException {
        if (mockWebServer != null) {
            mockWebServer.shutdown();
        }
        clear();
    }

    @BeforeEach
    void beforeEach() throws SQLException {
        clear();
        app = App.getApp();
    }

    @AfterEach
    void afterEach() {
        if (app != null) {
            app.stop();
        }
    }

    public static void clear() {
        HikariDataSource dataSource = BaseRepository.getDataSourcedataSource();
        if (dataSource == null) {
            return;
        }

        try (var conn = dataSource.getConnection();
             var stmt = conn.createStatement()) {

            String dbName = conn.getMetaData().getDatabaseProductName().toLowerCase();

            if (dbName.contains("h2")) {
                stmt.execute("SET REFERENTIAL_INTEGRITY FALSE");
                stmt.execute("TRUNCATE TABLE url_checks");
                stmt.execute("TRUNCATE TABLE urls");
                stmt.execute("ALTER TABLE urls ALTER COLUMN id RESTART WITH 1");
                stmt.execute("ALTER TABLE url_checks ALTER COLUMN id RESTART WITH 1");
                stmt.execute("SET REFERENTIAL_INTEGRITY TRUE");
            } else { // PostgreSQL
                stmt.execute("TRUNCATE TABLE url_checks, urls RESTART IDENTITY CASCADE");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to clear database", e);
        }
    }
    @Test
    void testCreateUrlSuccess() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            try (var response = client.post(NamedRoutes.urlsPath(), "url=https://example.com")) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
            }

            var maybeUrl = UrlRepository.findByName("https://example.com");
            assertThat(maybeUrl).isPresent();
        });
    }

    @Test
    void testCreateUrlDuplicate() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            client.post(NamedRoutes.urlsPath(), "url=https://duplicate.com");

            try (var response = client.post(NamedRoutes.urlsPath(), "url=https://duplicate.com")) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
            }

            var maybeUrl = UrlRepository.findByName("https://duplicate.com");
            assertThat(maybeUrl).isPresent();
        });
    }

    @Test
    void testCreateUrlInvalid() {
        JavalinTest.test(app, (server, client) -> {
            try (var response = client.post(NamedRoutes.urlsPath(), "url=invalid")) {
                assertThat(response.code()).isEqualTo(422);
                assertThat(response.body().string()).contains("Некорректный URL");
            }
        });
    }

    @Test
    void testGetUrlById() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            client.post(NamedRoutes.urlsPath(), "url=https://test.com");

            var maybeUrl = UrlRepository.findByName("https://test.com");
            assertThat(maybeUrl).isPresent();

            long id = maybeUrl.get().getId();
            try (var response = client.get(NamedRoutes.urlPath(String.valueOf(id)))) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
                assertThat(response.body().string()).contains("https://test.com");
            }
        });
    }

    @Test
    void testGetUrlNotFound() {
        JavalinTest.test(app, (server, client) -> {
            try (var response = client.get(NamedRoutes.urlPath("99999"))) {
                assertThat(response.code()).isEqualTo(404);
            }
        });
    }

    @Test
    void testCheckUrlSuccess() throws SQLException {
        String mockHtml = """
            <html>
                <head><title>Test Title</title></head>
                <body>
                    <h1>Test H1</h1>
                    <meta name="description" content="Test Description">
                </body>
            </html>
            """;
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(mockHtml));

        JavalinTest.test(app, (server, client) -> {
            client.post(NamedRoutes.urlsPath(), "url=" + normalizedMockServerUrl);

            var maybeUrl = UrlRepository.findByName(normalizedMockServerUrl);
            assertThat(maybeUrl).isPresent();

            long id = maybeUrl.get().getId();
            try (var response = client.post(NamedRoutes.urlChecksPath(String.valueOf(id)), "")) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
            }

            var checks = UrlCheckRepository.findByUrlId(id);
            assertThat(checks).isNotEmpty();

            var check = checks.get(0);
            assertThat(check.getStatusCode()).isEqualTo(200);
            assertThat(check.getTitle()).isEqualTo("Test Title");
            assertThat(check.getH1()).isEqualTo("Test H1");
            assertThat(check.getDescription()).isEqualTo("Test Description");
        });
    }

    @Test
    void testCheckUrlClientError() throws SQLException {
        mockWebServer.enqueue(new MockResponse().setResponseCode(404));

        JavalinTest.test(app, (server, client) -> {
            client.post(NamedRoutes.urlsPath(), "url=" + normalizedMockServerUrl);

            var maybeUrl = UrlRepository.findByName(normalizedMockServerUrl);
            assertThat(maybeUrl).isPresent();

            long id = maybeUrl.get().getId();
            try (var response = client.post(NamedRoutes.urlChecksPath(String.valueOf(id)), "")) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
            }

            // Проверка не должна быть сохранена при статусе 404
            var checks = UrlCheckRepository.findByUrlId(id);
            assertThat(checks).isEmpty();
        });
    }

    @Test
    void testUrlPageShowsDataTestAttributes() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            client.post(NamedRoutes.urlsPath(), "url=https://example.com");

            var maybeUrl = UrlRepository.findByName("https://example.com");
            assertThat(maybeUrl).isPresent();

            long id = maybeUrl.get().getId();
            try (var response = client.get(NamedRoutes.urlPath(String.valueOf(id)))) {
                String body = response.body().string();
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
                assertThat(body).contains("data-test=\"url\"");
                assertThat(body).contains("method=\"post\"");
                assertThat(body).contains("action=\"/urls/" + id + "/checks\"");
                assertThat(body).contains("data-test=\"checks\"");
            }
        });
    }

    @Test
    void testCheckUrlWithEmptyHtml() throws SQLException {
        String mockHtml = """
            <html>
                <head></head>
                <body></body>
            </html>
            """;
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(mockHtml));

        JavalinTest.test(app, (server, client) -> {
            client.post(NamedRoutes.urlsPath(), "url=" + normalizedMockServerUrl);

            var maybeUrl = UrlRepository.findByName(normalizedMockServerUrl);
            assertThat(maybeUrl).isPresent();

            long id = maybeUrl.get().getId();
            try (var response = client.post(NamedRoutes.urlChecksPath(String.valueOf(id)), "")) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
            }

            var checks = UrlCheckRepository.findByUrlId(id);
            assertThat(checks).isNotEmpty();

            var check = checks.get(0);
            assertThat(check.getTitle()).isEmpty();
            assertThat(check.getH1()).isNull();
            assertThat(check.getDescription()).isNull();
        });
    }

    @Test
    void testCreateUrlWithPort() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            try (var response = client.post(NamedRoutes.urlsPath(), "url=http://localhost:8080")) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
            }

            var maybeUrl = UrlRepository.findByName("http://localhost:8080");
            assertThat(maybeUrl).isPresent();
            assertThat(maybeUrl.get().getName()).isEqualTo("http://localhost:8080");
        });
    }

    @Test
    void testCreateUrlWithHttps() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            try (var response = client.post(NamedRoutes.urlsPath(), "url=https://secure.com")) {
                assertThat(response.code()).isEqualTo(HttpStatus.OK.getCode());
            }

            var maybeUrl = UrlRepository.findByName("https://secure.com");
            assertThat(maybeUrl).isPresent();
            assertThat(maybeUrl.get().getName()).isEqualTo("https://secure.com");
        });
    }
}
