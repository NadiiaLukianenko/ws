package test.example.ws.controller.exception;

public class CategoryUnprocessableException extends RuntimeException {
    public CategoryUnprocessableException(String message) {
        super(message);
    }
}
