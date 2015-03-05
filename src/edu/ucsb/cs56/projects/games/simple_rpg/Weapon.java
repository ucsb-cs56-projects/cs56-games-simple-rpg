

package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.Graphics2D;
import java.awt.geom.Area;

public class Weapon {

	private int weapon;
	private String weaponName;
	
	public Weapon() {
		this.weapon = 0;
		this.weaponName = this.getWeaponName();
	}

	public Weapon(int weapon) {
		this.weapon = weapon;
		this.weaponName = this.getWeaponName;
	}	

	public int getWeapon() {
		return this.weapon;
	}	
	
	public String getWeaponName() {
		switch(this.weapon) {
			case(0) {
				return "Fists";
			}
			case(1) {
				return "Wooden sword";
			}
			case(2) {
				return "Axe";
			}
			case(3) {
				return "Warhammer";
			}
			case(4) {
				return "Iron sword";
			}	
		}		
	}
}
