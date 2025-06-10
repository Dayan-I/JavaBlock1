package vagapov.core.block_five;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 * Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение.
 * Сделайте класс DynamicArray так, чтобы он хранил в себе массив,
 * и имел методы для добавления void add(T el), void remove(int index) удаления и извлечения T get(int index) из него элементов,
 * при переполнении текущего массива, должен создаваться новый, большего размера.
 * <p>
 * Для возможности работы с различными классами DynamicArray должен быть дженериком.
 * Для решения задачи можно воспользоваться методами из класса java.util.Arrays.
 * Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно
 * <p>
 * Требования:
 * 1. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index) и геттер на поле
 * 2. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
 * 3. класс DynamicArray должен иметь публичный конструктор по умолчанию
 * 4. работа методов должна соответствовать условию
 */
public class DynamicArray<T> {
    private T[] arr = (T[]) new Object[0];

    public DynamicArray() {

    }

    public void add(T el) {
        this.arr = Arrays.copyOf(this.arr, arr.length + 1);
        this.arr[arr.length-1] = el;
    }

    public void remove(int index) {
        if (index > arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            T[] arr1 = Arrays.copyOf(this.arr, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                if (i != index) {
                    arr1[i] = arr[i];
                } else if (i == index) {
                    for (int j = index + 1; j < arr.length - 1; j++) {
                        arr1[i] = arr[i + 1];
                    }
                }
                break;
            }
            this.arr = Arrays.copyOf(arr1, arr1.length);
        }
    }

    public T get(int index){
        if ( index > arr.length){
            throw new ArrayIndexOutOfBoundsException();
        } else return arr[index];
    }

    public T[] getArray() {
        return arr;
    }
}