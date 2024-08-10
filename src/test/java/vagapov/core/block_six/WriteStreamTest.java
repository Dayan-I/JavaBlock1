package vagapov.core.block_six;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import vagapov.core.block_six.model.User;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WriteStreamTest {

    private final WriteStream writeStream = new WriteStream();

    @Test
    void getFullAddressUserMapTest() {
        Map<User, String> fullAddressUserMap = writeStream.getFullAddressUserMap(getListUser());

        assertNotNull(fullAddressUserMap);
        assertEquals(2, fullAddressUserMap.size());
        assertTrue(fullAddressUserMap.keySet().stream().allMatch(user -> user.getName().equals("Даян") || user.getName().equals("Ильгам")));
        for (Map.Entry<User, String> entry : fullAddressUserMap.entrySet()) {
            if (entry.getKey().getName().equals("Даян")) {
                assertEquals("Турция, г.Сиде, ул.Зеленая, д.43", entry.getValue());
            }
            if (entry.getKey().getName().equals("Ильгам")) {
                assertEquals("Кипр, г.Солнечный, ул.Солнечный, д.2", entry.getValue());
            }
        }
    }

    @Test
    void isAnyLockedUserHereTest() {
        assertTrue(writeStream.isAnyLockedUserHere(List.of(
           new User(1, null, null, null, null, null, null, false),
           new User(2, null, null, null, null, null, null, false),
           new User(3, null, null, null, null, null, null, true),
           new User(4, null, null, null, null, null, null, false)
        )));

        assertTrue(writeStream.isAnyLockedUserHere(List.of(
                new User(1, null, null, null, null, null, null, true),
                new User(2, null, null, null, null, null, null, true),
                new User(3, null, null, null, null, null, null, true),
                new User(4, null, null, null, null, null, null, true)
        )));

        assertFalse(writeStream.isAnyLockedUserHere(List.of(
                new User(1, null, null, null, null, null, null, false),
                new User(2, null, null, null, null, null, null, false),
                new User(3, null, null, null, null, null, null, false),
                new User(4, null, null, null, null, null, null, false)
        )));
    }

    @Test
    void isAllLiveInRussiaTest() {
        assertTrue(writeStream.isAllLiveInRussia(List.of(
                new User(1, null, null, "Россия", null, null, null, false),
                new User(2, null, null, "Россия", null, null, null, false),
                new User(3, null, null, "Россия", null, null, null, true),
                new User(4, null, null, "Россия", null, null, null, false)
        )));

        assertFalse(writeStream.isAllLiveInRussia(List.of(
                new User(1, null, null, "Россия", null, null, null, false),
                new User(2, null, null, "Турция", null, null, null, false),
                new User(3, null, null, "Россия", null, null, null, false),
                new User(4, null, null, "Россия", null, null, null, false)
        )));
    }

    @Test
    void isNoneLockedTest() {
        assertFalse(writeStream.isNoneLocked(List.of(
                new User(1, null, null, "Россия", null, null, null, false),
                new User(2, null, null, "Россия", null, null, null, false),
                new User(3, null, null, "Россия", null, null, null, true),
                new User(4, null, null, "Россия", null, null, null, false)
        )));

        assertTrue(writeStream.isNoneLocked(List.of(
                new User(1, null, null, "Россия", null, null, null, false),
                new User(2, null, null, "Турция", null, null, null, false),
                new User(3, null, null, "Россия", null, null, null, false),
                new User(4, null, null, "Россия", null, null, null, false)
        )));
    }

    @Test
    void getListUserTest() {
        List<User> listUser = writeStream.getListUser(getMap());

        assertEquals(4, listUser.size());
        final User findUser = listUser.stream().filter(user -> user.getId().equals(1)).findFirst().get();
        assertEquals("Вадим", findUser.getName());
        assertEquals("Даян", listUser.stream().filter(user -> user.getId().equals(2)).findFirst().get().getName());
        assertEquals("Ильгам", listUser.stream().filter(user -> user.getId().equals(3)).findFirst().get().getName());
        assertEquals("Ильнур", listUser.stream().filter(user -> user.getId().equals(4)).findFirst().get().getName());
        assertEquals("Россия", findUser.getCountry());
        assertEquals("Москва", findUser.getCity());
        assertEquals("Рощинская", findUser.getStreet());
        assertEquals(12, findUser.getHouseNumber());
        assertEquals(false, findUser.getLocked());
    }

    private List<User> getListUser() {
        return List.of(
                new User(1, List.of(), "Вадим", "Россия", "Москва", "Рощинская", 12, true),
                new User(2, List.of(), "Даян", "Турция", "Сиде", "Зеленая", 43, false),
                new User(2, List.of(), "Даян", "Турция", "Сиде", "Зеленая", 43, false),
                new User(3, List.of(), "Ильгам", "Кипр", "Солнечный", "Кукурузная", 2, false),
                new User(4, List.of(), "Ильнур", "Узбекистан", "Жаркий", "Восточная", 67, true),
                null
        );
    }

    private Map<String, Map<Integer, String>> getMap() {
        return Map.of(
                "name", Map.of(
                        1, "Вадим",
                        2, "Даян",
                        3, "Ильгам",
                        4, "Ильнур"
                ),
                "country", Map.of(
                        1, "Россия",
                        2, "Турция",
                        3, "Кипр",
                        4, "Узбекистан"
                ),
                "city", Map.of(
                        1, "Москва",
                        2, "Сиде",
                        3, "Солнечный",
                        4, "Жаркий"
                ),
                "street", Map.of(
                        1, "Рощинская",
                        2, "Зеленая",
                        3, "Кукурузная",
                        4, "Восточная"
                ),
                "houseNumber", Map.of(
                        1, "12",
                        2, "43",
                        3, "2",
                        4, "67"
                )
        );
    }
}