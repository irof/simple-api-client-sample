package javajok.sample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by haljik on 2015/11/06.
 */
public class TweetTimestamp {
    private LocalDateTime value;

    public TweetTimestamp(String value) {
        this.value = LocalDateTime.parse(value);
    }

    private static final DateTimeFormatter 昨年以前の書式 = DateTimeFormatter.ofPattern("yyyy/M/d");
    private static final DateTimeFormatter 昨日以前の書式 = DateTimeFormatter.ofPattern("M/d (E)");
    private static final DateTimeFormatter 今日の書式 = DateTimeFormatter.ofPattern("a h:m");

    public String asText() {
        if (昨年以前()) return value.format(昨年以前の書式);
        if (昨日以前()) return value.format(昨日以前の書式);
        return String.format("今日の%s",value.format(今日の書式));
    }

    public String asClass() {
        if (昨年以前()) return "label-default";
        if (昨日以前()) return "label-default";
        return "label-info";
    }

    private boolean 昨年以前() {
        return value.isBefore(LocalDate.now().withDayOfYear(1).atStartOfDay());
    }

    private boolean 昨日以前() {
        return value.isBefore(LocalDate.now().atStartOfDay());
    }

    @Override
    public String toString() {
        return "TweetTimestamp{" +
                "value=" + value +
                '}';
    }
}
