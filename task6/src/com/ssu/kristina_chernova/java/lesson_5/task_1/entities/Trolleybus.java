package com.ssu.kristina_chernova.java.lesson_5.task_1.entities;

public class Trolleybus extends Transport {
    private transient int volt;

    public int getVolt() {return volt;}
    public void setVolt(int newVolt) {volt = newVolt;}
}
