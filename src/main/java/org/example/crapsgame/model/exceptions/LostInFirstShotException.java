package org.example.crapsgame.model.exceptions;

public class LostInFirstShotException extends Exception{

    public LostInFirstShotException() {
        super();
    }

    public LostInFirstShotException(String message) {
        super(message);
    }

    public LostInFirstShotException(String message, Throwable cause) {
        super(message, cause);
    }

    public LostInFirstShotException(Throwable cause) {
        super(cause);
    }
}
