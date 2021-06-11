package com.codegym.task.task38.task3804;

public class ExceptionFactory extends Exception {

    public static Throwable getRequiredException(Enum enumm) {
        if (enumm == null)
            return new IllegalArgumentException();
        char firstChar = enumm.name().charAt(0);
        String errorMessage = firstChar + enumm.name().replace("_", " ").toLowerCase().substring(1);
        if (enumm instanceof DatabaseExceptionMessage) {
            return new RuntimeException(errorMessage);
        } else if (enumm instanceof ApplicationExceptionMessage) {
            return new Exception(errorMessage);
        } else if (enumm instanceof UserExceptionMessage) {
            return new Error(errorMessage);
        } else return new IllegalArgumentException();
    }
}
