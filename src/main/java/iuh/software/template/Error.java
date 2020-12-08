package iuh.software.template;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Error {

    protected HttpStatus status;
    protected String error;
    protected String message;

    private Error() {
    }

    private Error(String error, String message) {
        this.error = error;
        this.message = message;
    }

    private Error(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.error = status.name();
    }

    public static Error create(HttpStatus status, String message) {
        return new Error(status, message);
    }
}
