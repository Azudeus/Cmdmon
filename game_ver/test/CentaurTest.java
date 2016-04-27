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
public class CentaurTest {
    
    public CentaurTest() {
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
        Centaur instance = new Centaur (10,15,1,2,0);
        assertEquals(instance.getRowPosition(),10);
        assertEquals(instance.getColumnPosition(),15);
        assertEquals(instance.getDirectionX(),1);
        assertEquals(instance.getDirectionY(),2);
        assertEquals(instance.getHealth(),50);
        assertEquals(instance.getRange(),12);
        assertEquals(instance.getSize(),20);
        assertEquals(instance.getActionInterval(),50);
        assertEquals(instance.getStrength(),20);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of doAction method, of class Centaur.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Centaur instance = new Centaur(8,13,2,2,0);
        instance.doAction();
        assertEquals(instance.getRowPosition(),10);
        assertEquals(instance.getColumnPosition(),15);
    }
    
}
