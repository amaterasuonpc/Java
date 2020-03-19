package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Resident implements Comparator<Resident> {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Resident(String name) {
        this.name = name;
    }


    @Override
    public int compare(Resident o1, Resident o2) {

        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Resident)) {
            return false;
        }
        Resident temp = (Resident) obj;
        return this.name.equals(temp.getName());


    }

    @Override
    public String toString() {
        return this.getName();
    }
}
