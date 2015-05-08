package agentListFileBacked;

import java.util.Scanner;

/**
 * This class is the main application. The application keeps track of State Farm
 * insurance agents. It is a console-based menu-driven program.
 *
 * TODO #3 (complete #1, #2, and #3 for an A- grade) - Add an option to delete a
 * record. Ask the user for an ID to delete. Verify that the record exists.
 * Display the record. Ask the user if they are sure they want to delete it. If
 * yes then delete it.
 *
 * IMPORTANT: Only complete #4 and #5 below after having your instructor grade
 * parts 1-3.
 *
 * TODO #4 (complete #1, #2, #3, and #4 for an A grade) - Add a menu option to
 * calculate the total number of clients for all of the agents in the list.
 * Implement a method called calcTotalClients in the AgentList class. Add a test
 * method to test this in the AgentListTest.java file.
 *
 * TODO #5 (complete #1, #2, #3, #4, and #5 for an A+ grade) - Add a menu option
 * to calculate the total yearly portfolio value of all of the agents. Implement
 * a method called calcTotalPortfolio in the AgentList class. Add a test method
 * to test this in the AgentListTest.java file.
 *
 * @author Your Name Here
 */
public class AgentApp {

    AgentList agentList = new AgentList();
    Scanner sc = new Scanner(System.in);

    public AgentApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id, numberOfClients;
        String last, first, officePhone, city, state;
        double portfolio;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nState Farm Agent App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            System.out.println("6 = Count Clients");
            System.out.println("7 = Total Portfolio Value");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-7]$");

            switch (choice) {
                case "1":
                    System.out.println(agentList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New agent ID: ");
                    if (agentList.retrieveRecord(id) == null) {
                        last = Validator.getLine(sc, "Last name: ");
                        first = Validator.getLine(sc, "First name: ");
                        officePhone = Validator.getLine(sc, "Office phone number: ");
                        city = Validator.getLine(sc, "City: ");
                        state = Validator.getLine(sc, "State: ");
                        numberOfClients = Validator.getInt(sc, "Number of clients: ");
                        portfolio = Validator.getDouble(sc, "Yearly portfolio value: ");
                        agentList.createRecord(new Agent(id, last, first, officePhone,
                                city, state, numberOfClients, portfolio));
                    } else {
                        System.out.println("Agent ID " + id + " already exists.");
                        System.out.println(agentList.retrieveRecord(id));
                    }
                    break;
                case "3":
                    id = Validator.getInt(sc, "Agent ID to retrieve: ");
                    if (agentList.retrieveRecord(id) != null) {
                        System.out.println(agentList.retrieveRecord(id));
                    } else {
                        System.out.println("Agent ID " + id + " was not found.");
                    }
                    break;
                case "4":
                    id = Validator.getInt(sc, "Agent ID to update: ");
                    if (agentList.retrieveRecord(id) != null) {
                        System.out.println(agentList.retrieveRecord(id));
                        last = Validator.getLine(sc, "Last name: ");
                        first = Validator.getLine(sc, "First name: ");
                        officePhone = Validator.getLine(sc, "Office phone number: ");
                        city = Validator.getLine(sc, "City: ");
                        state = Validator.getLine(sc, "State: ");
                        numberOfClients = Validator.getInt(sc, "Number of clients: ");
                        portfolio = Validator.getDouble(sc, "Yearly portfolio value: ");
                        agentList.updateRecord(new Agent(id, last, first, officePhone,
                                city, state, numberOfClients, portfolio));
                    } else {
                        System.out.println("Agent ID " + id + " was not found.");
                    }
                    break;
                case "5":
                    id = Validator.getInt(sc, "Agent ID to delete forever: ");
                    if (agentList.retrieveRecord(id) != null) {
                        System.out.println("Agent to be deleted:");
                        System.out.println(agentList.retrieveRecord(id));
                        String confirmation = Validator.getLine(sc, "Are you sure? Enter 1 for yes, 0 for no: ", "^[0-1]$");
                        if (confirmation.equals("1")) {
                            agentList.deleteRecord(id);
                            System.out.println("Agent with id " + id + " deleted");
                        } else {
                            System.out.println("Delete cancelled.");
                        }
                    } else {
                        System.out.println("Agent ID " + id + " was not found.");
                    }
                    break;
                case "6":
                    System.out.println(agentList.calcTotalClients());
                    break;
                case "7":
                    System.out.println(agentList.calcTotalPortfolio());
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new AgentApp();
    }
}
