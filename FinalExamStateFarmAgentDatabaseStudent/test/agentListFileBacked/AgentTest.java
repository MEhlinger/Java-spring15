package agentListFileBacked;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of the Agent class.
 *
 * @author John Phillips
 */
public class AgentTest {

    Agent agent;

    public AgentTest() {
    }

    @Before
    public void setUp() {
        System.out.print("Setting up before running test on method ");
        agent = new Agent(99, "Last", "First", "123-456-7890", "City", "ST", 10, 12345.67);
    }

    @Test
    public void testGetAgentId() {
        System.out.println("getAgentId");
        int expResult = 99;
        int result = agent.getAgentId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAgentId() {
        System.out.println("setAgentId");
        int expResult = 345;
        agent.setAgentId(expResult);
        assertEquals(expResult, agent.getAgentId());
    }

    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Last";
        String result = agent.getLastName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String expResult = "NewLastName";
        agent.setLastName(expResult);
        assertEquals(expResult, agent.getLastName());
    }

    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "First";
        String result = agent.getFirstName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String expResult = "NewFirstName";
        agent.setFirstName(expResult);
        assertEquals(expResult, agent.getFirstName());
    }

    @Test
    public void testGetOfficePhone() {
        System.out.println("getOfficePhone");
        String expResult = "123-456-7890";
        String result = agent.getOfficePhone();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetOfficePhone() {
        System.out.println("setOfficePhone");
        String expResult = "999-888-7777";
        agent.setOfficePhone(expResult);
        assertEquals(expResult, agent.getOfficePhone());
    }

    @Test
    public void testGetCity() {
        System.out.println("getCity");
        String expResult = "City";
        String result = agent.getCity();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String expResult = "NewCity";
        agent.setCity(expResult);
        assertEquals(expResult, agent.getCity());
    }

    @Test
    public void testGetState() {
        System.out.println("getState");
        String expResult = "ST";
        String result = agent.getState();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetState() {
        System.out.println("setState");
        String expResult = "NewState";
        agent.setState(expResult);
        assertEquals(expResult, agent.getState());
    }

    @Test
    public void testGetNumberOfClients() {
        System.out.println("getNumberOfClients");
        int expResult = 10;
        int result = agent.getNumberOfClients();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNumberOfClients() {
        System.out.println("setNumberOfClients");
        int expResult = 999;
        agent.setNumberOfClients(expResult);
        assertEquals(expResult, agent.getNumberOfClients());
    }

    @Test
    public void testGetPortfolioValue() {
        System.out.println("getPortfolioValue");
        double expResult = 12345.67;
        double result = agent.getPortfolioValue();
        assertEquals(expResult, result, 0.0001);
    }

    @Test
    public void testSetPortfolioValue() {
        System.out.println("setPortfolioValue");
        double expResult = 7654321.54;
        agent.setPortfolioValue(expResult);
        assertEquals(expResult, agent.getPortfolioValue(), 0.0001);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "99, Last, First, 123-456-7890, City, ST, 10, 12345.67";
        String result = agent.toString();
        assertEquals(expResult, result);
    }

}
