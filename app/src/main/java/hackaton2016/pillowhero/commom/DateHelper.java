package hackaton2016.pillowhero.commom;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Seconds;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import hackaton2016.pillowhero.R;

/**
 * Created by diegocunha on 29/10/16.
 */

public class DateHelper {

    private int i;

    public static int getHour(long duration) {
        final Long hoursReceived = TimeUnit.MILLISECONDS.toHours(duration);
        return hoursReceived.intValue();
    }

    public static int getMinutes(long duration) {
        final Long minutesReceived = TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS
                .toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        return minutesReceived.intValue();
    }

    public static long intervalHour(int hour, int minute) {
        final Calendar now = Calendar.getInstance();
        final Calendar picker = Calendar.getInstance();

        picker.add(Calendar.HOUR_OF_DAY, hour);
        picker.add(Calendar.MINUTE, minute);

        final Interval interval = new Interval(now.getTimeInMillis(), picker.getTimeInMillis());
        return interval.toDurationMillis();
    }

    public static int invervalSeconds(Date receivedValue) {
        DateTime now = DateTime.now();
        DateTime difference = new DateTime(receivedValue);

        return Math.abs(Seconds.secondsBetween(now, difference).getSeconds());
    }

    public static String dateToString(Date date) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        return format.format(date);
    }

    public static String timeToString(long time) {
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return format.format(time);
    }

    public static String timeToDay(long time) {
        DateFormat format = new SimpleDateFormat("dd/MM", Locale.getDefault());
        return format.format(time);
    }

    public static final int drawable(int position) {

        int[] drawables = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4};

        if (position > drawables.length - 1) {
            position = 0;
        }
        return drawables[position];
    }

}
