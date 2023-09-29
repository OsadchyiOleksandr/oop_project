package qa_automation.appbody.interfaces;

/**
 * The interface describes the structure of the DB class
 */

import qa_automation.appbody.persons.Person;

import java.util.ArrayList;

public interface StuffTemplate {
    void setStuff(ArrayList<Person> stuff);

    void addPerson(Person person);

    void removePerson(int id);

    Person getPerson(int id);

    ArrayList<Person> getStuff();

    public void printStuf();
}