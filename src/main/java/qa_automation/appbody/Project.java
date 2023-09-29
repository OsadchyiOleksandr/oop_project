package qa_automation.appbody;

/**
 * Class where building team for project
 */

import qa_automation.appbody.persons.Employee;
import qa_automation.appbody.persons.Person;
import qa_automation.appbody.persons.TeamLead;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

    private HashMap<String, String> projectTeam = new HashMap<>();

    Project(ArrayList<Person> stuff) {
        // Constructor of project
        LeadForProject lead = new LeadForProject(stuff);
        projectTeam.put("Team Lead", lead.profile);
        EmployeeForProject employee = new EmployeeForProject(stuff);
        projectTeam.put("Employee", employee.profile);
    }

    class LeadForProject {
        // Subclass for choosing team lead
        String profile = null;

        LeadForProject(ArrayList<Person> stuff) {
            //Constructor
            for (Person person : stuff) {
                if (person instanceof TeamLead) {
                    this.profile = person.profile();
                    break;
                }
            }
        }
    }

    class EmployeeForProject {
        //Subclass for choosing team employee
        String profile = null;

        EmployeeForProject(ArrayList<Person> stuff) {
            // Constructor
            for (Person person : stuff) {
                if (person instanceof Employee) {
                    this.profile = person.profile();
                }
                break;
            }
        }
    }

    HashMap<String, String> getProjectTeam() {
        //Getter
        return this.projectTeam;
    }
}