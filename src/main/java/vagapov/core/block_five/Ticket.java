package vagapov.core.block_five;

/**
 * Параметризуйте данный класс и добавьте ему возможность хранить один объект класса, которым он параметризирован в поле с названием object
 *
 * Требования:
 * 1. Класс должен быть параметризован T.
 * 2. Поле должно отвечать требованиям приватности с именем object.
 * 3. Добавьте геттеры и сеттеры
 * 4. Добавьте статический метод 'getTicket()' который бы возвращал пустой объект данного класса
 */
public class  Ticket <T> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public static <T> Ticket<T> getTicket(){
        return new Ticket<T>();
    }
}
