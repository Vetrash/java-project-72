package hexlet.code.utils;

public final class StringUtils {

    private StringUtils() {
        // приватный конструктор, чтобы нельзя было создать экземпляр
    }

    public static String truncate(String text) {
        if (text == null) {
            return null;
        }
        if (text.length() <= 200) {
            return text;
        }
        return text.substring(0, 200) + "...";
    }
}
