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
public class LamiaTest {
    
    public LamiaTest() {
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
     * Test of draw method, of class Lamia.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Lamia instance = new Lamia(0,0,0,0);
        char expResult = 'L';
        char result = instance.draw();
        assertEquals(expResult, result);
    }

    /**
     * Test of doAction method, of class Lamia.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Lamia instance = new Lamia(0,0,0,0);
        int x = instance.getRowPosition();
        int y = instance.getColumnPosition();
        
        instance.doAction();
        
        int newx = instance.getRowPosition();
        int newy = instance.getColumnPosition();
        
        assertEquals( instance.getDirectionX() , newx - x );
        assertEquals( instance.getDirectionX() , newx - x );
    }
    
}
