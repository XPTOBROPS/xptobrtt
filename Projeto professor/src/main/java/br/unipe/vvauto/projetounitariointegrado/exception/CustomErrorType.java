package br.unipe.vvauto.projetounitariointegrado.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a custom error type for API responses. This class provides a standard structure
 * for error messages returned by the application, including a timestamp, a message, and a list of errors.
 * It is used to encapsulate error details in a consistent format for clients.
 *
 * <p>
 * Main fields:
 * <ul>
 *   <li><b>timestamp</b>: The date and time when the error occurred.</li>
 *   <li><b>message</b>: A description of the error.</li>
 *   <li><b>errors</b>: A list of specific error messages or validation issues.</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class is annotated with Lombok annotations for boilerplate code reduction and Jackson annotations
 * for JSON serialization.
 * </p>
 *
 * @author Carlos Diego Quirino Lima
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorType {
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;
    @JsonProperty("message")
    private String message;
    @JsonProperty("errors")
    private List<String> errors;

    public CustomErrorType(CalculatorException e) {
        this.timestamp = LocalDateTime.now();
        this.message = e.getMessage();
        this.errors = new ArrayList<>();
    }
}
