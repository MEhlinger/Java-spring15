/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockprojecter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marshall
 */
public class ClimbPortfolioTest {
    
    ClimbPortfolio instance;
    BoulderProblem climb1;
    
    public ClimbPortfolioTest() {
    }
    
    @Before
    public void setUp() {
        instance = new ClimbPortfolio("testClimbs.txt");
        instance.climbs.clear();
        instance.writeList();
        climb1 = new BoulderProblem("ClimbOne", "V2", "SocorroNM", true);
        instance.createRecord(climb1);
                
    }


    /**
     * Test of createRecord method, of class ClimbPortfolio.
     */
    @Test
    public void testCreateRecord() {
        System.out.println("createRecord");
        RockClimb climb = new RockRoute("name", "grade", "area", true, 5);
        int sizeBefore = instance.climbs.size();
        instance.createRecord(climb);
        int sizeAfter = instance.climbs.size();
        assertEquals(sizeAfter, sizeBefore+1);
        instance.deleteRecord("name");

    }

    /**
     * Test of retrieveRecord method, of class ClimbPortfolio.
     */
    @Test
    public void testRetrieveRecord() {
        System.out.println("retrieveRecord");
        String name = "ClimbOne";
        RockClimb expResult = climb1;
        RockClimb result = instance.retrieveRecord(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of updateRecord method, of class ClimbPortfolio.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        RockClimb newClimb = new BoulderProblem("ClimbOne", "V5", "SocorroNM", true);
        instance.updateRecord(newClimb);
        assertEquals(instance.retrieveRecord("ClimbOne").getGrade(), "V5");
        
    }

    /**
     * Test of deleteRecord method, of class ClimbPortfolio.
     */
    @Test
    public void testDeleteRecord_String() {
        System.out.println("deleteRecord");
        String name = "ClimbOne";
        int sizeBefore = instance.climbs.size();
        instance.deleteRecord(name);
        int sizeAfter = instance.climbs.size();
        assertEquals(sizeAfter, sizeBefore-1);
    }
    
}
