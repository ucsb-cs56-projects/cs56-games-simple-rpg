package MainCharacter;


import Characters.Enemy;
import Characters.MainCharacter;
import Items.Item;
import static org.junit.Assert.*;

    

/**
 * JUnit Test for the MainCharacter Class
 *
 * @author Alvin Tan
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;/**
 * JUnit Test for the MainCharacter Class
 *
 * @author Alvin Tan
 */
public class MainCharacterTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link edu.ucsb.cs56.projects.games.simple_rpg.MainCharacter#moveLeft(int[][])}.
     */
    @Test
    public void testMoveLeft() {
        int[][] map = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},};
        MainCharacter mc = new MainCharacter();
        assertEquals(false, mc.moveLeft(map));
        assertEquals(true, mc.moveRight(map));
        assertEquals(true, mc.moveLeft(map));
        assertEquals(false, mc.moveLeft(map));
    }

    /**
     * Test method for {@link edu.ucsb.cs56.projects.games.simple_rpg.MainCharacter#moveRight(int[][])}.
     */
    @Test
    public void testMoveRight() {
        int[][] map = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},};
        MainCharacter mc = new MainCharacter();
        assertEquals(true, mc.moveRight(map));
        assertEquals(true, mc.moveRight(map));
        assertEquals(true, mc.moveRight(map));
        assertEquals(true, mc.moveRight(map));
        assertEquals(false, mc.moveRight(map));
        assertEquals(true, mc.moveLeft(map));
        assertEquals(true, mc.moveRight(map));
    }

    /**
     * Test method for {@link edu.ucsb.cs56.projects.games.simple_rpg.MainCharacter#moveUp(int[][])}.
     */
    @Test
    public void testMoveUp() {
        int[][] map = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},};
        MainCharacter mc = new MainCharacter();
        assertEquals(false, mc.moveUp(map));
        assertEquals(true, mc.moveDown(map));
        assertEquals(true, mc.moveUp(map));
        assertEquals(false, mc.moveUp(map));
    }

    /**
     * Test method for {@link edu.ucsb.cs56.projects.games.simple_rpg.MainCharacter#moveDown(int[][])}.
     */
    @Test
    public void testMoveDown() {
        int[][] map = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},};
        MainCharacter mc = new MainCharacter();
        assertEquals(true, mc.moveDown(map));
        assertEquals(true, mc.moveDown(map));
        assertEquals(false, mc.moveDown(map));
        assertEquals(true, mc.moveUp(map));
        assertEquals(true, mc.moveDown(map));
    }

    /**
     * Test of addItemToInv method, of class MainCharacter.
     */
    @Test
    public void testAddItemToInv() {
        System.out.println("addItemToInv");
        Item i = null;
        MainCharacter instance = new MainCharacter();
        instance.addItemToInv(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXp method, of class MainCharacter.
     */
    @Test
    public void testGetXp() {
        System.out.println("getXp");
        MainCharacter instance = new MainCharacter();
        int expResult = 0;
        int result = instance.getXp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setXp method, of class MainCharacter.
     */
    @Test
    public void testSetXp() {
        System.out.println("setXp");
        int xp = 0;
        MainCharacter instance = new MainCharacter();
        instance.setXp(xp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNeedXP method, of class MainCharacter.
     */
    @Test
    public void testGetNeedXP() {
        System.out.println("getNeedXP");
        MainCharacter instance = new MainCharacter();
        int expResult = 0;
        int result = instance.getNeedXP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStr method, of class MainCharacter.
     */
    @Test
    public void testGetStr() {
        System.out.println("getStr");
        MainCharacter instance = new MainCharacter();
        int expResult = 0;
        int result = instance.getStr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGold method, of class MainCharacter.
     */
    @Test
    public void testGetGold() {
        System.out.println("getGold");
        MainCharacter instance = new MainCharacter();
        int expResult = 0;
        int result = instance.getGold();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGold method, of class MainCharacter.
     */
    @Test
    public void testSetGold() {
        System.out.println("setGold");
        int gold = 0;
        MainCharacter instance = new MainCharacter();
        instance.setGold(gold);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatPoints method, of class MainCharacter.
     */
    @Test
    public void testGetStatPoints() {
        System.out.println("getStatPoints");
        MainCharacter instance = new MainCharacter();
        int expResult = 0;
        int result = instance.getStatPoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementAgi method, of class MainCharacter.
     */
    @Test
    public void testIncrementAgi() {
        System.out.println("incrementAgi");
        MainCharacter instance = new MainCharacter();
        instance.incrementAgi();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementStr method, of class MainCharacter.
     */
    @Test
    public void testIncrementStr() {
        System.out.println("incrementStr");
        MainCharacter instance = new MainCharacter();
        instance.incrementStr();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementSta method, of class MainCharacter.
     */
    @Test
    public void testIncrementSta() {
        System.out.println("incrementSta");
        MainCharacter instance = new MainCharacter();
        instance.incrementSta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementIntel method, of class MainCharacter.
     */
    @Test
    public void testIncrementIntel() {
        System.out.println("incrementIntel");
        MainCharacter instance = new MainCharacter();
        instance.incrementIntel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoot method, of class MainCharacter.
     */
    @Test
    public void testGetLoot() {
        System.out.println("getLoot");
        Enemy e = null;
        MainCharacter instance = new MainCharacter();
        boolean expResult = false;
        boolean result = instance.getLoot(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of levelUp method, of class MainCharacter.
     */
    @Test
    public void testLevelUp() {
        System.out.println("levelUp");
        MainCharacter instance = new MainCharacter();
        boolean expResult = false;
        boolean result = instance.levelUp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attack method, of class MainCharacter.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        Enemy e = null;
        MainCharacter instance = new MainCharacter();
        int expResult = 0;
        int result = instance.attack(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attacked method, of class MainCharacter.
     */
    @Test
    public void testAttacked() {
        System.out.println("attacked");
        int dmg = 0;
        MainCharacter instance = new MainCharacter();
        int expResult = 0;
        int result = instance.attacked(dmg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
