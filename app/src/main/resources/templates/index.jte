@import hexlet.code.dto.BasePage
@param BasePage page = null

@template.layout(
page = page,
content = @`
    <div class="max-w-3xl mx-auto mt-10 px-4">
        <div class="border border-gray-200 rounded-2xl bg-gray-50 p-8">
            <h1 class="text-5xl font-light mb-0">Анализатор страниц</h1>
            <p class="text-xl text-gray-600 mt-2">Бесплатно проверяйте сайты на SEO пригодность</p>



            <form action="/urls" method="post" class="mt-4">
                <div class="flex flex-col sm:flex-row gap-2">
                    <div class="flex-1">
                        <input
                                id="url-input"
                                type="text"
                                name="url"
                                class="w-full px-4 py-3 border border-gray-300 rounded-lg bg-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                                placeholder="Ссылка"
                                autocomplete="off"
                                required
                        >
                    </div>
                    <button type="submit" class="px-8 py-3 bg-blue-600 text-white rounded-lg text-lg uppercase font-medium hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 transition-colors">
                        Проверить
                    </button>
                </div>
            </form>

            <p class="mt-3 mb-0 text-gray-500">Пример: https://www.example.com</p>
        </div>
    </div>
`
)