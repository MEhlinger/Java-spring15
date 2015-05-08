package agentListFileBacked;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marshall Ehlinger
 */
public class AgentListTest {

    AgentList agentList;
    Agent agent;

    public AgentListTest() {
    }

    @Before
    public void setUp() {
        System.out.print("Setting up before running test on method ");
        agentList = new AgentList("agenttestdata.txt");
        agentList.myList.clear();
        agentList.writeList();
        agent = new Agent(99, "Last", "First", "123-456-7890", "City", "ST", 10, 12345.67);
        agentList.createRecord(agent);
    }

    /**
     * Test of createRecord method, of class AgentList.
     */
    @Test
    public void testCreateRecord() {
        System.out.println("createRecord");
        int sizeBefore = agentList.myList.size();
        Agent a2 = new Agent(100, "Last", "First", "123-456-7890", "City", "ST", 10, 12345.67);
        agentList.createRecord(a2);
        int sizeAfter = agentList.myList.size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    /**
     * Test of retrieveRecord method, of class AgentList.
     */
    @Test
    public void testRetrieveRecord() {
        System.out.println("retrieveRecord");
        Agent result = agentList.retrieveRecord(99);
        System.out.println(result);
        assertEquals(99, result.getAgentId());
        assertEquals("Last", result.getLastName());
        assertEquals("First", result.getFirstName());
        assertEquals("123-456-7890", result.getOfficePhone());
        assertEquals("City", result.getCity());
        assertEquals("ST", result.getState());
        assertEquals(10, result.getNumberOfClients());
        assertEquals(12345.67, result.getPortfolioValue(), 0.0001);
    }

    /**
     * Test of updateRecord method, of class AgentList.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        Agent a2 = new Agent(99, "NewLast", "NewFirst", "NewPhone", "NewCity", "NewST", 99, 999.99);
        agentList.updateRecord(a2);
        assertEquals(99, agentList.retrieveRecord(99).getAgentId());
        assertEquals("NewLast", agentList.retrieveRecord(99).getLastName());
        assertEquals("NewFirst", agentList.retrieveRecord(99).getFirstName());
        assertEquals("NewPhone", agentList.retrieveRecord(99).getOfficePhone());
        assertEquals("NewCity", agentList.retrieveRecord(99).getCity());
        assertEquals("NewST", agentList.retrieveRecord(99).getState());
        assertEquals(99, agentList.retrieveRecord(99).getNumberOfClients());
        assertEquals(999.99, agentList.retrieveRecord(99).getPortfolioValue(), 0.0001);
    }

    /**
     * Test of deleteRecord method, of class AgentList.
     */
    @Test
    public void testDeleteRecord_int() {
        System.out.println("deleteRecord by id");
        assertEquals(1, agentList.myList.size());
        agentList.deleteRecord(99);
        assertEquals(0, agentList.myList.size());
    }

    /**
     * Test of deleteRecord method, of class AgentList.
     */
    @Test
    public void testDeleteRecord_Agent() {
        System.out.println("deleteRecord by Agent object");
        assertEquals(1, agentList.myList.size());
        agentList.deleteRecord(agent);
        assertEquals(0, agentList.myList.size());
    }

    /**
     * Test of toString method, of class AgentList.
     */
    @Test
    public void testToString() {
        String expected = "99, Last, First, 123-456-7890, City, ST, 10, 12345.67\n";
        assertEquals(expected, agentList.toString());
    }
    
    @Test
    public void testCalcTotalClients() {
        int numExpected = 10;
        assertEquals(numExpected, agentList.calcTotalClients());
    }

    @Test
    public void testCalcTotalPortfolio() {
        double numExpected = 12345.67;
        assertEquals(numExpected, agentList.calcTotalPortfolio(), 0.0000001);
    }
}
