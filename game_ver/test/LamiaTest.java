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
    
    @Test
    public void test_Ctor() {
        System.out.println("ctor");
        Lamia instance = new Lamia (10,15,1,2,0);
        assertEquals(instance.getRowPosition(),10);
        assertEquals(instance.getColumnPosition(),15);
        assertEquals(instance.getDirectionX(),1);
        assertEquals(instance.getDirectionY(),2);
        assertEquals(instance.getHealth(),30);
        assertEquals(instance.getRange(),30);
        assertEquals(instance.getSize(),20);
        assertEquals(instance.getActionInterval(),100);
        assertEquals(instance.getStrength(),10);
        // TODO review the generated test code and remove the default call to fail.
    }

    
    /**
     * Test of doAction method, of class Lamia.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Lamia instance = new Lamia (1,2,3,4,0);
        instance.doAction();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getRowPosition(),4);
        assertEquals(instance.getColumnPosition(),6);
    }
    
}
