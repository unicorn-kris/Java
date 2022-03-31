package com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions;

public final class IncorrectNumberException extends CarParkException{
    public IncorrectNumberException(int number) {
        super("Incorrect number " + number);
    }
}
