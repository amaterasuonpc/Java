package com.company;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Matching {
    Hospital hos;
    List<Resident> residents;
    Map<Hospital, List<Resident>> solution = new TreeMap<>();


    public void addPart(Partition partTemp) {

        solution.put(partTemp.getHos(), partTemp.getResidents()); //Adaugam partitia creata la map


    }

    public void setHos(Hospital hos) {
        this.hos = hos;
    }


    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public Map<Hospital, List<Resident>> getSolution() {

        return solution;
    }


}
