import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static final int DAY_OF_MONTH_INDEX = 0;
    public static final int MONTH_INDEX = 1;
    public static final int YEAR_INDEX = 2;

    public static void main(String[] args) {
        int[] dateOfBirth = inputDateOfBirth();
        Calendar calendar = new GregorianCalendar(dateOfBirth[YEAR_INDEX], dateOfBirth[MONTH_INDEX], dateOfBirth[DAY_OF_MONTH_INDEX]);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println("Дата вашего рождения в формате паттерна dd MMMM yyyy - " + dateFormat.format(calendar.getTime()));
        Date date = calendar.getTime();
        System.out.println("С 1 января 1970 года до Вашего рождения прошло " + date.getTime() + " миллисекунд");
    }

    public static int[] inputDateOfBirth() {
        Scanner scanner = new Scanner(System.in);
        int dayOfMonth = 0, month = 0, year = 0;
        boolean exit = false;
        while (!exit) {
            System.out.print("Введите день вашего рождения в виде двузначного числа ");
            try {
                dayOfMonth = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка при вводе, повторите ввод");
            }
            System.out.print("Введите месяц вашего рождения в виде двузначного числа ");
            try {
                month = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка при вводе, повторите ввод");
            }
            System.out.print("Введите год вашего рождения в виде четырехзначного числа ");
            try {
                year = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка при вводе, повторите ввод");
            }
            if (dayOfMonth != 0 && month != 0 && year != 0) exit = true;
        }
        return new int[] {dayOfMonth, --month, year};
    }
}
