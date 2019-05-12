package hu.flowacademy.shoppinglist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ListItemNotFoundException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String todoItemNotFoundHandler(ListItemNotFoundException e) {
        return e.getMessage();
    }
}
