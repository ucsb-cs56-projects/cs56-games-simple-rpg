package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class ShopDisplay {

	public ShopDisplay() {
		Shop weaponShop = new Shop();
		String [] weaponNames = new String[5];
		weaponNames[0] = "Fists";
		for (int i = 1; i < weaponShop.inventory.size() + 1; i++) {
			Weapon temp = weaponShop.inventory.get(i);
			weaponNames[i] = temp.getWeaponName();
		}
		JFrame frame = new JFrame("Shop");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComboBox weaponSelect = new JComboBox(weaponNames);
		JButton buy = new JButton("Buy");
		frame.add(weaponSelect, BorderLayout.CENTER);
		frame.add(buy, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
