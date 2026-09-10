package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlsPage;
import java.time.format.DateTimeFormatter;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,24,24,27,27,27,30,30,30,30,30,30,30,33,33,34,35,35,35,36,36,39,39,40,40,40,41,41,44,44,50,50,50,50,50,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <section>\r\n\r\n        <div class=\"container-lg mt-5\">\r\n            <h1>Сайты</h1>\r\n\r\n            <table class=\"table table-bordered table-hover mt-3\" data-test=\"urls\">\r\n                <thead>\r\n                <tr>\r\n                    <th class=\"col-1\">ID</th>\r\n                    <th>Имя</th>\r\n                    <th class=\"col-2\">Последняя проверка</th>\r\n                    <th class=\"col-1\">Код ответа</th>\r\n                </tr>\r\n                </thead>\r\n                <tbody>\r\n\r\n                ");
				for (var url : page.getUrls()) {
					jteOutput.writeContent("\r\n                    <tr>\r\n                        <td>\r\n                            ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            <a href=\"/urls/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(url.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("</a>\r\n                        </td>\r\n                        <td>\r\n                            ");
					if (page.getAllUrlsLastChecks() != null && page.getAllUrlsLastChecks().containsKey(url.getId())) {
						jteOutput.writeContent("\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(page.getAllUrlsLastChecks().get(url.getId()).getCreatedAt()
                            .toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm")));
						jteOutput.writeContent("\r\n                            ");
					}
					jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            ");
					if (page.getAllUrlsLastChecks() != null && page.getAllUrlsLastChecks().containsKey(url.getId())) {
						jteOutput.writeContent("\r\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(String.valueOf(page.getAllUrlsLastChecks().get(url.getId()).getStatusCode()));
						jteOutput.writeContent("\r\n                            ");
					}
					jteOutput.writeContent("\r\n                        </td>\r\n                    </tr>\r\n                ");
				}
				jteOutput.writeContent("\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n\r\n    </section>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
