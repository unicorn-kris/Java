package com.ssu.kristina_chernova.java.lesson_5.task_1.exceptions;

public final class IncorrectNumberException extends CarParkException{
    public IncorrectNumberException(int number) {
        super("Incorrect number " + number);
    }
}
