package qa_automation.appbody.persons;

/**
 * The class describes the structure of the object Person
 */

import qa_automation.appbody.Support;
import qa_automation.appbody.enums.Qualification;
import qa_automation.appbody.interfaces.PersonTemplate;

public abstract class Person implements PersonTemplate {

    public static final int MIN_SALARY = 500;
    private String name = Support.DEFAULT;
    private String city = Support.DEFAULT;
    private String skills = Support.DEFAULT;

    abstract public String profile();

    abstract public void setName(String name);

    public String getName() {
        // Getter
        return this.name;
    }

    abstract public void setCity(String city);

    public String getCity() {
        // Getter
        return this.city;
    }

    abstract public void setSkills(String skills);

    public String getSkills() {
        // Getter
        return this.skills;
    }

    abstract public int getSalary();

    abstract public void setSalary(int salary);

    abstract public void setQualification(Qualification qualification);

    abstract public Qualification getQualification();

    public int upSalaryByStatus() {
        // add value to salary
        return 0;
    }

    public static void getInfo(Person person) {
        // Display info abut person by data type
    }
}
