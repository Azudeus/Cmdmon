/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics2D;
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
    
    @Test
    public void test_Ctor() {
        System.out.println("ctor");
        Plant instance = new Plant (10,15,1);
        assertEquals(instance.getRowPosition(),10);
        assertEquals(instance.getColumnPosition(),15);
        assertEquals(instance.getHealth(),55);
        assertEquals(instance.getRange(),0);
        assertEquals(instance.getSize(),20);
        assertEquals(instance.getActionInterval(),200);
        assertEquals(instance.getStrength(),0);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of doAction method, of class Plant.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Plant instance = new Plant(0,0,1);
        instance.doAction();
        assertEquals(instance.getHealth(),57);
    
    }
    
}
