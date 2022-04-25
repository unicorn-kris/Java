package com.ssu.kristina_chernova.java.lesson_5.task_1.entities;

import com.ssu.kristina_chernova.java.lesson_5.task_1.entities.enums.EngineType;
import com.ssu.kristina_chernova.java.lesson_5.task_1.exceptions.NoFreeSeatsException;
import com.ssu.kristina_chernova.java.lesson_5.task_1.exceptions.NoRemovePassengerException;

import java.io.Serializable;

public abstract class Transport implements Serializable {
    protected EngineType engineType;
    protected transient  int fare; //cost
    protected transient int countSeats;
    protected transient int countOccupiedSeats;
    protected transient int number;
    protected boolean cardPay;
    protected transient int maxSpeed;
    protected boolean repair;

    protected String name;

    public String getName() { return name; }

    public void setName(String newName) { name = newName; }

    public EngineType getEngineType() { return engineType; }

    public void setEngineType(EngineType newEngineType) {
        engineType = newEngineType;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int newFare) {
        fare = newFare;
    }

    public int getCountSeats() {
        return countSeats;
    }

    public void setCountSeats(int newCountSeats) {
        countSeats = newCountSeats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        number = newNumber;
    }

    public boolean getCardPay() {
        return cardPay;
    }

    public void setCardPay(boolean newCardPay) {
        cardPay = newCardPay;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int newMaxSpeed) {
        maxSpeed = newMaxSpeed;
    }

    public boolean getRepair() {
        return repair;
    }

    public void setRepair(boolean newRepair) {
        repair = newRepair;
    }

    public void addPassenger() throws NoFreeSeatsException {
        if (countOccupiedSeats != countSeats) {
            countOccupiedSeats += 1;
        } else {
            throw new NoFreeSeatsException(this.getClass().toString());
        }
    }

    ;

    public void removePassenger() throws NoRemovePassengerException {
        if (countOccupiedSeats != 0) {
            countOccupiedSeats -= 1;
        } else {
            throw new NoRemovePassengerException(this.getClass().toString());
        }
    }

    ;
}
