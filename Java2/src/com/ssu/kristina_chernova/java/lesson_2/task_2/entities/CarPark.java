package com.ssu.kristina_chernova.java.lesson_2.task_2.entities;

import com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions.IncorrectNumberException;
import com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions.NotUniqueNumber;

import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private List<Transport> transports;
    private String name;

    public CarPark(){
        transports = new ArrayList<>();
    }

    public List<Transport> getTransports() {return transports;}
    public void setTransports(List<Transport> newTransports) {transports = newTransports;}

    public String getName() {return name;}
    public void setName(String newName) {name = newName;}

    public void addTransport(Transport newTransport) throws NotUniqueNumber {
        if (transports.stream().noneMatch(s -> s.getNumber() == newTransport.getNumber())) {
            transports.add(newTransport);
        }
        else{
            throw new NotUniqueNumber(newTransport.getNumber());
        }
    }

    public void removeTransport(int number) throws IncorrectNumberException {
        if (transports.stream().anyMatch(s -> s.getNumber() == number)) {
            for (int i = 0; i < transports.size(); ++i) {
                if (transports.get(i).getNumber() == number) {
                    transports.remove(i);
                    break;
                }
            }
        }
        else{
            throw new IncorrectNumberException(number);
        }
    }

    public void repairTransport(int number) throws IncorrectNumberException {
        if (transports.stream().anyMatch(s -> s.getNumber() == number)) {
            for (Transport transport : transports) {
                if (transport.getNumber() == number) {
                    transport.setRepair(true);
                    break;
                }
            }
        }
        else{
            throw  new IncorrectNumberException(number);
        }
    }

    public void returnTransportFromRepair(int number) throws IncorrectNumberException {
        if (transports.stream().anyMatch(s -> s.getNumber() == number && s.getRepair())) {
            for (Transport transport : transports) {
                if (transport.getNumber() == number) {
                    transport.setRepair(true);
                    break;
                }
            }
        }
        else{
            throw new IncorrectNumberException(number);
        }
    }
}
