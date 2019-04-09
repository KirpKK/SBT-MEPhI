import java.util.LinkedList;
import java.util.List;

 public class Company {
    String name;
    Person boss;
    List<Person> employeeList;

     Company(String name){
        this.name = name;
    }

     public void setBoss(Person boss) {
        this.boss = boss;
        if (!employeeList.contains(boss)) addEmployee(boss);
    }

     public void addEmployee(Person employee) {
        if (employeeList == null) employeeList = new LinkedList<>();
        this.employeeList.add(employee);
    }
	
     public void removeEmployee(Person employee) {
        if (employeeList != null) this.employeeList.remove(employee);
		employee.setCompany(null);
	}
}