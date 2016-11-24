package edu.ucsb.cs56.projects.games.simple_rpg.tests;

import static org.junit.Assert.*;

import edu.ucsb.cs56.projects.games.simple_rpg.MainCharacter;
import edu.ucsb.cs56.projects.games.simple_rpg.Goblin;
import edu.ucsb.cs56.projects.games.simple_rpg.Weapon;
import edu.ucsb.cs56.projects.games.simple_rpg.Potion;
import edu.ucsb.cs56.projects.games.simple_rpg.Inventory;
import org.junit.Test;

/**
 * JUnit Test for the MainCharacter Class
 *
 * @author Alvin Tan, Nick Perry
 */
public class MainCharacterTester {

  public static final int BOUND = 101;
  public static final int MC_DEF_AGI = 1;
  public static final int MC_DEF_STR = 1;
  public static final int MC_DEF_STA = 1;
  public static final int MC_DEF_INTEL = 1;
  public static final int MC_DEF_STAT_PTS = 5;
  public static final int MC_DEF_XP = 0;
  public static final int MC_DEF_GOLD= 50;
  public static final int MC_DEF_LVL = 1;
  public static final int MC_DEF_X_COORD = 0;
  public static final int MC_DEF_Y_COORD = 0;
  public static final int MC_DEF_HP = 19;
  public static final int MC_DEF_MP = 12;
  public static final int MC_DEF_MAX_HP = 19;
  public static final int MC_DEF_MAX_MP = 12;
  public static final int MC_DEF_MIN_DMG = 3;
  public static final int MC_DEF_MAX_DMG = 3;
  public static final int MC_DEF_NEED_XP = 103;

    private int genRandom(int bound) {
      return (int)(Math.random() * bound);
    }

    /* Tests for inherited methods
    from the superclass Item */

    @Test
    public void testGetInventoryDeafultMC() {
      MainCharacter mc =  new MainCharacter();
      Weapon fist = new Weapon();
      Inventory inv = new Inventory("Bag");
      inv.addItem(fist);
      assertEquals(inv.toString(),
                   mc.getInventory().toString());
    }

    @Test
    public void testGetHpDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_HP, mc.getHP());
    }

    @Test
    public void testGetHpAndSetRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setHP(rand);
      assertEquals(rand, mc.getHP());
    }

    @Test
    public void testGetMpDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_MP, mc.getMP());
    }

    @Test
    public void testGetAndSetMpRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setMP(rand);
      assertEquals(rand, mc.getMP());
    }

    @Test
    public void testGetLvlDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_LVL, mc.getLvl());
    }

    @Test
    public void testGetAndSetLvlRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setLvl(rand);
      assertEquals(rand, mc.getLvl());
    }

    @Test
    public void testGetXDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_X_COORD, mc.getX());
    }

    @Test
    public void testGetAndSetXRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setX(rand);
      assertEquals(rand, mc.getX());
    }

    @Test
    public void testGetYDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_Y_COORD, mc.getY());
    }

    @Test
    public void testGetAndSetYRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setY(rand);
      assertEquals(rand, mc.getY());
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

    @Test
    public void testGetMaxHPDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_MAX_HP, mc.getMaxHP());
    }

    @Test
    public void testGetAndSetMaxHPRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setMaxHP(rand);
      assertEquals(rand, mc.getMaxHP());
    }

    @Test
    public void testGetMaxMPDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_MAX_MP, mc.getMP());
    }

    @Test
    public void testGetAndSetMaxMPRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setMaxMP(rand);
      assertEquals(rand, mc.getMaxMP());
    }

    @Test
    public void testGetMinDMGDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_MIN_DMG, mc.getMinDMG());
    }

    @Test
    public void testGetAndSetMinDMGRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setMinDMG(rand);
      assertEquals(rand, mc.getMinDMG());
    }

    @Test
    public void testGetMaxDMGDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_MAX_DMG, mc.getMinDMG());
    }

    @Test
    public void testGetAndSetMaxDMGRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setMaxDMG(rand);
      assertEquals(rand, mc.getMaxDMG());
    }

    @Test
    public void testGetAgiDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_AGI, mc.getAgi());
    }

    @Test
    public void testGetAndSetAgiRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setAgi(rand);
      assertEquals(rand, mc.getAgi());
    }
