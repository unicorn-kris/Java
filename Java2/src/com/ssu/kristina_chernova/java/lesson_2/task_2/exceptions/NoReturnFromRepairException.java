package com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions;

public class NoReturnFromRepairException extends CarParkException{
    public NoReturnFromRepairException(int number) {
        super("Can't return transport with number " + number);
    }
}
