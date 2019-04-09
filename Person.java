public class Person {
    String surname;
    String name;
    String company;

     Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

     public String getCompany() {
        return company;
    }

     public void setCompany(String company) {
        this.company = company;
    }
}