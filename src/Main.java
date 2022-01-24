import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static Calendar randomDate;
    public static Calendar calendar;
    public static String datePattern = "dd MMMM yyyy";
    public static String directory = "src";
    public static String filename = "RandomName";

    public static void main(String[] args) {
        taskStarter();
    }

    private static void taskStarter() {
        randomDate = getRandomDate();
        System.out.format("Randomly generated date: year - %d, month - %d, day - %d\n",
                randomDate.get(Calendar.YEAR), randomDate.get(Calendar.MONTH) + 1, randomDate.get(Calendar.DAY_OF_MONTH));
        System.out.format("Date in pattern format %s: %s\n", datePattern, getFormattedString(randomDate, datePattern));
        System.out.format("From January 1, 1970 to this date has passed: %d milliseconds\n", getMilliseconds(randomDate));
        System.out.println(fileExistCheck(directory, filename));
    }

    private static Calendar getRandomDate() {
        Calendar calendar = Calendar.getInstance();
        long randomTime = (long) (Math.random() * (double) System.currentTimeMillis());
        calendar.setTimeInMillis(randomTime);
        return calendar;
    }

    private static String getFormattedString(Calendar calendar, String datePattern) {
        return new SimpleDateFormat(datePattern, Locale.ENGLISH).format(calendar.getTime());
    }

    private static long getMilliseconds(Calendar calendar) {
        return calendar.getTime().getTime();
    }

    private static String fileExistCheck(String directory, String filename) {
        String retVal = "File " + filename + " in directory " + directory;
        File file = new File(directory, filename);
        return file.exists() ? retVal + " is exist\nAbsolute path: " + file.getAbsolutePath() : retVal + " is absent";
    }
}












