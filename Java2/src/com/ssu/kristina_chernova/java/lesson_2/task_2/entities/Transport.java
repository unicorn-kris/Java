package com.ssu.kristina_chernova.java.lesson_2.task_2.entities;

import com.ssu.kristina_chernova.java.lesson_2.task_2.entities.enums.EngineType;
import com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions.NoFreeSeatsException;
import com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions.NoRemovePassengerException;

public abstract class Transport {
    protected EngineType engineType;
    protected int fare; //cost
    protected int countSeats;
    protected int countOccupiedSeats;
    protected int number;
    protected boolean cardPay;
    protected int maxSpeed;
    protected boolean repair;

    public EngineType getEngineType() {
        return engineType;
    }

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
