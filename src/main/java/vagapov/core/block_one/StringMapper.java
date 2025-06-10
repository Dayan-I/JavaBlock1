package vagapov.core.block_one;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMapper {

    public static final String MESSAGE = "Ошибка преобразования строки в число";

    /**
     * Напиши метод который преобразует строку в число. Если @param value пришло как null, то выкидывать RuntimeException.
     * В остальных случаях выкидывать NumberFormatException. В любом исключении использовать сообщение исключения - "MESSAGE"
     */
    public Number mapString2Number(String value) {
        long n = 0;
        if (value == null) {
            throw new RuntimeException(MESSAGE);

        } else {

            try {
                n =+ Long.parseLong(value);
                return n;
            } catch (NumberFormatException e) {
                throw new NumberFormatException(MESSAGE);
            }

        }

    }


    /**
     * Реализуй метод, проверяющий, является ли заданная строка палиндромом.
     * Если @param value пришло как null или пустая строка, то не должно быть ошибки, нужно возвращать false
     */
    public boolean isPalindrome(String value) {
        if (value == null || value == "") {
            return false;
        } else {
            String s = "";
            for (int i = value.length() - 1; i > -1; i--) {
                s = s + value.charAt(i);
            }
            if (s.equalsIgnoreCase(value)) {
                return true;
            } else return false;

        }
    }


    /**
     * Regex. Соответствует ли эта строка почтовому ящику сервисов Google (gmail.com) или Microsoft (outlook.com).
     * Будем считать, что в корректном почтовом ящике можно использовать только цифры и буквы.
     * Если @param value пришло как null или пустая строка, то не должно быть ошибки, нужно возвращать false
     */
    public boolean isEmail(String value) {
        if (value == null | value == "") {
            return false;
        } else {
            Pattern g = Pattern.compile("^[A-Za-z0-9+_.-]+@gmail.com");
            Pattern o = Pattern.compile("^[A-Za-z0-9+_.-]+@outlook.com");
            Matcher m = g.matcher(value);
            Matcher m1 = o.matcher(value);
            if (m.find()){
                return true;
            } else if (m1.find()) {
                return true;
            } else return false;
        }

        }
    }
