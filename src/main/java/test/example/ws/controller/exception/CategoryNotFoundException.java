package test.example.ws.controller.exception;

public class CategoryNotFoundException extends RuntimeException{
    private String message;

    public CategoryNotFoundException() {}

    public CategoryNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

}
