
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.FlowLayout;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class that will allow us to access our inventory
 *
 * @author Daniel Chojnacki
 *
 */

public class InventoryDisplay extends JFrame{

    private JComboBox weaponSelect;
    private JButton set;
    private FlowLayout inventoryLayout;

    /**
     * No-arg constructor for the InventoryDisplay class
     */
    public InventoryDisplay(final MainCharacter mc) {
	//Calls the constructor for the JFrame class, which InventoryDisplay extends.
	super("Inventory");

	//We need to create a new Inventory to display
	Inventory dispInventory = new Inventory();
	setSize(400, 200);

	//Initializes the inventoryLayout instance var to a new FlowLayout instance
	inventoryLayout = new FlowLayout();

	//Sets the LayoutManager of this JFrame to FlowLayout and
	//sets the JFrame's default close operation
	this.setLayout(inventoryLayout);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);

	weaponSelect = new JComboBox(mc.getInventory().getInvArray().toArray());
	//Initialize the selectWeapon instance var to a new JButton instance
	this.set = new JButton("Select");
	set.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Weapon toSelect = (Weapon) weaponSelect.getSelectedItem();
		    mc.swapCurrentWeapon(toSelect);
		}
	    });
	//Adds the JComboBox and the JButton to the JFrame with respect
	//to the FlowLayout
	this.add(weaponSelect);
	this.add(set);
	this.setVisible(true);
    }

    public InventoryDisplay(final Display disp) {
	//Calls the constructor for the JFrame class, which InventoryDisplay extends.
	super("Inventory");

	//We need to create a new Inventory to display
	Inventory dispInventory = new Inventory();
	setSize(400, 200);

	//Initializes the inventoryLayout instance var to a new FlowLayout instance
	inventoryLayout = new FlowLayout();

	//Sets the LayoutManager of this JFrame to FlowLayout and
	//sets the JFrame's default close operation
	this.setLayout(inventoryLayout);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);

	weaponSelect = new JComboBox(disp.gm.mc.getInventory().getInvArray().toArray());
	//Initialize the selectWeapon instance var to a new JButton instance
	this.set = new JButton("Select");
	set.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Weapon toSelect = (Weapon) weaponSelect.getSelectedItem();
		    disp.gm.mc.swapCurrentWeapon(toSelect);
		}
	    });
	//Adds the JComboBox and the JButton to the JFrame with respect
	//to the FlowLayout
	this.add(weaponSelect);
	this.add(set);
	this.setVisible(true);
    }
    
}
