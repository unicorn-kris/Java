package com.ssu.kristina_chernova.java.lesson_4.Task_1;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private Object[] array;
    private int capacity;
    private int length;

    public int getCapacity() {return capacity;}

    public int getLength() {return length;}

    public DynamicArray(int size){
        capacity = 1;
        while (capacity < size){
            capacity *= 2;
        }
        array = new Object[capacity];
    }

    public void add(T t){
        if (length < capacity){
            array[length] = t;
            length += 1;
        }
        else{
            capacity *= 2;
            Object[] newArray = new Object[capacity];
            for(int i = 0; i < array.length; ++i){
                newArray[i] = array[i];
            }
            newArray[array.length] = t;
            array = newArray;
            length += 1;
        }
    }

    public T get(int index) {
        if (index < length) {
            return (T)array[index];
        }
        else {
            System.out.println("Incorrect Index");
        }
        return null;
    }

    public void set(T t, int index){
        if (index < length) {
            array[index] = t;
        }
        else {
            System.out.println("Incorrect Index");
        }
    }

    public void remove(int index){
        if (index < length) {
            for (int i = index; i < length - 1; ++i) {
                array[i] = array[i + 1];
            }
            length -= 1;
        }
        else {
            System.out.println("Incorrect Index");
        }
    }

    public void toStringDA() {
        System.out.println("Length " + length + "\n");
        System.out.println("Capacity " + capacity + "\n");

        for (int i = 0; i < length; ++i){
                System.out.println("Index: "+ i +" Element: " + array[i].toString()+"\n");
        }
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Length ").append(length).append("\n");
        stringBuilder.append("Capacity ").append(capacity).append("\n");

        for (int i = 0; i < length; ++i){
            stringBuilder.append("Index: ").append(i).append(" Element: ").append(array[i].toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>() {
            private int i = 0;

            //Returns true if the array has more elements.

            @Override
            public boolean hasNext() {
                return (i < length && array[i] != null);
            }

            //Returns the next element in the iteration.

            @Override
            public T next() {
                if (hasNext()) {
                    return (T)array[i++];
                }
                return null;
            }
        };
    }
}

class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>(3);
        dynamicArray.add(24);
        dynamicArray.add(45);
        dynamicArray.add(43);
        dynamicArray.add(77);
        dynamicArray.toStringDA();
        int m = dynamicArray.get(2);
        dynamicArray.set(100, 2);
        dynamicArray.remove(3);
        dynamicArray.toStringDA();

        System.out.println("Iterator try:");
        for (Object a : dynamicArray){
            if (a != null) {
                System.out.println("Element: " + a + "\n");
            }
        }

        System.out.println("toString try:");
        DynamicArray<Double> dynamicArrayDouble = new DynamicArray<Double>(3);
        dynamicArrayDouble.add(24.99);
        System.out.println(dynamicArrayDouble.toString());
    }
}
