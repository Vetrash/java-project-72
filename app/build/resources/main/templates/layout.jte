@import gg.jte.Content
@import hexlet.code.dto.BasePage
@import hexlet.code.util.NamedRoutes
@param Content content
@param BasePage page = null

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Анализатор страниц</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="flex flex-col min-h-screen">
<nav class="bg-gray-800 mb-4">
    <div class="container mx-auto px-4">
        <div class="flex items-center justify-between h-16">
            <a class="text-white text-xl font-semibold" href="${NamedRoutes.rootPath()}">Анализатор страниц</a>
            <button class="lg:hidden text-white p-2 rounded hover:bg-gray-700 focus:outline-none" type="button" data-toggle="collapse" data-target="#navbarNav">
                <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"/>
                </svg>
            </button>
            <div class="hidden lg:flex" id="navbarNav">
                <!-- Содержимое навигации -->
            </div>
        </div>
    </div>
</nav>