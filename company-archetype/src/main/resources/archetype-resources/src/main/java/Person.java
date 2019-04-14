package ${package};

import org.apache.log4j.Logger;

public class Person {
    private static final Logger LOGGER = Logger.getLogger(Person.class);

    String surname;
    String name;
    String company;

    Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
        LOGGER.info(this.toString() + " created");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
        LOGGER.info("Company is set to " + this.toString());
    }

    @Override
    public String toString() {
        return String.format("Person {surname=%s; name=%s; company=%s}", surname, name, company);
    }
}
