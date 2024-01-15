package academy.devdojo.springboot2essentials.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developMessage;
    private LocalDateTime timestamp;
}
