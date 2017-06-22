import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;

/**
 * Created by dengdechao on 2017/6/20.
 */
public class CalendarPractic {
    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//
//        System.out.println(c.get(Calendar.YEAR));
//        System.out.println(c.get(Calendar.MONTH));
//        System.out.println(c.get(Calendar.DATE));
//
//        c.set(2016, 7, 20, 12, 34, 34);
//
//        System.out.println(c.getTime());
//
//        c.add(Calendar.YEAR, -1);
//
//        System.out.println(c.getTime());
//
//        Clock clock = Clock.systemUTC();
//
//        System.out.println(clock.instant());
//        System.out.println(clock.millis());
//
//        Duration d = Duration.ofSeconds(6000);
//        System.out.println(d.toMinutes());
//        System.out.println(d.toHours());
//
//        Clock clock2 = clock.offset(clock, d);
//        System.out.println(clock2.instant());
//
//        Instant instant = Instant.now();
//        System.out.println(instant);
//        Instant instant2 = instant.plusSeconds(6000);
//        System.out.println(instant2);
//        Instant instant3 = instant.parse("2017-06-21T03:05:04.224Z");
//        System.out.println(instant3);
//        Instant instance4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
//        System.out.println(instance4);
//
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        LocalTime localTime = LocalTime.now();
//        System.out.println(localTime);

        DateTimeFormatter[] formatters = new DateTimeFormatter[] {
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
                DateTimeFormatter.ofPattern("Gyyyy年MM月dd日 HH:mm:ss")
        };

        LocalDateTime date = LocalDateTime.now();
        for(int i = 0; i < formatters.length; ++i) {
            System.out.println(date.format(formatters[i]));
        }
    }
}
