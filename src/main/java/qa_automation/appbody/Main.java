package qa_automation.appbody;

/**
 * Main class for manipulating by entities
 */

import qa_automation.appbody.db.DataBase;
import qa_automation.appbody.enums.Qualification;
import qa_automation.appbody.persons.Employee;
import qa_automation.appbody.persons.Person;
import qa_automation.appbody.persons.TeamLead;
import qa_automation.appbody.persons.Worker;
import qa_automation.appbody.projectexceptions.MaxSalaryException;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    static Stuff stuff = new Stuff();
    static DataBase db;

    static {
        try {
            db = new DataBase();
        } catch (MaxSalaryException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startProcess() throws IOException, MaxSalaryException {
        // Start work of App
        Main.stuff.printStuf();
        System.out.println("Chose what you wanna set"
                + "\n" + "1. Add"
                + "\n" + "2. Edit"
                + "\n" + "3. Build projectTeam");
        String action = Support.scan.readLine().trim();
        switch (action) {
            case "1":
                try{
                    createPerson();
                } catch (MaxSalaryException e){
                    System.out.println(e.getMessage());
                    startProcess();
                }
                break;
            case "2":
                int index = Integer.parseInt(Support.scan.readLine().trim());
                Person person = stuff.getPerson(index);
                stuff.removePerson(index);
                Worker.getInfo(person);
                Employee.getInfo(person);
                TeamLead.getInfo(person);
                workWithProfile(person);
                break;
            case "3":
                Project project = new Project(Main.stuff.getStuff());
                workWithProjectTeam(project);
                break;
            default:
                createPerson();
        }
    }

    private static void createPerson() throws IOException, MaxSalaryException {
        // Method for Creating person Worker, Employee, Team Lead
        System.out.println("Chose what you wanna set"
                + "\n" + "1. Add Worker"
                + "\n" + "2. Add Employee"
                + "\n" + "3. Add TeamLead"
                + "\n" + "q. for end"
        );
        String action = Support.scan.readLine().trim();
        switch (action) {
            case "1":
                Worker worker = new Worker();
                System.out.println("Enter the name of new Worker");
                worker.setName(Support.scan.readLine().trim());
                workWithProfile(worker);
                break;
            case "2":
                Employee employee = new Employee();
                System.out.println("Enter the name of new Employer");
                employee.setName(Support.scan.readLine().trim());
                workWithProfile(employee);
                break;
            case "3":
                TeamLead teamLead = new TeamLead();
                System.out.println("Enter the name of new Team Lead");
                teamLead.setName(Support.scan.readLine().trim());
                workWithProfile(teamLead);
                break;
            case "q":
                break;
            default:
                createPerson();
        }
    }

    private static void workWithProfile(Person person) throws IOException, MaxSalaryException {
        // Method for Edit person Worker, Employee, Team Lead
        System.out.println(person.profile());
        System.out.println("Chose what you wanna set"
                + "\n" + "1. Change Name"
                + "\n" + "2. Change City"
                + "\n" + "3. Change Skills"
                + "\n" + "4. Change Qualification"
                + "\n" + "5. Change Salary"
                + "\n" + "q. for end");
        String action = Support.scan.readLine().trim();
        switch (action) {
            case "1":
                System.out.println("Set Name");
                person.setName(Support.scan.readLine().trim());
                workWithProfile(person);
                break;
            case "2":
                System.out.println("Set City");
                person.setCity(Support.scan.readLine().trim());
                workWithProfile(person);
                break;
            case "3":
                System.out.println("Set skills");
                person.setSkills(Support.scan.readLine().trim());
                workWithProfile(person);
                break;
            case "4":
                System.out.println("Set Qualification");
                Main.setQualificationForPerson(person);
                workWithProfile(person);
                break;
            case "5":
                System.out.println("Set salary");
                int salary = Support.strToInt(Support.scan.readLine().trim());
                if (salary < 10000){
                    person.setSalary(salary);
                    workWithProfile(person);
                } else {
                    throw new MaxSalaryException("To much for person");
                }
                break;
            case "q":
                Main.stuff.addPerson(person);
                startProcess();
                break;
            default:
                workWithProfile(person);
        }
    }

    private static void setQualificationForPerson(Person person) throws IOException {
        // Set Qualification For Selected Person
        System.out.printf("Chose qualification for %s%n", person.getName());
        System.out.println("1. Low - 1-3 years"
                + "\n2. Middle - 3-5 years"
                + "\n3. Height - 5 and more years"
        );
        String chose = Support.scan.readLine().trim();
        switch (chose) {
            case "1":
                person.setQualification(Qualification.LOW);
                break;
            case "2":
                person.setQualification(Qualification.MIDDLE);
                break;
            case "3":
                person.setQualification(Qualification.HIGHT);
                break;
            default:
                setQualificationForPerson(person);
        }
    }

    private static void workWithProjectTeam(Project project) {
        // Chose persons for project
        HashMap<String, String> team = project.getProjectTeam();
        for (String key : team.keySet()) {
            System.out.printf("   Position%n%s%n   Profile:%n%s%n%n", key, team.get(key));
        }
    }
}