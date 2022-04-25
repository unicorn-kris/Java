package com.ssu.kristina_chernova.java.lesson_5.task_1.entities;

public class Tram extends Transport{
    private transient int lengthTrack;

    public int getLengthTrack() {return lengthTrack;}
    public void setLengthTrack(int newLengthTrack) {lengthTrack = newLengthTrack;}
}
