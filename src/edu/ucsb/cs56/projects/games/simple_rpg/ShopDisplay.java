package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class ShopDisplay extends JFrame {
	
	private JComboBox weaponSelect;
	private JButton buy;
	private Shop weaponShop;
	
	public ShopDisplay() {
		weaponShop = new Shop();
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.weaponSelect = new JComboBox(weaponShop.inventory.toArray());
		this.buy = new JButton("Buy");
		add(weaponSelect, BorderLayout.CENTER);
		add(buy, BorderLayout.CENTER);
	}
}
