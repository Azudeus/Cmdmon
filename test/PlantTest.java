/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rellons
 */
public class PlantTest {
    
    public PlantTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of draw method, of class Plant.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Plant instance = new Plant(0,0);
        char expResult = 'T';
        char result = instance.draw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of doAction method, of class Plant.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Plant instance = new Plant(0,0);
        int x = instance.getRowPosition();
        int y = instance.getColumnPosition();
        int strength = instance.getStrength();
        
        instance.doAction();
        
        int newx = instance.getRowPosition();
        int newy = instance.getColumnPosition();
        int newstrength = instance.getStrength();
        
        assertEquals( 0 , newx - x );
        assertEquals( 0 , newx - x );
        assertEquals( 1 , newstrength - strength);
    }
    
}
