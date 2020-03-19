package com.company;

import java.util.List;
import java.util.Map;

public class Problem {

    List<Resident> residents;
    List<Hospital> hospitals;
    Map<Hospital, List<Resident>> hosPrefList;
    Map<Resident, List<Hospital>> resPrefList;
    Matching solution = new Matching();

    public Problem(List<Resident> residents, List<Hospital> hospitals, Map<Hospital, List<Resident>> hosPrefList, Map<Resident, List<Hospital>> resPrefList) {
        this.residents = residents;
        this.hospitals = hospitals;
        this.hosPrefList = hosPrefList;
        this.resPrefList = resPrefList;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }


    public void createSolution() {
        Partition tempPart;

        for (Hospital temp : hospitals) { //Pentru fiecare spital cream o partitie in care adaugam residents
            tempPart = new Partition(temp);
            for (Resident temp1 : residents) {
                if (samePreference(temp1, temp)) { //Adaugam in functie de preferintele amandurora

                    if (!tempPart.isFull()) { //Verificam sa mai fie loc in partitie


                        tempPart.addResidents(temp1);

                    }

                }
                solution.addPart(tempPart);
            }
            for (Resident temp1 : tempPart.getResidents()) {
                residents.remove(temp1); // Fiecare resident care a fost adaugat la o partitie va fi scos din lista mare pentru a nu aparea la 2 spitale diferite in acelasi timp

            }

        }

    }

    public Matching getSolution() {
        return solution;
    }

    public boolean samePreference(Resident res, Hospital hos) {
        boolean ok1 = false;//se verifica ca resident si hospital sa aiba preferinta comuna -> Res vrea la Hos si Hos il vrea pe Res
        boolean ok2 = false;
        for (Resident temp : hosPrefList.get(hos)) {
            if (temp.equals(res)) {
                ok1 = true;

            }
        }
        for (Hospital temp : resPrefList.get(res)) {
            if (temp.equals(hos)) {
                ok2 = true;

            }
        }
        return ok1 && ok2;

    }

}
