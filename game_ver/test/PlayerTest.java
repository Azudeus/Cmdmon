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
public class PlayerTest {
    
    public PlayerTest() {
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
        Player instance = new Player (10,15);
        assertEquals(instance.getRowPosition(),10);
        assertEquals(instance.getColumnPosition(),15);
        assertEquals(instance.getHealth(),500);
        assertEquals(instance.getRange(),35);
        assertEquals(instance.getSize(),27);
        assertEquals(instance.getActionInterval(),80);
        assertEquals(instance.getStrength(),25);
        // TODO review the generated test code and remove the default call to fail.
    }

    
    /**
     * Test of doAction method, of class Player.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Player instance = new Player(0,0);
        instance.doAction();
        assertEquals(instance.getHealth(),499);
    }
    
}
