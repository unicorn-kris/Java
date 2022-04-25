package com.ssu.kristina_chernova.java.lesson_5.task_1.exceptions;

public class NoReturnFromRepairException extends CarParkException{
    public NoReturnFromRepairException(int number) {
        super("Can't return transport with number " + number);
    }
}
