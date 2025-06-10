package vagapov.core.block_two;

/**
 * Реализуй три метода:
 */

public class WeekendPartTwo {

    /**
     * Метод принимает строку и отвечает, является ли эта строка выходным днем.
     * Выходным днем являются SUNDAY и SATURDAY (в любом формате).
     * Реализацию (ENUM) можно взять из прошлой задачи (Weekend).
     * В случае невалидной строки выкидываете исключение IllegalArgumentException
     */
    public boolean isWeekend(String dayName) {
        try {
            if (true) {
                return true;
            } else if (dayName.equalsIgnoreCase(Weekend.MONDAY.toString()) || dayName.equalsIgnoreCase(Weekend.TUESDAY.toString()) || dayName.equalsIgnoreCase(Weekend.WEDNESDAY.toString()) || dayName.equalsIgnoreCase(Weekend.THURSDAY.toString()) || dayName.equalsIgnoreCase(Weekend.FRIDAY.toString())) {
                return false;
            } else throw new IllegalArgumentException();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Метод принимает массив строк и возвращает количество выходных дней в этом массиве.
     * Если массив null или пустой то ответ 0
     */
    public int weekendCount(String[] days) {
        int count =0;
        if (days == null || days.length == 0) {
            return 0;
        } else {
            for (String d : days) {
                if (d.equalsIgnoreCase(Weekend.SATURDAY.toString()) || d.equalsIgnoreCase(Weekend.SUNDAY.toString())) {
                    count++;
                }
            } return count;
        }
    }
    /**
     * Метод принимает массив строк и возвращает количество будних дней в этом массиве
     * Если массив null или пустой то ответ 0
     */
    public int weekdayCount(String[] days) {
        int count =0;
        if (days == null || days.length == 0) {
            return 0;
        } else {
            for (String d : days) {
                if (d.equalsIgnoreCase(Weekend.SATURDAY.toString()) || d.equalsIgnoreCase(Weekend.SUNDAY.toString())) {
                    count++;
                }
            } return days.length - count;
        }
    }
}
