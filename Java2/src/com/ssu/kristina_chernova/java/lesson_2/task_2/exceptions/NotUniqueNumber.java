package com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions;

public class NotUniqueNumber extends CarParkException{
    public NotUniqueNumber(int number) {
        super("In base exists transport with number " + number);
    }
}
