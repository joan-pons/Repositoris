package cat.paucasesnoves.swdws.practicaspring.interins.errades;

import cat.paucasesnoves.swdws.practicaspring.interins.auxiliars.Missatge;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InterinsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InterinsException.class)
    protected ResponseEntity<Object> errorInterins(InterinsException ex, WebRequest request) {
        HttpHeaders capsaleres = new HttpHeaders();
        capsaleres.set("Content-Type", "application/json");
        return handleExceptionInternal(ex, new Missatge(ex.getMessage()), capsaleres, ex.getStatus(), request);
    }

}
