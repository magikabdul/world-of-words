package cloud.cholewa.wow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AccountCreationException extends RuntimeException{
    public AccountCreationException(String message) {
        super(message);
    }
}
