package com.ssu.kristina_chernova.java.lesson_5.task_1.exceptions;

public class NoRemovePassengerException extends CarParkException{
    public NoRemovePassengerException(String transportType) {
        super("Have no passengers in " + transportType);
    }
}
