package qa_automation.appbody;

/**
 * Class for control DB with person profiles
 */

import qa_automation.appbody.interfaces.StuffTemplate;
import qa_automation.appbody.persons.Person;

import java.util.ArrayList;

public class Stuff implements StuffTemplate {

    private ArrayList<Person> stuff = new ArrayList<>();

    public void setStuff(ArrayList<Person> stuff) {
        // Setter
        this.stuff = stuff;
    }

    public ArrayList<Person> getStuff() {
        // Getter
        return this.stuff;
    }

    public void addPerson(Person person) {
        // Add new person to DB
        this.stuff.add(person);
    }

    public void removePerson(int id) {
        // Remove Person fom DB
        this.stuff.remove(id);
    }

    public Person getPerson(int id) {
        // Get Person From DB
        return this.stuff.get(id);
    }

    public void printStuf() {
        // Display All DB
        System.out.println("--------------------------------------------------------------------");
        System.out.println("---------------------------Stuff List-------------------------------");
        for (Person person : stuff) {
            System.out.println("----------------------------------------------------------");
            System.out.println(person.profile());
            System.out.println(person.getClass());
            System.out.println("----------------------------------------------------------");
        }
    }
}