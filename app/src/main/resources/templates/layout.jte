@import gg.jte.Content
@import hexlet.code.dto.BasePage
@import hexlet.code.utils.NamedRoutes
@param Content content
@param BasePage page = null

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Анализатор страниц</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="flex flex-col min-h-screen">
<nav class="flex flex-wrap items-center justify-between bg-gray-900 text-white px-4 py-3 mb-3">
   <div class="w-full px-4 flex gap-10">
     <a class="text-xl font-semibold text-white hover:text-gray-300" href="${NamedRoutes.rootPath()}">
       Анализатор страниц
     </a>
<button
    type="button"
    class="lg:hidden text-white p-2 rounded hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-500"
    onclick="document.getElementById('navbarNav').classList.toggle('hidden')"
    aria-label="Toggle navigation"
>
    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"/>
    </svg>
</button>
        <div id="navbarNav" class="hidden lg:flex lg:items-center lg:gap-4">
            <a class="text-gray-300 hover:text-white transition-colors" href="${NamedRoutes.urlsPath()}">
                Список адресов
            </a>
        </div>
    </div>
</nav>

<main class="flex-grow">
    <div class="max-w-5xl mx-auto px-4 mt-4">

        @if(page != null && (page.getFlash() != null || page.getError() != null))
            <div class="mt-4 p-4 rounded-lg border ${page.getFlash() != null ? "bg-green-100 text-green-800 border-green-200" : "bg-red-100 text-red-800 border-red-200"}"
                 role="alert">
                ${page.getFlash() != null ? page.getFlash() : page.getError()}
            </div>
        @endif

        ${content}
    </div>
</main>

<footer class="border-top py-3 mt-5">
    <div class="container-lg text-center">
        <span class="text-muted">© 2024 Анализатор страниц</span>
    </div>
</footer>

</body>
</html>