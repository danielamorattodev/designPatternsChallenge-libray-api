package one.dio.designPatternsChallenglibrayapi.core.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerExceptionValidation {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FilterExceptionDTO> handlerError(MethodArgumentNotValidException exception) {
        List<FilterExceptionDTO> filterException = new ArrayList<>();
        List<ObjectError> objectErrors = exception.getBindingResult().getGlobalErrors();
        objectErrors.forEach(objectError -> {
            String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
            FilterExceptionDTO error = new FilterExceptionDTO(objectError.getObjectName(), message);
            filterException.add(error); //trata um objeto de erro inteiro
        });
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            FilterExceptionDTO error = new FilterExceptionDTO(fieldError.getField(), message);
            filterException.add(error); //trata apenas um campo.
        });
        return filterException;
    }


}
