package edu.ucsb.cs56.projects.games.simple_rpg;

import java.util.ArrayList;

/*
 _________________________
 | @author Nick Perry    |
 | @version CS56-F16 1.0 |
 -------------------------
 */

public class Inventory {

    public String name;
    private ArrayList<Item> inv;

    /**
     * our default constructor
     */
    public Inventory() {
      this.name = "Inventory";
      inv = new ArrayList<Item>();
    }

    /**
     * a constructor that names the Inventory
     * @param name the name of our Inventory
     */
    public Inventory(String name) {
      this.name = name;
       inv = new ArrayList<Item>();
    }

    /**
     * @return the ArrayList<Item> of our inventory
     */
    public ArrayList<Item> getInvArray() {
      return inv;
    }

    /**
     * @param name the new name of our Inventory
     */
    public void setName(String name){
      this.name = name;
    }

    /**
     * @return the name of our Inventory
     */
    public String getName() {
      return name;
    }

    /**
     * @param i the item we want to add to our Inventory
     */
    public void addItem(Item i){
	     if(i instanceof Weapon)
		     inv.add(0,i);
	     else
		     inv.add(i);
    }

    /**
     * @param i the item we want to add to our Inventory
     * @param index the index where we would like to place this item
     */
    public void addItem(Item i, int index){
      inv.add(index, i);
    }

    /**
     * @param i the Item we would like to get from the Inventory
     * @return either the Item we were searching for or a null pointer if it is not there
     */
    public Item getItem(Item i) {
    	int index = inv.indexOf(i);
	    if(index != -1)
		return inv.get(index);
	    else
		return null;
    }

    /**
     * @param i the index of the item we would like to remove
     */
    public void removeItem(int i){
      int index = i;
       if(index >= 0)
        inv.remove(i);

    }
    /**
     * @param i the Item we would like to remove from the Inventory
     */
    public void removeItem(Item i) {
	     int index = inv.indexOf(i);
	      if(index != -1)
	       inv.remove(i);
    }

    /**
     * @param i the Item we would like to check
     * @return a boolean value of whether or not this item is in the Inventory
     */
    public boolean itemInInv(Item i) {
	    return inv.contains(i);
    }

    /**
     * @param i the Item we would like to search for in the Inventory
     * @return the index of this item in the Inventory
     */
    public int itemIndex(Item i) {
      return inv.indexOf(i);
    }

    public String toString() {
      String str = this.name + " contains ";
      for (int i = 0; i < inv.size(); i++){
         str += inv.get(i) + " ";
      }
      return str;
    }

}
