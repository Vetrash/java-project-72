package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlPage;
import hexlet.code.model.UrlCheck;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,5,5,7,7,7,14,14,14,18,18,18,22,22,22,28,28,28,28,51,51,53,53,53,54,54,54,55,55,55,56,56,56,57,57,57,58,58,58,60,60,65,65,65,65,65,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"max-w-5xl mx-auto mt-10 px-4\">\n        <h1 class=\"text-3xl font-semibold\">Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\n\n        <div class=\"mt-4 overflow-hidden border border-gray-200 rounded-lg\">\n            <table class=\"min-w-full divide-y divide-gray-200\" data-test=\"url\">\n                <tbody class=\"divide-y divide-gray-200 bg-white\">\n                <tr class=\"hover:bg-gray-50 transition-colors\">\n                    <th scope=\"row\" class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700 w-1/3 bg-gray-50\">ID</th>\n                    <td class=\"px-4 py-3 text-sm text-gray-700\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\n                </tr>\n                <tr class=\"hover:bg-gray-50 transition-colors\">\n                    <th scope=\"row\" class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700 bg-gray-50\">Имя</th>\n                    <td class=\"px-4 py-3 text-sm text-gray-700\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\n                </tr>\n                <tr class=\"hover:bg-gray-50 transition-colors\">\n                    <th scope=\"row\" class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700 bg-gray-50\">Дата создания</th>\n                    <td class=\"px-4 py-3 text-sm text-gray-700\">");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getCreatedAt() != null ? page.getUrl().getCreatedAt().toString() : "-");
				jteOutput.writeContent("</td>\n                </tr>\n                </tbody>\n            </table>\n        </div>\n\n        <form method=\"post\" action=\"/urls/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("/checks\" class=\"mt-4\">\n            <input\n                type=\"submit\"\n                value=\"Запустить проверку\"\n                class=\"px-5 py-2.5 bg-blue-600 text-white rounded-lg font-medium hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 transition-colors cursor-pointer\"\n            >\n        </form>\n\n        <h2 class=\"text-2xl font-semibold mt-8\">Проверки</h2>\n\n        <div class=\"mt-4 overflow-x-auto border border-gray-200 rounded-lg\">\n            <table class=\"min-w-full divide-y divide-gray-200\" data-test=\"checks\">\n                <thead class=\"bg-gray-50\">\n                <tr>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">ID</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">Код ответа</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">h1</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">title</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">description</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">Дата создания</th>\n                </tr>\n                </thead>\n                <tbody class=\"divide-y divide-gray-200 bg-white\">\n                ");
				for (var check : page.getChecks()) {
					jteOutput.writeContent("\n                    <tr class=\"hover:bg-gray-50 transition-colors\">\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getId());
					jteOutput.writeContent("</td>\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getStatusCode());
					jteOutput.writeContent("</td>\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getH1() != null ? check.getH1() : "");
					jteOutput.writeContent("</td>\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getTitle() != null ? check.getTitle() : "");
					jteOutput.writeContent("</td>\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getDescription() != null ? check.getDescription() : "");
					jteOutput.writeContent("</td>\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getCreatedAt() != null ? check.getCreatedAt().toString() : "-");
					jteOutput.writeContent("</td>\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n                </tbody>\n            </table>\n        </div>\n    </div>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
