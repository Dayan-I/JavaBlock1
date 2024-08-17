package vagapov.core.block_six;

import vagapov.core.block_six.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Поработаем со стримами
 */
public class WriteStream {
    /**
     * Реализуйте метод через стрим который принимает в себя список пользователей,
     * отфильтровывает на null и только не заблокированных пользователей,
     * фильтрует необходимые поля на null
     * собирает пользователей в мапу где ключ это сам пользователь, а значение это полный адрес типа:
     * "Россия, г. Москва, ул. Рощинская, д. 25"
     *
     * 1. Решите в 1 общий стрим
     * 2. Возможны дубликаты пользователей, избавится от них
     * 3. Имейте в виду что, например, по 'городу' в базе храниться только само значение 'Москва',
     * если просто его добавить к адресу то будет неправильный адрес потому что символов 'г.' не будет
     */
    public Map<User, String> getFullAddressUserMap(List<User> userList) {
        return null;
    }

    /**
     * Реализуйте метод через стрим который принимает в себя список пользователей,
     * и одним методом стрима говорит есть ли в этом списке заблокированный пользователь
     *
     * если есть хоть 1 то return TRUE
     *
     * 1. Решите в 1 общий стрим и в 1 метод стрима
     */
    public Boolean isAnyLockedUserHere(List<User> userList) {
        return null;
    }

    /**
     * Реализуйте метод через стрим который принимает в себя список пользователей,
     * и одним методом стрима говорит все ли в этом списке живут в России?
     *
     * если все живут в "России" то return TRUE
     *
     * 1. Решите в 1 общий стрим и в 1 метод стрима
     */
    public Boolean isAllLiveInRussia(List<User> userList) {
        return null;
    }

    /**
     * Реализуйте метод через стрим который принимает в себя список пользователей,
     * и одним методом стрима говорит нету ли здесь заблокированных пользователей?
     *
     * если нет, то return TRUE
     *
     * 1. Решите в 1 общий стрим и в 1 метод стрима
     */
    public Boolean isNoneLocked(List<User> userList) {
        return null;
    }

    /**
     * Реализуйте метод через стрим который принимает в себя список пользователей,
     * и одним методом стрима выводит мапу где ключ это идентификатор пользователя, а значение сам пользователь
     *
     * P.s.: К сожалению у некоторых пользователей совпадает идентификатор,
     * поэтому будем брать только первых попавшихся, если это не решить будет IllegalStateException: Duplicate key 2
     */
    public Map<Integer, User> getUserIdToUserMap(List<User> userList) {
        return null;
    }

    /**
     * Реализуйте метод через стрим который принимает в себя список пользователей,
     * и находит шпиона среди них и выводит его на чистую воду
     *
     * P.s.: Мы предполагаем что шпион №4 в очереди
     */
    public User findSpy(List<User> userList) {
        return null;
    }

    /**
     * Одному джава-макаке стало интересно сложить номера домов у пользователей с 3го по 9е место
     *
     * Реализуйте метод через стрим который принимает в себя список пользователей,
     * и выводит сумму номеров домов согласно условию выше
     */
    public Long sumHouseNumbers(List<User> userList) {
        return null;
    }

    /**
     * Реализуйте метод который заполняем список пользователей (предварительно пустой)
     * данными из мапы в которой:
     * - ключ это ПОЛЕ которое нужно заполнить
     * - значение это еще одна мапа в которой, ключ это идентификатор пользователя, а значение - это значение ПОЛЯ по данному пользователю)
     * Например:
     *          Map.of(
     *                 "name", Map.of(
     *                         1, "Вадим",
     *                         2, "Даян",
     *                         3, "Ильгам",
     *                         4, "Ильнур"
     *                 ),
     *                 "country", Map.of(
     *                         1, "Россия",
     *                         2, "Турция",
     *                         3, "Кипр",
     *                         4, "Узбекистан"
     *                 );
     * В итоге в списке должны быть заполненный пользователи без дублей, например:
     *
     *  [
     *  User{
     *      id=3,
     *      rights=null,
     *      name='Ильгам',
     *      country='Кипр',
     *      city='Солнечный',
     *      street='Кукурузная',
     *      houseNumber=2,
     *      locked=false
     *      },
     *  User{
     *      id=2,
     *      rights=null,
     *      name='Даян',
     *      country='Турция',
     *      city='Сиде',
     *      street='Зеленая',
     *      houseNumber=43,
     *      locked=false
     *      }
     * ] - это вывод списка List<User> userList в консоли
     *
     * 1. Поле locked не приходит потому что создаем новых пользователей, ставим автоматом значение "false"
     * 2. Поле rights игнорируем
     * 3. Дублей не должно быть
     */
    public List<User> getListUser(Map<String, Map<Integer, String>> map) {
        List<User> userList = new ArrayList<User>();
        //Здесь одним стримом добавьте заполненных пользователей в список выше
        return userList;
    }

}
