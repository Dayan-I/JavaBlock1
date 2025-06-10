package vagapov.core.block_four;

import vagapov.core.block_four.model.UserResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Задача из рабочего процесса
 * Приходит от стороннего сервиса ответ в виде файла с расширением .xml
 * Нам нужно его распарсить в объекты и работать дальше с объектами в нашей программе
 *
 * 1. Файл который нужно распарсить лежит по пути: /response/responseUser.xml
 * 2. Прочитайте про парсинг xml сообщений (на хабре есть отличная статья)
 * 3. В данном блоке есть директория "model" там лежит внешний класс "UserResponse" дополните его и если нужно создайте новые классы
 * 4. Если приступили к этой задаче после парсинга json то используйте те же модельки
 * P.s.: чтобы добраться до файла есть хороший метод "getResourceAsStream()"
 */
public class ParsingResponseXml {

    public UserResponse method() throws JAXBException, IOException {
        InputStream user_resp = ParsingResponseXml.class.getResourceAsStream("C:/Java/TestTask/LearnCore/src/main/resources/response/responseUser.xml");// через try with resource делать?

        try (BufferedReader br = new BufferedReader(new InputStreamReader(user_resp))) {
            String body;
            body = br.lines().collect(Collectors.joining());
            StringReader reader = new StringReader(body);
            JAXBContext context = JAXBContext.newInstance(UserResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (UserResponse) unmarshaller.unmarshal(reader);
        }
    }
}


