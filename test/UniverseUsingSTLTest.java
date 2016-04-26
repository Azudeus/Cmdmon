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
public class UniverseUsingSTLTest {
    
    public UniverseUsingSTLTest() {
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
     * Test of killCreature method, of class UniverseUsingSTL.
     */
    @Test
    public void testKillCreatureAddCreatureAddRandomCreature() {
        System.out.println("killCreature");
        UniverseUsingSTL instance = new UniverseUsingSTL(5,5);
        assertTrue(instance.isWorldEmpty());
        instance.addRandomCreature(10);
        assertEquals(10,instance.CreatureList.size());
    }

    /**
     * Test of addCreature method, of class UniverseUsingSTL.
     */
    @Test

    /**
     * Test of addRandomCreature method, of class UniverseUsingSTL.
     */
    @Test
    public void testAddRandomCreature() {
        System.out.println("addRandomCreature");
        int amount = 0;
        UniverseUsingSTL instance = null;
        instance.addRandomCreature(amount);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isWorldEmpty method, of class UniverseUsingSTL.
     */
    @Test
    public void testIsWorldEmpty() {
        System.out.println("isWorldEmpty");
        UniverseUsingSTL instance = new UniverseUsingSTL(10,10);
        assertTrue(instance.isWorldEmpty());
    }

    
}
