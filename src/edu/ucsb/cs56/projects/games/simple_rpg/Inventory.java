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

    public void addItem(Item i){
	inv.add(i);
    }

    public void removeItem(Item i){
	int index = inv.indexOf(i);
	if(index != -1)
	   inv.remove(i);
    }
    
}
