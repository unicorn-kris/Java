package com.ssu.kristina_chernova.java.lesson_5.task_1.exceptions;

public class NotUniqueNumber extends CarParkException{
    public NotUniqueNumber(int number) {
        super("In base exists transport with number " + number);
    }
}
