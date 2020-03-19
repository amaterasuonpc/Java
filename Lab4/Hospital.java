package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements Comparable<Hospital> {
    private String name;
    private int capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public Hospital(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Hospital o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
