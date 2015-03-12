package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents the display that shows the shop with weapon selection 
 * and purchase options of items declared in the Shop class
 *
 * @author Vivek Patel
 * @version CS56-W15 03/08, 1.0 
 */

public class ShopDisplay extends JFrame {
	
	private JComboBox weaponSelect;
	private JButton buy;
	private Shop weaponShop;
	private FlowLayout shopLayout;
	
	/**
 	 * No-arg constructor for the ShopDisplay class
 	 */ 
	public ShopDisplay() {
		//Calls the constructor for the JFrame class, which ShopDisplay extends.	
		super("Shop");

		//Initializes the weaponShop instance var to new Shop instance
		weaponShop = new Shop();
		setSize(400, 200);

		//Initializes the shopLayout instance var to a new FlowLayout instance
		shopLayout = new FlowLayout();

		//Sets the LayoutManager of this JFrame to FlowLayout and
		//sets the JFrame's default close operation
		this.setLayout(shopLayout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initializes the weaponSelect instance var to a new JComboBox instance
		weaponSelect = new JComboBox();

		//Creates an Iterator for the shop inventory and adds the
		//items in the ArrayList one by one to the JComboBox
		Iterator i = weaponShop.getInventory().iterator(); 
		while (i.hasNext()) {
			weaponSelect.addItem(i.next());
		}

		//Initializes the buy instance var to a new JButton instance
		this.buy = new JButton("Buy");

		//Adds the JComboBox and the JButton to the JFrame with respect
		//to the FlowLayout
		this.add(weaponSelect);
		this.add(buy);
	}
}
