package gg.jte.generated.precompiled;
import hexlet.code.dto.BasePage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,12,12,14,14,14,16,16,40,40,40,40,40,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BasePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"max-w-3xl mx-auto mt-10 px-4\">\n        <div class=\"border border-gray-200 rounded-2xl bg-gray-50 p-8\">\n            <h1 class=\"text-5xl font-light mb-0\">Анализатор страниц</h1>\n            <p class=\"text-xl text-gray-600 mt-2\">Бесплатно проверяйте сайты на SEO пригодность</p>\n\n            ");
				if (page != null && page.getError() != null) {
					jteOutput.writeContent("\n                <div class=\"mt-4 p-4 rounded-lg bg-red-100 text-red-800 border border-red-200\" role=\"alert\">\n                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getError());
					jteOutput.writeContent("\n                </div>\n            ");
				}
				jteOutput.writeContent("\n\n            <form action=\"/urls\" method=\"post\" class=\"mt-4\">\n                <div class=\"flex flex-col sm:flex-row gap-2\">\n                    <div class=\"flex-1\">\n                        <input\n                                id=\"url-input\"\n                                type=\"text\"\n                                name=\"url\"\n                                class=\"w-full px-4 py-3 border border-gray-300 rounded-lg bg-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500\"\n                                placeholder=\"Ссылка\"\n                                autocomplete=\"off\"\n                                required\n                        >\n                    </div>\n                    <button type=\"submit\" class=\"px-8 py-3 bg-blue-600 text-white rounded-lg text-lg uppercase font-medium hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 transition-colors\">\n                        Проверить\n                    </button>\n                </div>\n            </form>\n\n            <p class=\"mt-3 mb-0 text-gray-500\">Пример: https://www.example.com</p>\n        </div>\n    </div>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
