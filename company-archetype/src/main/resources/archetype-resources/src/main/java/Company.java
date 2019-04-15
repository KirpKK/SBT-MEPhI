package ${package};

import org.apache.log4j.Logger;
import java.util.LinkedList;
import java.util.List;

public class Company {
    private static final Logger LOGGER = Logger.getLogger(Company.class);

    String name;
    Person boss;
    List<Person> employeeList;

    Company(String name) {
        this.name = name;
    }

    public void setBoss(Person boss) {
        if (employeeList.contains(boss)) {
            this.boss = boss;
            LOGGER.info("Boss " + boss.toString() + " is set to " + this.toString());
        } else {
            LOGGER.error(boss.toString() + " must be an employee to be a boss of " + this.toString());
        }
    }

    public void addEmployee(Person employee) {
        if (employeeList == null) employeeList = new LinkedList();
        this.employeeList.add(employee);
        LOGGER.info(employee.toString() + " is added to " + this.toString());
    }

    public void removeEmployee(Person employee) {
        if (employeeList != null) this.employeeList.remove(employee);
        LOGGER.info(employee.toString() + " is removed from " + this.toString());
    }

    @Override
    public String toString() {
        return String.format("Company {name=%s; boss=%s; employeeList= %s}", name, boss, employeeList);
    }
}