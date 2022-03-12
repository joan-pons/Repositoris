package cat.paucasesnoves.swdws.practicaspring.interins.errades;

import org.springframework.http.HttpStatus;

public class InterinsException extends RuntimeException{
private HttpStatus status;

    public InterinsException() {
    }

    public InterinsException(HttpStatus status) {
        this.status = status;
    }

    public InterinsException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
