package vagapov.core.block_one;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StringMapperIsEmailTest {

    StringMapper mapper = new StringMapper();

    @DisplayName("Является ли строка почтой гугл. Входное значение - null или empty")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmail_whenValueIsNull(String value) {
        System.out.println("Проверка на почту: " + value);
        Boolean aBoolean = assertDoesNotThrow(() -> mapper.isEmail(value));
        assertFalse(aBoolean);
    }

    @ParameterizedTest
    @MethodSource("getStringNotEmail")
    @DisplayName("Является ли строка почтой гугл. Входное значение неправильное")
    void isEmail_whenValueNotEmail(String value) {
        System.out.println("Проверка на почту: " + value);
        assertFalse(assertDoesNotThrow(() -> mapper.isEmail(value)));
    }

    @ParameterizedTest
    @MethodSource("getStringIsEmail")
    @DisplayName("Является ли строка почтой гугл. Входное значение правильное")
    void isEmail_whenValueisEmail(String value) {
        System.out.println("Проверка на почту: " + value);
        assertTrue(assertDoesNotThrow(() -> mapper.isEmail(value)));
    }

   static Stream<String> getStringNotEmail() {
        return Stream.of(
                "aabbcc@mail.ru",
                "aab6aa6outlook.com",
                "aaa@mail.com",
                "000@gmail.ru",
                "90076667",
                "@gmail.com",
                "@outlook.com",
                "outlook.com",
                "gmail.com"
        );
    }

    static Stream<String> getStringIsEmail() {
        return Stream.of(
                "888aabaa@gmail.com",
                "aaa@outlook.com",
                "aabbaa0998798@gmail.com",
                "101@gmail.com",
                "Dayan007@outlook.com"
        );
    }

}
