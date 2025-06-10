package vagapov.core.block_three;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

/**
 * Здесь нужно создать свое новое исключение
 * Исключение будет использовано когда мы не будем получать от стороннего сервиса ответ втечении 5 секунд запроса
 * 1. Исключение должно обрабатываться в рантайме или не обрабатываться вовсе
 * 2. Должно принимать в себя код ошибки и сообщение об ошибке (все тип String)
 * 3. Должно давать возможность (при обработке) достать код и сообщение и прочитать их
 */
public class UserServiceTimeoutException extends RuntimeException{
    public String errorCode;
    public String message;
    public UserServiceTimeoutException (String e, String cause){
        this.errorCode = e;
        this.message = cause;
    }


    public UserServiceTimeoutException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return errorCode;
    }

    public String getMessage(){
        return message;//правильно ли я сделал?        return cause;
    }
}

class ClientConnectionUserServiceException extends HttpClientErrorException {
    public String message;

    public ClientConnectionUserServiceException(HttpStatusCode statusCode, String statusText, String message) {
        super(statusCode, statusText);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
class ServerConnectionUserServiceException extends HttpServerErrorException {
    public String message;

    public ServerConnectionUserServiceException(HttpStatusCode statusCode, String statusText, String message) {
        super(statusCode, statusText);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}