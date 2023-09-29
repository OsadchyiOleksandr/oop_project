package qa_automation.appbody.persons;

/**
 * The class describes the structure of the object TeamLead <- Employee <- Person
 */

import qa_automation.appbody.enums.Qualification;
import qa_automation.appbody.interfaces.PersonTemplate;

public final class TeamLead extends Employee implements PersonTemplate {

    private String name = super.getName();
    private String city = super.getCity();
    private String skills = super.getCity();
    private int salary = Person.MIN_SALARY + upSalaryByStatus();
    private Qualification qualification = Qualification.DEFAULT;

    public int upSalaryByStatus() {
        // Up salary by status of person
        return 475;
    }

    public TeamLead() {
        // Default Constructor
    }

    public TeamLead(String name) {
        // Constructor
        this.name = name;
    }

    public TeamLead(String name, String city) {
        // Constructor
        this.name = name;
        this.city = city;
    }

    public TeamLead(String name, String city, String skills) {
        // Constructor
        this.name = name;
        this.city = city;
        this.skills = skills;
    }

    public String profile() {
        // Data by Person
        return String.format("TeamLead"
                        + "%nPerson ---> %s"
                        + "%nLive in ---> %s"
                        + "%nHave skills ---> %s"
                        + "%nHave Salary ---> %s"
                        + "%nHave qualification ---> %s",
                this.name,
                this.city,
                this.skills,
                this.salary,
                this.qualification.getQualification());
    }

    public void setName(String name) {
        // Setter
        this.name = name;
    }

    public String getName() {
        // Getter
        return this.name;
    }

    public void setCity(String city) {
        // Setter
        this.city = city;
    }

    public String getCity() {
        // Getter
        return this.city;
    }

    public void setSkills(String skills) {
        // Setter
        this.skills = skills;
    }

    public String getSkills() {
        // Getter
        return this.skills;
    }

    public int getSalary() {
        // Getter
        return this.salary;
    }

    public void setSalary(int salary) {
        // Setter
        this.salary = salary;
    }

    public void upgradeSalary(int addToSalary) {
        // add value to salary
        this.salary += addToSalary;
    }

    public void setQualification(Qualification qualification) {
        // Setter
        this.qualification = qualification;
    }

    public Qualification getQualification() {
        // Getter
        return this.qualification;
    }

    public static void getInfo(Person person) {
        // Display info by person if it TeamLead
        if (person instanceof TeamLead) {
            person.profile();
        }
    }
}
