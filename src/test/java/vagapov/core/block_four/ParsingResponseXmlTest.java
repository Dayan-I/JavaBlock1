package vagapov.core.block_four;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import vagapov.core.block_four.model.UserResponse;

import javax.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ParsingResponseXmlTest {

    private final ParsingResponseXml parser = new ParsingResponseXml();


    @Test
    void test() throws JAXBException, IOException {
        UserResponse response = parser.method();

        assertNotNull(response);
        assertEquals("SUCCESS", response.getStatus());
        assertEquals("986432878721", response.getUserId());
        assertEquals("Иванов Иван Иванович", response.getFullName());
        assertEquals("Иван", response.getFirstName());
        assertEquals("Иванов", response.getLastName());
        assertEquals("Иванович", response.getMiddleName());
        assertNotNull(response.getDocuments());
        assertNotNull(response.getAddresses());
        assertEquals(2, response.getDocuments().size());
        assertEquals(2, response.getAddresses().size());
        assertTrue(response.getDocuments().stream().anyMatch(doc -> "true".equals(doc.getIdentification())));
        assertTrue(response.getDocuments().stream().anyMatch(doc -> "false".equals(doc.getIdentification())));
    }
}
