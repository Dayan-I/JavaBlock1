package vagapov.core.block_two;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HumanTest {

    @Test
    void test() {
        Human oldHuman = new Human("secret", "news", "experiince", "gossip");

        /**
         * Раскоментируйте данный код когда будете уверены что решили задачу в классе Human
         */
        assertNotNull(oldHuman.getSecret());
       assertNotNull(oldHuman.getNews());
       assertNotNull(oldHuman.getExperience());
        assertNotNull(oldHuman.getGossip());

       Human newHuman = new Human();
        assertNull(oldHuman.getSecret());
       assertNull(oldHuman.getNews());
        assertNull(oldHuman.getExperience());
        assertNull(oldHuman.getGossip());
    }
}
