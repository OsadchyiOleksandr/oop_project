package qa_automation.appbody.interfaces;

/**
 * The interface describes the structure of objects of the Person type
 */

import qa_automation.appbody.enums.Qualification;
import qa_automation.appbody.persons.Person;

public interface PersonTemplate {

    public static final int MIN_SALARY = 500;

    abstract public String profile();

    abstract public void setName(String name);

    public String getName();

    abstract public void setCity(String city);

    public String getCity();

    abstract public void setSkills(String skills);

    public String getSkills();

    abstract public int getSalary();

    abstract public void setSalary(int salary);

    abstract public void setQualification(Qualification qualification);

    abstract public Qualification getQualification();

    default int upSalaryByStatus() {
        return 0;
    }

    public static void getInfo(Person person) {

    }
}