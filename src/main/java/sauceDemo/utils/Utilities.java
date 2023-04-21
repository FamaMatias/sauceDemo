package sauceDemo.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class Utilities {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);

    public static int getMonthDate(String date, String format) {
        Calendar c = new GregorianCalendar();
        try {
            c.setTime(new SimpleDateFormat(format).parse(date));
        } catch (ParseException e) {
            LOGGER.error(String.valueOf(e));
        }
        return c.get(Calendar.MONTH) + 1;
    }

    public static String getCurrentDate(String format) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    public static String getFutureOrPastDate(String format, int days) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    public static int getDayDate(String date, String format) {
        Calendar c = new GregorianCalendar();
        try {
            c.setTime(new SimpleDateFormat(format).parse(date));
        } catch (ParseException e) {
            LOGGER.error(String.valueOf(e));
        }
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static String getRandomDriver() {
        String[] drivers = {"chrome"};
        int r = (int) Math.floor(Math.random() * drivers.length);
        return drivers[r];
    }

    public static Double getValue(Target target, Actor actor) {
        return Double.valueOf(
                Text.of(target).viewedBy(actor).asString().split(" ")[0].replace("$", "").replace(",", ""));
    }

    public static Integer getCancellationMessageAmount(String message) {
        return Integer.valueOf(message.split("\\$")[1].split(" ")[0].replace(",", ""));
    }
}
