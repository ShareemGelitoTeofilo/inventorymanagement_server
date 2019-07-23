package inventorymanagementserver.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(InventoryException.class)
    protected ResponseEntity<Object> handleConflict(InventoryException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
