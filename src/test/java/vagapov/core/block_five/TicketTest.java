package vagapov.core.block_five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TicketTest {

    @Test
    void test() {
        //Раскомментировать данные строки после решения задачи

        assertDoesNotThrow(() -> {
            System.out.println("Проверяем что можно создать объект Ticket через метод getTicket() и что объект будет работать с типом String");
            Ticket<String> stringTicket = Ticket.getTicket();
            stringTicket.setObject("Name");
            String ticketObject = stringTicket.getObject();
            assertEquals("Name", ticketObject);
        }, "Не получилось создать объект через метод getTicket() или параметризовать типом String");

        assertDoesNotThrow(() -> {
            System.out.println("Проверяем что можно создать объект Ticket через конструктор и что объект будет работать с типом Integer");
            Ticket<Integer> integerTicket = new Ticket<>();
            integerTicket.setObject(12);
            Integer ticketObject = integerTicket.getObject();
            assertEquals(12, ticketObject);
        }, "Не получилось создать объект через конструктор или параметризовать типом Integer");
    }
}
