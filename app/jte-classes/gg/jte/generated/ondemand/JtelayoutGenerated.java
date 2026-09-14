package gg.jte.generated.ondemand;
import gg.jte.Content;
import hexlet.code.dto.BasePage;
import hexlet.code.utils.NamedRoutes;
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,17,17,17,17,17,17,17,17,17,17,31,31,31,31,31,31,31,31,31,41,41,42,42,42,42,43,43,43,45,45,47,47,49,49,49,51,51,53,53,53,64,64,64,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Анализатор страниц</title>\n    <script src=\"https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4\"></script>\n</head>\n<body class=\"flex flex-col min-h-screen\">\n<nav class=\"flex flex-wrap items-center justify-between bg-gray-900 text-white px-4 py-3 mb-3\">\n   <div class=\"w-full px-4 flex gap-10\">\n     <a class=\"text-xl font-semibold text-white hover:text-gray-300\"");
		var __jte_html_attribute_0 = NamedRoutes.rootPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n       Анализатор страниц\n     </a>\n<button\n    type=\"button\"\n    class=\"lg:hidden text-white p-2 rounded hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-500\"\n    onclick=\"document.getElementById('navbarNav').classList.toggle('hidden')\"\n    aria-label=\"Toggle navigation\"\n>\n    <svg class=\"w-6 h-6\" fill=\"none\" stroke=\"currentColor\" viewBox=\"0 0 24 24\">\n        <path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M4 6h16M4 12h16M4 18h16\"/>\n    </svg>\n</button>\n        <div id=\"navbarNav\" class=\"hidden lg:flex lg:items-center lg:gap-4\">\n            <a class=\"text-gray-300 hover:text-white transition-colors\"");
		var __jte_html_attribute_1 = NamedRoutes.urlsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n                Список адресов\n            </a>\n        </div>\n    </div>\n</nav>\n\n<main class=\"flex-grow\">\n    <div class=\"max-w-5xl mx-auto px-4 mt-4\">\n\n        ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n            <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getFlashType());
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\" role=\"alert\">\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\n            </div>\n        ");
		}
		jteOutput.writeContent("\n\n        ");
		if (page != null && page.getError() != null) {
			jteOutput.writeContent("\n            <div class=\"alert alert-danger\" role=\"alert\">\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getError());
			jteOutput.writeContent("\n            </div>\n        ");
		}
		jteOutput.writeContent("\n\n        ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n    </div>\n</main>\n\n<footer class=\"border-top py-3 mt-5\">\n    <div class=\"container-lg text-center\">\n        <span class=\"text-muted\">© 2024 Анализатор страниц</span>\n    </div>\n</footer>\n\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
