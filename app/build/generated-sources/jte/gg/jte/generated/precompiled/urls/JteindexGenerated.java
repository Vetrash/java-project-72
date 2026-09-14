package gg.jte.generated.precompiled.urls;
import hexlet.code.dto.UrlsPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,4,4,19,19,21,21,21,23,23,23,23,24,24,24,28,28,29,29,29,30,30,32,32,35,35,36,36,36,37,37,39,39,42,42,47,47,47,47,47,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"max-w-5xl mx-auto mt-10 px-4\">\n        <h1 class=\"text-3xl font-semibold\">Сайты</h1>\n\n        <div class=\"mt-4 overflow-hidden border border-gray-200 rounded-lg\">\n            <table class=\"min-w-full divide-y divide-gray-200\" data-test=\"urls\">\n                <thead class=\"bg-gray-50\">\n                <tr>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">ID</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">Имя</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">Дата последней проверки</th>\n                    <th class=\"px-4 py-3 text-left text-sm font-semibold text-gray-700\">Код ответа</th>\n                </tr>\n                </thead>\n                <tbody class=\"divide-y divide-gray-200 bg-white\">\n                ");
				for (var url : page.getUrls()) {
					jteOutput.writeContent("\n                    <tr class=\"hover:bg-gray-50 transition-colors\">\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("</td>\n                        <td class=\"px-4 py-3 text-sm\">\n                            <a href=\"/urls/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(url.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\" class=\"text-blue-600 hover:text-blue-800 hover:underline\">\n                                ");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("\n                            </a>\n                        </td>\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">\n                            ");
					if (page.getLastCheckDate().containsKey(url.getId())) {
						jteOutput.writeContent("\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(page.getLastCheckDate().get(url.getId()).toString());
						jteOutput.writeContent("\n                            ");
					} else {
						jteOutput.writeContent("\n                                -\n                            ");
					}
					jteOutput.writeContent("\n                        </td>\n                        <td class=\"px-4 py-3 text-sm text-gray-700\">\n                            ");
					if (page.getLastCheckCode().containsKey(url.getId())) {
						jteOutput.writeContent("\n                                ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(page.getLastCheckCode().get(url.getId()));
						jteOutput.writeContent("\n                            ");
					} else {
						jteOutput.writeContent("\n                                -\n                            ");
					}
					jteOutput.writeContent("\n                        </td>\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n                </tbody>\n            </table>\n        </div>\n    </div>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
