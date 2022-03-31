package com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions;

public class NoRemovePassengerException extends CarParkException{
    public NoRemovePassengerException(String transportType) {
        super("Have no passengers in " + transportType);
    }
}
