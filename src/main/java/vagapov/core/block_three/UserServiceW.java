package vagapov.core.block_three;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

/**
 * Данная задача крайняя в этом блоке и объединяет в себя две предыдущие
 *
 * Вам нужно:
 * 1. Прочитать какие возможные проблемы есть при использовании класса RestTemplate и узнать какие есть специфические исключения
 * 2. Добавить отдельную обработку исключений на 4хх и 5хх ошибки
 * 3. В случае ошибок кидать только свои новосозданные ошибки
 * 4. Добавить обработку своего исключения UserServiceTimeoutException и тех исключений какие считаете нужным
 * 5. Добавить логгер и понятное логирование в два метода по уровням принятым ранее в задаче SendService
 *
 * В блоке 3 есть директория куда нужно добавлять свои исключения (exception)
 */
public class UserServiceW {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceW.class);
    private final RestTemplate restTemplate;

    public UserServiceW(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String createUser(UUID userId, String request) {
        ResponseEntity<String> responseEntity;
        LOGGER.debug("request for creating new user with ID:{} , request was :{}",  userId, request);
        try {
            responseEntity = restTemplate.postForEntity(
                    "URL",
                    request,
                    String.class,
                    Map.of("userId", userId.toString()));
            LOGGER.info("user with ID: {} created",  userId);
        }
        catch (UserServiceTimeoutException ex){
            LOGGER.error("was trying to create user with id :{}, but was caught at method createUser", userId, ex);
            throw new UserServiceTimeoutException(ex.toString(), ex.getMessage());
        }
        catch (HttpClientErrorException e){
            LOGGER.error("was trying to create user with id :{}, but {} was caught at method createUser with code {}", userId, e, e.getStatusCode());
            throw new ClientConnectionUserServiceException( e.getStatusCode(), e.getStatusText(), e.getMessage());
        }
        catch (HttpServerErrorException ex){
            LOGGER.error("was trying to create user with id :{}, but {} was caught at method createUser with code {}", userId, ex, ex.getStatusCode());
            throw new ServerConnectionUserServiceException( ex.getStatusCode(), ex.getStatusText(), ex.getMessage());
        }
        catch (Exception ex) {
            LOGGER.error("was trying to create user with id :%s, but %s was caught at method createUser", userId, ex);
            throw new RuntimeException(ex);
        }
        if (responseEntity != null && responseEntity.getBody() != null) {
            return responseEntity.getBody();
        } else {
            LOGGER.warn("user with id %s wasn't created; with request: %s", userId,  request);
            return null;
        }
    }

    public void deleteUser(UUID userId) {
        LOGGER.debug("deleting user with ID %s: ", userId);
        try {
            restTemplate.delete("URL", Map.of("userId", userId.toString()));
            LOGGER.info("user with ID: %s deleted",  userId);
        } catch (UserServiceTimeoutException ex){
            LOGGER.error("was trying to create user with id :%s, but %s was caught at method createUser", userId, ex);
            throw new UserServiceTimeoutException(ex.toString(), ex.getMessage());
        }  catch (HttpClientErrorException ex){
            LOGGER.error("was trying to create user with id :%s, but %s was caught at method createUser with code %s", userId, ex, ex.getStatusCode());
            throw new ClientConnectionUserServiceException( ex.getStatusCode(), ex.getStatusText(), ex.getMessage());
        }
        catch (HttpServerErrorException ex){
            LOGGER.error("was trying to create user with id :%s, but %s was caught at method createUser with code %s", userId, ex, ex.getStatusCode());
            throw new ServerConnectionUserServiceException( ex.getStatusCode(), ex.getStatusText(), ex.getMessage());
        }
        catch (Exception ex) {
            LOGGER.error("was trying to create user with id :%s, but %s was caught at method createUser", userId, ex);
            throw new RuntimeException(ex);
        }
    }
}
