package agentListFileBacked;

/**
 * This class represents a single State Farm agent along with his or her office
 * phone, office location, number of clients, and the total yearly value of the
 * insurance policies he or she has sold.
 *
 * TODO #1 (complete 1 out of 5 for a C grade) - add the getters and setters for
 * this class and test using the JUnit tests. Do not make any changes to the
 * instance variables, the constructors, the toString() method, or to the JUnit
 * tests.
 *
 * @author Marshall Ehlinger
 */
public class Agent {

    private int agentId;

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public double getPortfolioValue() {
        return portfolioValue;
    }

    public void setPortfolioValue(double portfolioValue) {
        this.portfolioValue = portfolioValue;
    }
    private String lastName;
    private String firstName;
    private String officePhone;
    private String city;
    private String state;
    private int numberOfClients;
    private double portfolioValue;

    /**
     * A simple default constructor.
     */
    public Agent() {
        this.agentId = -1;
        this.lastName = "";
        this.firstName = "";
        this.officePhone = "";
        this.city = "";
        this.state = "";
        this.numberOfClients = 0;
        this.portfolioValue = 0.00;
    }

    /**
     * A constructor that receives parameters for each instance variable.
     *
     * @param agentId - a unique integer number that does not change which is
     * assigned to each agent
     * @param lastName - the agent's last name
     * @param firstName - the agent's first name
     * @param officePhone - the agent's office phone number
     * @param city - the city name of the agent's office location
     * @param state - the 2 letter abbreviation of the agent's office state
     * location
     * @param numberOfClients - the number of clients managed by this agent
     * @param portfolioValue - the total yearly value of all of the policies
     * managed by this agent
     */
    public Agent(int agentId, String lastName, String firstName,
            String officePhone, String city, String state,
            int numberOfClients, double portfolioValue) {
        this.agentId = agentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.officePhone = officePhone;
        this.city = city;
        this.state = state;
        this.numberOfClients = numberOfClients;
        this.portfolioValue = portfolioValue;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s, %s, %d, %.2f",
                agentId, lastName, firstName, officePhone, city, state, numberOfClients, portfolioValue);
    }
}
