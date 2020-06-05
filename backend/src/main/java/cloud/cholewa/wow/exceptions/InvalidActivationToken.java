package cloud.cholewa.wow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidActivationToken extends RuntimeException{
    public InvalidActivationToken(String message) {
        super(message);
    }
}
