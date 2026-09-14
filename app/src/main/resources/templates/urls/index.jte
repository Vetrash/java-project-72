@import hexlet.code.dto.UrlsPage
@param UrlsPage page

@template.layout(page = page, content = @`
    <div class="max-w-5xl mx-auto mt-10 px-4">
        <h1 class="text-3xl font-semibold">Сайты</h1>

        <div class="mt-4 overflow-hidden border border-gray-200 rounded-lg">
            <table class="min-w-full divide-y divide-gray-200" data-test="urls">
                <thead class="bg-gray-50">
                <tr>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">ID</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Имя</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Дата последней проверки</th>
                    <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Код ответа</th>
                </tr>
                </thead>
                <tbody class="divide-y divide-gray-200 bg-white">
                @for(var url : page.getUrls())
                    <tr class="hover:bg-gray-50 transition-colors">
                        <td class="px-4 py-3 text-sm text-gray-700">${url.getId()}</td>
                        <td class="px-4 py-3 text-sm">
                            <a href="/urls/${url.getId()}" class="text-blue-600 hover:text-blue-800 hover:underline">
                                ${url.getName()}
                            </a>
                        </td>
                        <td class="px-4 py-3 text-sm text-gray-700">
                            @if(page.getLastCheckDate().containsKey(url.getId()))
                                ${page.getLastCheckDate().get(url.getId()).toString()}
                            @else
                                -
                            @endif
                        </td>
                        <td class="px-4 py-3 text-sm text-gray-700">
                            @if(page.getLastCheckCode().containsKey(url.getId()))
                                ${page.getLastCheckCode().get(url.getId())}
                            @else
                                -
                            @endif
                        </td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
    </div>
`
)