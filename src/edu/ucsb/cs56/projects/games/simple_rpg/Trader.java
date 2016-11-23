package edu.ucsb.cs56.projects.games.simple_rpg;

/**
 * Trader class that extends Entity and
 * represents a neutral game character that
 * allows the MainCharacter Shop access
 *
 * @author Nick Perry
 */

 public class Trader extends Entity {

   private Shop tradeShop;
   private int gold;
   Inventory inv;
   private Weapon currentWpn;

   /**
   * Constructor to initialize Trader Object
   * @param lvl level of the Trader
   */

   public Trader(int lvl){
     super("Trader");
     tradeShop = new Shop();
     agi = 1;
     str = 1;
     sta = 1;
     intel = 1;
     this.lvl = lvl;
     gold = 100 * lvl;
     x = 0;
     y = 0;
     hp = (int) ((15 + sta * 1.2 + str * 0.15) + lvl * 3.4);
     mp = (int) ((10 + intel * 1.2) + lvl * 1.3);
     maxHP = (int) ((15 + sta * 1.2 + str * 0.15) + lvl * 3.4);
     maxMP = (int) ((10 + intel * 1.2) + lvl * 1.3);
     minDMG = (int) ((str * 2 + agi * 0.15 + intel * 0.17) + lvl * 0.8);
     maxDMG = (int) ((str * 2.3 + agi * 0.22 + intel * 0.2) + lvl * 0.8);
     Weapon fist = new Weapon();
     Weapon sword = new Weapon(4);
     inv = new Inventory("Bag");
     inv.addItem(fist);
     inv.addItem(sword);
     currentWpn = sword;
   }

   public Shop getTradeShop(){
     return tradeShop;
   }

   public int attacked(int dmg) {
       dmg = (int) (dmg * .90);
       hp -= dmg;
       return dmg;
   }

   public int attack(MainCharacter mc) {
       int x = Math.abs(mc.getAgi() - agi);
       if (x >= 100) {
           if (Math.random() > .5) {
               return (int) ((maxDMG - minDMG + 1) * Math.random() + minDMG);
           } else {
               return -1;
           }
       } else {
           if (Math.random() > (x * .5) / 100) {
               return (int) ((maxDMG - minDMG + 1) * Math.random() + minDMG);
           } else {
               return -1;
           }
       }
   }

 }
