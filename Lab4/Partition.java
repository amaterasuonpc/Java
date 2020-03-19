package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Partition {
    Hospital hos;
    int maxcapacity;
    int currentcapacity = 0;
    List<Resident> residents = new ArrayList<>();

    public Partition(Hospital hos) {
        this.hos = hos;
        this.maxcapacity = hos.getCapacity();
    }

    public void addResidents(Resident res) {
        this.residents.add(res); //Adaugam un resident la partitie si marim capacitatea curenta
        currentcapacity++;
    }

    public boolean isFull() {
        if (currentcapacity < maxcapacity)
            return false;
        else
            return true;
    }

    public Hospital getHos() {
        return hos;
    }

    public List<Resident> getResidents() {
        return residents;
    }
}
