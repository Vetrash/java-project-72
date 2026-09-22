@import hexlet.code.dto.UrlPage
@import hexlet.code.model.UrlCheck
@param UrlPage page

@template.layout(page = page, content = @`
    <div class="max-w-5xl mx-auto mt-10 px-4">
        <h1 class="text-3xl font-semibold">Сайт: ${page.getUrl().getName()}</h1>

        <div class="mt-4 overflow-hidden border border-gray-200 rounded-lg">
            <table class="min-w-full divide-y divide-gray-200" data-test="url">
                <tbody class="divide-y divide-gray-200 bg-white">
                <tr class="hover:bg-gray-50 transition-colors">
                    <th scope="row" class="px-4 py-3 text-left text-sm font-semibold text-gray-700 w-1/3 bg-gray-50">ID</th>
                    <td class="px-4 py-3 text-sm text-gray-700">${page.getUrl().getId()}</td>
                </tr>
                <tr class="hover:bg-gray-50 transition-colors">
                    <th scope="row" class="px-4 py-3 text-left text-sm font-semibold text-gray-700 bg-gray-50">Имя</th>
                    <td class="px-4 py-3 text-sm text-gray-700">${page.getUrl().getName()}</td>
                </tr>
                <tr class="hover:bg-gray-50 transition-colors">
                    <th scope="row" class="px-4 py-3 text-left text-sm font-semibold text-gray-700 bg-gray-50">Дата создания</th>
                    <td class="px-4 py-3 text-sm text-gray-700">${page.getUrl().getCreatedAt() != null ? page.getUrl().getCreatedAtFormatted() : "-"}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <form method="post" action="/urls/${page.getUrl().getId()}/checks" class="mt-4">
            <input
                type="submit"
                value="Запустить проверку"
                class="px-5 py-2.5 bg-blue-600 text-white rounded-lg font-medium hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 transition-colors cursor-pointer"
            >
        </form>

        <h2 class="text-2xl font-semibold mt-8">Проверки</h2>

        <div class="mt-4 overflow-x-auto border border-gray-200 rounded-lg">
            <table class="min-w-full divide-y divide-gray-200" data-test="checks">
                <thead class="bg-gray-50">
                <tr>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">ID</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Код ответа</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">h1</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">title</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">description</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Дата создания</th>
                </tr>
                </thead>
                <tbody class="divide-y divide-gray-200 bg-white">
                @for(var check : page.getChecks())
                    <tr class="hover:bg-gray-50 transition-colors">
                        <td class="px-4 py-3 text-sm text-gray-700">${check.getId()}</td>
                        <td class="px-4 py-3 text-sm text-gray-700">${check.getStatusCode()}</td>
                        <td class="px-4 py-3 text-sm text-gray-700">${check.getH1() != null ? check.getH1() : ""}</td>
                        <td class="px-4 py-3 text-sm text-gray-700">${check.getTitle() != null ? check.getTitle() : ""}</td>
                        <td class="px-4 py-3 text-sm text-gray-700">${check.getDescription() != null ? check.getDescription() : ""}</td>
                        <td class="px-4 py-3 text-sm text-gray-700">${check.getCreatedAt() != null ? check.getCreatedAtFormatted() : "-"}</td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
    </div>
`
)