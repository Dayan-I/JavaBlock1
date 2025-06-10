package vagapov.core.block_six;

import vagapov.core.block_six.model.User;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Поработаем с функ-ми интерфейсами
 */
public class FunctionInterface<T, K> {
    /**
     * Напишите метод с названием sqrt, который возвращает реализацию функционального интерфейса UnaryOperator,
     * который принимает целое число(тип int) и возвращает его квадрат.
     * <p>
     * Требования:
     * 1. Метод должен возвращать реализацию интерфейса UnaryOperator.
     * 2. Параметризуйте метод так чтобы метод принимал только один целочисленный тип
     */
    public UnaryOperator<Integer> sqrt() {
        return x -> x * x;
    }

    /**
     * Создайте функциональный интерфейс getString(),
     * который принимает объект любого класса и возвращает его строковое представление
     * <p>
     * Требования:
     * 1. В случае когда приходит 'null' возвращать пустую строку
     */
    public UnaryOperator<T> getString() {
        return x -> x == null ? (T) "" : (T) x.toString();
    }

    /**
     * Создайте функциональный интерфейс sortUserByUserRight(),
     * который принимает два объекта класса User (лежит в папке model)
     * и возвращает пользователя у которого больше всего прав
     * <p>
     * Требования:
     * 1. В случае когда приходит 1 из пользователей = 'null' возвращать второго
     * 2. Когда двое пользователей null - выкидывать ошибку IllegalArgumentException
     * 3. Если у одного пользователя нашлись права "Owner" - сразу возвращать его.
     * 4. Если у двоих пользователей есть права "Owner" то возвращать у кого больше количества прав
     */
    public BinaryOperator<User> sortUserByUserRight() {
        Comparator<User> comparator = Comparator.comparing(User -> User.getRights().size());
        BinaryOperator<User> bo = BinaryOperator.maxBy(comparator);
        return (x, y) -> {
            if (x == null) {
                return y;
            } else if (y == null) {
                return x;
            } else if (x == null & y == null) {
                throw new IllegalArgumentException("null user");
            } else if (x.getRights().contains("Owner") && !y.getRights().contains("Owner")) {
                return x;
            } else if (y.getRights().contains("Owner") && !x.getRights().contains("Owner")) {
                return y;
            } else {
                return bo.apply(x, y);
            }
        };
    }

    /**
     * Создайте функциональный интерфейс sortUserByUserName(),
     * который принимает два объекта класса User (лежит в папке model)
     * и возвращает пользователя у которого имя идет первое при сортировке
     */
    public BinaryOperator<User> sortUserByUserName() {
        Comparator<User> comparator = Comparator.comparing(User::getName);
        //BinaryOperator<User> bo = BinaryOperator.maxBy(comparator);
        return (x, y) -> {
            List<User> names = new ArrayList<>();
            if (x == null) {
                return y;
            } else if (y == null) {
                return x;
            } else
                names.add(x);
                names.add(y);
                names.sort(comparator);
                return names.get(0);
        };
    }
}
