package com.example.calcumv20.Util;

public class IncorrectStackContentException extends RuntimeException {
    public IncorrectStackContentException() {}
    public IncorrectStackContentException(String errorMessage) {
        super(errorMessage);
    }
}
