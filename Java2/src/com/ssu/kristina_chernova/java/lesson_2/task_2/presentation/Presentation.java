package com.ssu.kristina_chernova.java.lesson_2.task_2.presentation;

import com.ssu.kristina_chernova.java.lesson_2.task_2.entities.*;
import com.ssu.kristina_chernova.java.lesson_2.task_2.entities.enums.EngineType;
import com.ssu.kristina_chernova.java.lesson_2.task_2.exceptions.IncorrectNumberException;

import java.util.Scanner;

import static java.lang.System.exit;

public class Presentation {

    public static void main(String[] args) throws Exception {
        Presentation app = new Presentation();
        app.startApplication();
    }

    private final Scanner in = new Scanner(System.in);

    private void startApplication() throws Exception {

        CarPark carPark = new CarPark();

        while (true) {
            System.out.println("""
                    Enter action:
                    1 - Add car park name
                    2 - Add transport in car park
                    3 - Remove transport from car park
                    4 - Repair transport
                    5 - Return transport from repair
                    0 - Exit""");

            try {
            Scanner inSc = new Scanner(System.in);
            int choice = inSc.nextInt();

                switch (choice) {
                    case 0 -> exit(0);
                    case 1 -> addCarParkName(carPark);
                    case 2 -> addTransportInCarPark(carPark);
                    case 3 -> removeTransportFromCarPark(carPark);
                    case 4 -> repairTransport(carPark);
                    case 5 -> returnTransportFromRepair(carPark);
                    default -> System.out.println("Enter correct action!");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    private void addCarParkName(CarPark carPark) {
        System.out.println("Enter name");
        carPark.setName(in.next());
    }

    private void returnTransportFromRepair(CarPark carPark) {
        System.out.println("Enter number");
        int num = in.nextInt();
        try{
            carPark.returnTransportFromRepair(num);
        }
        catch(IncorrectNumberException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void repairTransport(CarPark carPark) {
        System.out.println("Enter number");
        int num = in.nextInt();
        try{
            carPark.repairTransport(num);
        }
        catch(IncorrectNumberException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void removeTransportFromCarPark(CarPark carPark) {
        System.out.println("Enter number");
        int num = in.nextInt();
        try{
            carPark.removeTransport(num);
        }
        catch(IncorrectNumberException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void addTransportInCarPark(CarPark carPark) {
        System.out.println("""
                    Enter action:
                    1 - Add bus
                    2 - Add tram
                    3 - Add trolleybus""");

        int choice = in.nextInt();


        switch (choice) {
            case 1 -> addBus(carPark);
            case 2 -> addTram(carPark);
            case 3 -> addTrolleybus(carPark);
            default -> System.out.println("Enter correct action!");
        }
    }

    private void addTrolleybus(CarPark carPark){
        Trolleybus trol = new Trolleybus();
        try {
            System.out.println("Enter number");
            trol.setNumber(in.nextInt());
            System.out.println("Enter max count of seats");
            trol.setCountSeats(in.nextInt());
            System.out.println("Enter max value of volt");
            trol.setVolt(in.nextInt());
            System.out.println("Enter fare");
            trol.setFare(in.nextInt());
            System.out.println("Enter max speed");
            trol.setMaxSpeed(in.nextInt());
            System.out.println("Does trolleybus has a card pay? 0 - yes, 1 - no");
            int choice = in.nextInt();
            switch (choice) {
                case 0 -> trol.setCardPay(true);
                case 1 -> trol.setCardPay(false);
                default -> System.out.println("Enter correct action!");
            }
            while(choice != 2) {
                System.out.println("Do you want to add or remove passengers? 0 - add, 1 - remove, 2 - no");
                choice = in.nextInt();
                switch (choice) {
                    case 0 -> trol.addPassenger();
                    case 1 -> trol.removePassenger();
                    case 2 -> {
                        break;
                    }
                    default -> System.out.println("Enter correct action!");
                }
            }
            trol.setEngineType(EngineType.ELECTRIC);
            carPark.addTransport(trol);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void addTram(CarPark carPark) {
        Tram tram = new Tram();
        try {
            System.out.println("Enter number");
            tram.setNumber(in.nextInt());
            System.out.println("Enter max count of seats");
            tram.setCountSeats(in.nextInt());
            System.out.println("Enter track length");
            tram.setLengthTrack(in.nextInt());
            System.out.println("Enter fare");
            tram.setFare(in.nextInt());
            System.out.println("Enter max speed");
            tram.setMaxSpeed(in.nextInt());
            System.out.println("Does tram has a card pay? 0 - yes, 1 - no");
            int choice = in.nextInt();
            switch (choice) {
                case 0 -> tram.setCardPay(true);
                case 1 -> tram.setCardPay(false);
                default -> System.out.println("Enter correct action!");
            }
            while(choice != 2) {
                System.out.println("Do you want to add or remove passengers? 0 - add, 1 - remove, 2 - no");
                choice = in.nextInt();
                switch (choice) {
                    case 0 -> tram.addPassenger();
                    case 1 -> tram.removePassenger();
                    case 2 -> {
                        break;
                    }
                    default -> System.out.println("Enter correct action!");
                }
            }
            tram.setEngineType(EngineType.ELECTRIC);
            carPark.addTransport(tram);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void addBus(CarPark carPark) {
        Bus bus = new Bus();
        try {
            System.out.println("Enter number");
            bus.setNumber(in.nextInt());
            System.out.println("Enter max count of seats");
            bus.setCountSeats(in.nextInt());
            System.out.println("Enter fare");
            bus.setFare(in.nextInt());
            System.out.println("Enter max speed");
            bus.setMaxSpeed(in.nextInt());
            System.out.println("Does bus has a card pay? 0 - yes, 1 - no");
            int choice = in.nextInt();
            switch (choice) {
                case 0 -> bus.setCardPay(true);
                case 1 -> bus.setCardPay(false);
                default -> System.out.println("Enter correct action!");
            }
            System.out.println("Does bus has a conductor? 0 - yes, 1 - no");
            choice = in.nextInt();
            switch (choice) {
                case 0 -> bus.setHaveCond(true);
                case 1 -> bus.setHaveCond(false);
                default -> System.out.println("Enter correct action!");
            }
            while(choice != 2) {
                System.out.println("Do you want to add or remove passengers? 0 - add, 1 - remove, 2 - no");
                choice = in.nextInt();
                switch (choice) {
                    case 0 -> bus.addPassenger();
                    case 1 -> bus.removePassenger();
                    case 2 -> {
                        break;
                    }
                    default -> System.out.println("Enter correct action!");
                }
            }
            bus.setEngineType(EngineType.PETROL);
            carPark.addTransport(bus);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
