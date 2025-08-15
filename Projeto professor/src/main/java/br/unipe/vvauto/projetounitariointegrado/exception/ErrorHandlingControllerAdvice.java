package br.unipe.vvauto.projetounitariointegrado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Global exception handler for the application. This class defines how errors are formatted and returned
 * by the API, providing a consistent structure for error responses. It handles custom exceptions,
 * validation errors, and constraint violations, returning a {@link CustomErrorType} object with details
 * about the error.
 *
 * <p>
 * Main responsibilities:
 * <ul>
 *   <li>Format error responses with timestamp, message, and list of errors.</li>
 *   <li>Handle {@link CalculatorException} and return a BAD_REQUEST response.</li>
 *   <li>Handle validation errors from {@code @Valid} annotated controllers.</li>
 *   <li>Handle {@link ConstraintViolationException} and return validation error details.</li>
 * </ul>
 * </p>
 *
 * @author Carlos Diego Quirino Lima
 */
@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    /**
     * Define o formato padrão de definição do Erro que será
     * retornado pela API nesta Aplicação Web
     * @param message - Mensagem de erro
     * @return CustomErrorType - Tipo de erro personalizado
     */
    private CustomErrorType defaultCustomErrorErrorTypeConstruct(String message) {
        return CustomErrorType.builder()
                .timestamp(LocalDateTime.now())
                .errors(new ArrayList<>())
                .message(message)
                .build();
    }

    /**
     * Define o "manuseador" para quando, de qualquer parte da
     * Aplicação Web, uma exceção do tipo CalculatorException
     * for lançada
     * @param calculatorException - Exceção Global do projeto
     * @return CustomErrorType - Tipo de Erro Personalizado
     */
    @ExceptionHandler(CalculatorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorType onCommerceException(CalculatorException calculatorException) {
        return defaultCustomErrorErrorTypeConstruct(
                calculatorException.getMessage()
        );
    }

    /*
    Daqui, abaixo, seguem os tratamentos dos erros oriundos das
    validações nos controladores: @Valid (jakarta.validation)
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorType onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        CustomErrorType customErrorType = defaultCustomErrorErrorTypeConstruct(
                "Erros de validacao encontrados"
        );
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            customErrorType.getErrors().add(fieldError.getDefaultMessage());
        }
        return customErrorType;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorType onConstraintViolation(ConstraintViolationException e) {
        CustomErrorType customErrorType = defaultCustomErrorErrorTypeConstruct(
                "Erros de validacao encontrados"
        );
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            customErrorType.getErrors().add(violation.getMessage());
        }
        return customErrorType;
    }
}
