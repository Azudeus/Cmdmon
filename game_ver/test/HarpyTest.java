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
public class HarpyTest {
    
    public HarpyTest() {
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

   public void test_Ctor() {
        System.out.println("ctor");
        Harpy instance = new Harpy (10,15,1,2,0);
        assertEquals(instance.getRowPosition(),10);
        assertEquals(instance.getColumnPosition(),15);
        assertEquals(instance.getDirectionX(),1);
        assertEquals(instance.getDirectionY(),2);
        assertEquals(instance.getHealth(),15);
        assertEquals(instance.getRange(),20);
        assertEquals(instance.getSize(),20);
        assertEquals(instance.getActionInterval(),50);
        assertEquals(instance.getStrength(),30);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of doAction method, of class Harpy.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Harpy instance = new Harpy(3,2,12,8,0);
        instance.doAction();
        assertEquals(instance.getRowPosition(),15);
        assertEquals(instance.getColumnPosition(),10);
    }
    
}
