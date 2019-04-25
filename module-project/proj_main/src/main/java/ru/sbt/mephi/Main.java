package ru.sbt.mephi;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class Main {
    List<Person> persons = new LinkedList();
    List<Company> companies = new LinkedList();

    public static void main(String[] args) {
        Main state = new Main();
        Person p1 = new Person("Lebedev", "Egor");
        state.addPerson(p1);
        Person p2 = new Person("Belova", "Valeria");
        state.addPerson(p2);
        Company c1 = new Company("Roga&Kopyta");
        state.addCompany(c1);
        c1.addEmployee(p1);
        c1.setBoss(p2);
        c1.addEmployee(p2);
        c1.setBoss(p2);
        System.out.println(state.getState());
    }

    private String getState() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public void addCompany(Company company) {
        this.companies.add(company);
    }
}