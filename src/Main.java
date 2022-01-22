import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static int[] randomDate;
    public static Calendar calendar;
    public static String datePattern = "dd MMMM yyyy";
    public static String directory = "src";
    public static String filename = "RandomName";

    public static void main(String[] args) {
        taskStarter();
    }

    private static void taskStarter() {
        randomDate = getRandomDate();
        System.out.format("Randomly generated date: year - %d, month - %d, day - %d\n", randomDate[0], randomDate[1]+1, randomDate[2]);
        calendar = new GregorianCalendar(randomDate[0], randomDate[1], randomDate[2]);
        System.out.format("Date in pattern format %s: %s\n", datePattern, getFormattedString(calendar, datePattern));
        System.out.format("From January 1, 1970 to this date has passed: %d milliseconds\n", getMilliseconds(calendar));
        System.out.println(fileExistCheck(directory, filename));
    }

    private static int[] getRandomDate() {
        return new int[]{1970 + (int) (Math.random() * 50), (int) (Math.random() * 11), 1 + (int) (Math.random() * 30)};
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












