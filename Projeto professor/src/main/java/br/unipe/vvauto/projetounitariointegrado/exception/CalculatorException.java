package br.unipe.vvauto.projetounitariointegrado.exception;

/**
 * Custom exception for calculator-related errors in the application.
 * <p>
 * This exception extends {@link RuntimeException} and is used to signal unexpected or specific
 * error conditions that occur during calculator operations. It provides constructors for a default
 * error message or a custom message.
 * </p>
 *
 * <ul>
 *   <li>Default constructor sets a generic error message.</li>
 *   <li>Parameterized constructor allows a custom error message.</li>
 * </ul>
 *
 * @author Carlos Diego Quirino Lima
 */
public class CalculatorException extends RuntimeException {
    public CalculatorException() {
        super("Unexpected error in Calculator!");
    }
    public CalculatorException(String message) {
        super(message);
    }
}
