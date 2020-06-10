package cloud.cholewa.wow.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ClockService {

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static LocalDateTime inFuture(LocalDateTime time, Long seconds) {
        return time.plusSeconds(seconds);
    }

    public static Date getDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }
}
