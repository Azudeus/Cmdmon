/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;
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
    public void testKillCreature() {
        System.out.println("killCreature");
        Creature creature = null;
        UniverseUsingSTL instance = new UniverseUsingSTL(600,600);
        instance.addRandomCreature(1);
        instance.killCreature(instance.getCreatureList().get(0));
        assertEquals(instance.getCreatureList().size(),0);
    }

    /**
     * Test of getCreatureList method, of class UniverseUsingSTL.
     */
   
    /**
     * Test of addTurn method, of class UniverseUsingSTL.
     */
    @Test
    public void testAddTurn() {
        UniverseUsingSTL instance = new UniverseUsingSTL(10,10);
        instance.addTurn();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getTurn(),1);
    }

    /**
     * Test of getTurnInterval method, of class UniverseUsingSTL.
     */
    @Test
    public void testGetTurnInterval() {
        UniverseUsingSTL instance = new UniverseUsingSTL(10,10);
        int expResult = 3000;
        int result = instance.getTurnInterval();
        assertEquals(expResult, result);
    }


    /**
     * Test of Distance method, of class UniverseUsingSTL.
     */
    @Test
    public void testDistance() {
        System.out.println("Distance");
        Creature c1 = new Harpy(0,0,0,0,0);
        Creature c2 = new Harpy(1,2,0,0,0);
        UniverseUsingSTL instance = new UniverseUsingSTL(500,500);
        instance.addCreature(c1);
        instance.addCreature(c2);
        int expResult = 3;
        int result = instance.Distance(c1, c2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addCreature method, of class UniverseUsingSTL.
     */
    @Test
    public void testAddCreature() {
        System.out.println("addCreature");
        int amount = 1;
        Creature a = new Harpy(0,0,0,0,0);
        UniverseUsingSTL instance = new UniverseUsingSTL(500,500);
        instance.addCreature(a);
        assertEquals(instance.getCreatureList().size(),amount);
    }

    /**
     * Test of addRandomCreature method, of class UniverseUsingSTL.
     */
    @Test
    public void testAddRandomCreature() {
        System.out.println("addRandomCreature");
        int amount = 5;
        UniverseUsingSTL instance = new UniverseUsingSTL(500,500);
        instance.addRandomCreature(amount);
        assertEquals(instance.getCreatureList().size(),amount);
    }

    /**
     * Test of isWorldEmpty method, of class UniverseUsingSTL.
     */
    @Test
    public void testIsWorldEmpty() {
        System.out.println("isWorldEmpty");
        UniverseUsingSTL instance = new UniverseUsingSTL(10,10);
        boolean expResult = true;
        boolean result = instance.isWorldEmpty();
        assertEquals(expResult, result);
    }



    
}
