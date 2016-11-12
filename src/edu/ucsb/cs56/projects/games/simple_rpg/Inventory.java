package edu.ucsb.cs56.projects.games.simple_rpg;

import java.util.ArrayList;

/*
 *
 * @author Nick Perry
 * @version CS56-F16 1.0
 *
 */

public class Inventory {

    private ArrayList<Item> inv;

    public Inventory() {
	inv = new ArrayList<Item>();
    }

    public ArrayList<Item> getInvArray() {
      return inv;
    }


    public void addItem(Item i){
	     if(i instanceof Weapon)
		     inv.add(0,i);
	     else
		     inv.add(i);
    }

    public void addItem(Item i, int index){
      inv.add(index, i);
    }

    public Item getItem(Item i) {
    	int index = inv.indexOf(i);
	    if(index != -1)
		return inv.get(index);
	    else
		return null;
    }

    public void removeItem(int i){
      int index = i;
       if(index >= 0)
        inv.remove(i);

    }
    public void removeItem(Item i) {
	     int index = inv.indexOf(i);
	      if(index != -1)
	       inv.remove(i);
    }

    public boolean itemInInv(Item i) {
	    return inv.contains(i);
    }

    public int itemIndex(Item i) {
      return inv.indexOf(i);
    }

}
