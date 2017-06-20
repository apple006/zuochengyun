import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;

/**
 * Created by dengdechao on 2017/6/20.
 */
public class CalendarPractic {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DATE));

        c.set(2016, 7, 20, 12, 34, 34);

        System.out.println(c.getTime());

        c.add(Calendar.YEAR, -1);

        System.out.println(c.getTime());

        Clock clock = Clock.systemUTC();

        System.out.println(clock.instant());
        System.out.println(clock.millis());

        Duration d = Duration.ofSeconds(6000);
        System.out.println(d.toMinutes());
        System.out.println(d.toHours());

        Clock clock2 = clock.offset(clock, d);
        System.out.println(clock2.instant());

        Instant instant = Instant.now();
    }
}
