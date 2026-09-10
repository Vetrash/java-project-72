package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlPage;
import java.time.format.DateTimeFormatter;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,13,13,13,19,19,19,23,23,23,27,28,28,28,34,34,34,34,48,48,49,49,52,52,52,55,55,55,58,58,58,61,61,61,64,64,64,67,68,68,68,71,71,72,72,79,79,79,79,79,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <main class=\"flex-grow-1\">\r\n\r\n        <section>\r\n\r\n            <div class=\"container-lg mt-5\">\r\n                <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\r\n\r\n                <table class=\"table table-bordered table-hover mt-3\">\r\n                    <tbody>\r\n                    <tr>\r\n                        <td>ID</td>\r\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>Имя</td>\r\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>Дата создания</td>\r\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getCreatedAt()
                            .toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm")));
				jteOutput.writeContent("</td>\r\n                    </tr>\r\n                    </tbody>\r\n                </table>\r\n\r\n                <h2 class=\"mt-5\">Проверки</h2>\r\n                <form method=\"post\" action=\"/urls/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("/checks\">\r\n                    <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\r\n                </form>\r\n\r\n                <table class=\"table table-bordered table-hover mt-3\" data-test=\"checks\">\r\n                    <thead>\r\n                    <tr><th class=\"col-1\">ID</th>\r\n                        <th class=\"col-1\">Код ответа</th>\r\n                        <th>h1</th>\r\n                        <th>title</th>\r\n                        <th>description</th>\r\n                        <th class=\"col-2\">Дата проверки</th>\r\n                    </tr></thead>\r\n                    <tbody>\r\n                    ");
				if (page.getUrlChecks() != null) {
					jteOutput.writeContent("\r\n                    ");
					for (var urlCheck : page.getUrlChecks()) {
						jteOutput.writeContent("\r\n                        <tr>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getId());
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getStatusCode());
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getH1());
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getTitle());
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getDescription());
						jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getCreatedAt()
                                    .toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm")));
						jteOutput.writeContent("\r\n                            </td>\r\n                        </tr>\r\n                    ");
					}
					jteOutput.writeContent("\r\n                    ");
				}
				jteOutput.writeContent("\r\n                    </tbody>\r\n                </table>\r\n            </div>\r\n\r\n        </section>\r\n    </main>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
