package vagapov.core.block_three;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Будем работать с логированием
 * <p>
 * Примем в команде по уровням:
 * info  - логируем информацию для отслеживания запроса
 * debug - для отладки, например может быть большой запрос и постоянно им засорять логи не очень, но если ошибки какие-то - включим и посмотрим
 * warn  - если из-за каких либо проблем дальнейшая работа по запросу не проводится или проводится с ограничениями
 * error - логируем явные ошибки
 * <p>
 * 1. Объявите логгер данного класса в классе (не в методе)
 * 2. Добавьте логирование там где думаете оно нужно
 * <p>
 * Тестов в этом блоке не будет, как сделаете - показываете мне за день до ревью, вместе смотрим и если что даю на доработку
 */
@Service
public class SendService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendService.class);

    private final RestTemplate restTemplate;

    public SendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String createUser(UUID userId, String request) {
        ResponseEntity<String> responseEntity;
        LOGGER.debug("request for creating new user with ID: " + userId + "; request was: " + request);
        try {
            responseEntity = restTemplate.postForEntity(
                    "URL",
                    request,
                    String.class,
                    Map.of("userId", userId.toString()));
            LOGGER.info("user " + userId + " created");
        } catch (Exception ex) {
            LOGGER.error("was trying to create user with id " + userId + "; but exception was caught at method createUser");
            throw new RuntimeException(ex);

        }
        if (responseEntity != null && responseEntity.getBody() != null) {
            return responseEntity.getBody();
        } else {
            LOGGER.warn("user with user id" + userId + " wasn't created;" + " with request: " + request);
            return null;
        }
    }

    public void deleteUser(UUID userId) {
        LOGGER.debug("deleting new user with ID: " + userId);
        try {
            restTemplate.delete("URL", Map.of("userId", userId.toString()));
            LOGGER.info("user " + userId + " was deleted");
        } catch (Exception ex) {
            LOGGER.error("was trying to delete user with id " + userId + "; but exception was caught at method deleteUser");
            throw new RuntimeException(ex);
        }
    }

}
