package sg.spring.core.factory.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FactoryExceptionHandler {

    @ExceptionHandler(FactoryInstanceRetrievalException.class)
    public void handleException(FactoryInstanceRetrievalException e, HttpServletResponse response) {
        //TODO return http response here
    }
}
