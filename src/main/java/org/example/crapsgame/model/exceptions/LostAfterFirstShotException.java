package org.example.crapsgame.model.exceptions;

public class LostAfterFirstShotException extends Exception {

    public LostAfterFirstShotException() {
        super();
    }

    public LostAfterFirstShotException(String message) {
        super(message);
    }

    public LostAfterFirstShotException(String message, Throwable cause) {
        super(message, cause);
    }

    public LostAfterFirstShotException(Throwable cause) {
        super(cause);
    }

}
