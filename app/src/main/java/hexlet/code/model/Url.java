package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@AllArgsConstructor
public class Url {
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private Long id;
    private String name;
    private LocalDateTime createdAt;

    public String getCreatedAtFormatted() {
        if (createdAt == null) {
            return "";
        }
        return createdAt.format(DATE_FORMATTER);
    }

    public Url(String name) {
        this.name = name;
    }
}
