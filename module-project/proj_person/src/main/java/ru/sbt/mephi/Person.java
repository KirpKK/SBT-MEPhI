package ru.sbt.mephi;

import org.apache.log4j.Logger;

public class Person {
    private static final Logger LOGGER = Logger.getLogger(Person.class);

    String surname;
    String name;

    Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
        LOGGER.info(this.toString() + " created");
    }

    @Override
    public String toString() {
        return String.format("Person {surname=%s; name=%s}", surname, name);
    }
}
