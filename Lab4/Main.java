package com.company;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();
        var r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident(faker.name().lastName()))
                .toArray(Resident[]::new);
        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));

        var h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);
        Set<Hospital> hospitalSet = new TreeSet<>();
        hospitalSet.addAll(Set.of(h));
        h[0].setCapacity(1);
        h[1].setCapacity(2);
        h[2].setCapacity(2);


        //Collections.sort(residentList); // Not working Unknown reason

        Collections.sort(residentList, ((r1, r2) -> r1.getName().compareTo(r2.getName())));



        Map<Resident, List<Hospital>> resPrefHos = new HashMap<>();

        resPrefHos.put(r[0], Arrays.asList(h[0], h[1], h[2])); // Lista de preferinte pentru residents
        resPrefHos.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefHos.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefHos.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hosPrefRes = new TreeMap<>();
        hosPrefRes.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2])); // Lista de preferinte pentru hospitals
        hosPrefRes.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefRes.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        residentList.stream()
                .filter(res -> resPrefHos.get(res).contains(h[0]))
                .forEach(System.out::println);
        System.out.println();
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        List<Resident> result = residentList.stream()
                .filter(res -> resPrefHos.get(res).containsAll(target))
                .collect(Collectors.toList());
        System.out.println(result);

        System.out.println(resPrefHos);
        System.out.println(hosPrefRes);

        Problem temp1 = new Problem(residentList, Arrays.asList(h), hosPrefRes, resPrefHos);
        temp1.createSolution();
        System.out.println(temp1.getSolution().getSolution());// temp1.getSolution returneaza un obiect de tipul Matching iar Matching.getSolution retu


    }
}