/*
    @Test
    public void testGetStr() {}
*/
    @Test
    public void testGetAndSetStrRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setStr(rand);
      assertEquals(rand, mc.getStr());
    }

    @Test
    public void testGetStaDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_STA, mc.getSta());
    }

    @Test
    public void testGetAndSetStaRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setSta(rand);
      assertEquals(rand, mc.getSta());
    }

    @Test
    public void testGetIntelDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_INTEL, mc.getIntel());
    }

    @Test
    public void testGetAndSetIntelRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setIntel(rand);
      assertEquals(rand, mc.getIntel());
    }

    @Test
    public void testGetNameDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals("Main Character", mc.getName());
    }

    @Test
    public void testGetAndSetNameDefaultMC() {
      MainCharacter mc = new MainCharacter();
      mc.setName("Test123");
      assertEquals("Test123", mc.getName());
    }

    @Test
    public void testIsDeadDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(false, mc.isDead());
      mc.setHP(0);
      assertEquals(true, mc.isDead());
    }

/*
    @Test
    public void testGetDirection() {}

    @Test
    public void testSetDirection() {}
*/

    /* Tests for methods from
    the MainCharcter class */

    @Test
    public void testSwapCurrentWeapon() {
      MainCharacter mc = new MainCharacter();
      Weapon wp = new Weapon(4);
      mc.addItemToInv(wp);
      assertEquals("Fists - 0 gold",
                   mc.getCurrentWeapon()
                   .toString());
      mc.swapCurrentWeapon(wp);
      assertEquals("Sword - 80 gold",
                    mc.getCurrentWeapon()
                    .toString());
    }

    @Test
    public void testGetXPDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_XP, mc.getXP());
    }

    @Test
    public void testGetAndSetXPRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setXP(rand);
      assertEquals(rand, mc.getXP());
    }

    @Test
    public void testGetNeedXPDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_NEED_XP, mc.getNeedXP());
    }

    @Test
    public void testGetStrDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_STR, mc.getStr());
    }

    @Test
    public void testGetGoldDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_GOLD, mc.getGold());
    }

    @Test
    public void testGetAndSetGoldRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setGold(rand);
      assertEquals(rand, mc.getGold());
    }

    @Test
    public void testGetStatPointsDefaultMC() {
      MainCharacter mc = new MainCharacter();
      assertEquals(MC_DEF_STAT_PTS, mc.getStatPoints());
    }

    @Test
    public void testGetAndSetStatPointsRandMC() {
      MainCharacter mc = new MainCharacter();
      int rand = genRandom(BOUND);
      mc.setStatPoints(rand);
      assertEquals(rand, mc.getStatPoints());
    }

    @Test
    public void testIncrementAgi() {
      MainCharacter mc = new MainCharacter();
      mc.incrementAgi();
      assertEquals(MC_DEF_AGI + 1, mc.getAgi());
      assertEquals(MC_DEF_STAT_PTS - 1, mc.getStatPoints());
    }

    @Test
    public void testIncrementStr() {
      MainCharacter mc = new MainCharacter();
      mc.incrementStr();
      assertEquals(MC_DEF_STR + 1, mc.getStr());
      assertEquals(MC_DEF_STAT_PTS - 1, mc.getStatPoints());
    }

    @Test
    public void testIncrementSta() {
      MainCharacter mc = new MainCharacter();
      mc.incrementSta();
      assertEquals(MC_DEF_STA + 1, mc.getSta());
      assertEquals(MC_DEF_STAT_PTS - 1, mc.getStatPoints());
    }

    @Test
    public void testIncrementIntel() {
      MainCharacter mc = new MainCharacter();
      mc.incrementIntel();
      assertEquals(MC_DEF_INTEL + 1, mc.getIntel());
      assertEquals(MC_DEF_STAT_PTS - 1, mc.getStatPoints());
    }

    @Test
    public void testGetLoot() {
      MainCharacter mc = new MainCharacter();
      Goblin g = new Goblin();
      boolean isFalse = mc.getLoot(g);
      assertEquals(false, isFalse);
      g.setHP(0);
      boolean isTrue = mc.getLoot(g);
      assertEquals(true, isTrue);
    }

    @Test
    public void testlevelUp() {
      MainCharacter mc = new MainCharacter();
      boolean isFalse = mc.levelUp();
      assertEquals(false, isFalse);
      mc.setXP(MC_DEF_NEED_XP+1);
      boolean isTrue = mc.levelUp();
      assertEquals(true, isTrue);
    }

    @Test
    public void testUpdateStats() {}

    @Test
    public void testAttack() {}

    @Test
    public void testAttacked() {}

}
