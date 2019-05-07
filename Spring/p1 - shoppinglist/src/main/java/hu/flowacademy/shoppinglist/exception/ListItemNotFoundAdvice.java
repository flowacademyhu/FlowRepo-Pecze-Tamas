package hu.flowacademy.shoppinglist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ListItemNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ListItemNotFoundExeption.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String listItemNotFoundHandler(ListItemNotFoundExeption e) {
        return e.getMessage();
    }
}
