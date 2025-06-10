package vagapov.core.block_five;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DynamicArrayTest {
    private final DynamicArray dynamicArray = new DynamicArray();

    @Test
    void test() {
        //Раскомментировать данные строки после решения задачи

        assertDoesNotThrow(() -> {
            System.out.println("Проверяем что в начале динамический массив пустой");
            Object[] array = dynamicArray.getArray();
            assertEquals(0, array.length);
        }, "В начале динамический массив оказался не пустой!");

        assertDoesNotThrow(() -> {
            System.out.println("Проверяем добавление элементов в динамический массив");
            dynamicArray.add("String");
            dynamicArray.add("Movie");
            dynamicArray.add("Name");
            Object[] array = dynamicArray.getArray();
            assertEquals(3, array.length);
        }, "Ошибка при добавлении элементов в динамический массив");

        assertDoesNotThrow(() -> {
            System.out.println("Проверяем удаление элементов из динамического массива");
            dynamicArray.remove(0);
            dynamicArray.remove(1);
            Object[] array = dynamicArray.getArray();
            assertEquals(1, array.length);
        }, "Ошибка при удалении элементов из динамического массива");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            System.out.println("Проверяем что выкидывается ошибка если индекс некорректный при удалении");
            dynamicArray.remove(3);
        }, "Ошибка ArrayIndexOutOfBoundsException не была выброшена в случае некорректного индекса при удалении");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            System.out.println("Проверяем что выкидывается ошибка если индекс некорректный при запросе элемента");
            dynamicArray.get(3);
        }, "Ошибка ArrayIndexOutOfBoundsException не была выброшена в случае некорректного индекса при запросе элемента");
        }

    }

