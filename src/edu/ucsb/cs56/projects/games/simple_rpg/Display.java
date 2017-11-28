package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;

import javax.swing.JPanel;

import java.util.Timer;

/**
 * Custom JPanel, to represent the game display
 *
 * @author Alvin Tan, Nick Perry
 */
public class Display extends JPanel {

    // making the spawns in arbitrary locations based on hardcoded numbers is idiotic
	//public static final int RAND_X_COORD = (int)(170 + Math.random() * 630);
	//public static final int RAND_Y_COORD = (int)(5 + Math.random() * 565);

    // TODO: fix location handling using class data
    public static final int RAND_X_COORD = 300;
    public static final int RAND_Y_COORD = 100;

	Game gm;
	boolean isSpawned = false;
	boolean firstSpawn = true;
	int dxMC = 0;
	int dyMC = 0;
	int dxGob = 0;
	int dyGob = 0;

    // determines how fast anything moves
    // ideally this should be determined by stats
    int spdMC = 5;
    int spdGob = 2;

    /**
     * Default Constructor. Adds a KeyListener.
     */
    public Display() {
        //We have a display, so now we need the actual game
        gm = new Game();
        this.addKeyListener(new PlayerListener());
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
	GeneralPath gp;
	GoblinFigure gf = new GoblinFigure(gm.gob);
	MainCharacterFigure mcf = new MainCharacterFigure(gm.mc);
        Color g2Color = g2.getColor();
        Tile[][] map = gm.getCurrentMap();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 40; j++) {
                switch (map[i][j].getType()) {
                    case 0:
                        g2.setColor(Color.GREEN);
                        g2.fillRect(j * 20, i * 20, 20, 20);
                        break;
                    case 1:
                        g2.setColor(Color.BLUE);
                        g2.fillRect(j * 20, i * 20, 20, 20);
                        break;
		    case 2:
		        g2.setColor(Color.LIGHT_GRAY);
		        g2.fillRect(j * 20, i * 20, 20, 20);
		        break;
                    default:
                        g2.setColor(Color.GREEN);
                        g2.fillRect(j * 20, i * 20, 20, 20);
                        break;
                }
            }
        }
	g2.setColor(Color.GRAY);
	g2.fillRect(0, 600, 800, 200);
	g2.setColor(Color.RED);
        g2.fill3DRect(30, 620, 150 * (gm.mc.getHp()/gm.mc.getMaxHP()), 20, true);
        g2.setColor(Color.BLUE);
        g2.fill3DRect(30, 660, 150 * (gm.mc.getMp()/gm.mc.getMaxMP()), 20, true);
        g2.setColor(Color.ORANGE);
        g2.fill3DRect(30, 700, gm.mc.getXp(), 20, true);
        g2.setColor(Color.BLACK);
        g2.drawString("Press Esc to Exit", 0, 10);
        g2.drawString("HP", 10, 620);
        g2.drawString("MP", 10, 660);
        g2.drawString("EXP", 10, 700);
	g2.drawString("LEVEL " + gm.currentMap, 10, 750);
	g2.setColor(Color.BLACK);
	mcf.mc.setX(400 + dxMC);
	mcf.mc.setY(565 + dyMC);
	g2.draw(mcf);

    // uhhhhhh why is the enemy behavior determined in display
	spawn();
	if(isSpawned == true) {
		  determineLocations(); // determine locations of gob and player every loop
          enemyMove(); // determines goblin behavior
		  g2.setColor(Color.RED);
			gf.gob.setX(RAND_X_COORD + dxGob);
			gf.gob.setY(RAND_Y_COORD + dyGob);
			g2.draw(gf);
      }
    }

    private void spawn() {
	    int rand = (int)(1 + Math.random() * 10);
	    if (rand <= 3)
		    isSpawned = true;
    }

    private void randMove() {
	    int rand = (int)(1 + Math.random() * 4);
	    switch (rand) {
		    case 1:
			    if (dyGob >= -560) {
				    dyGob -= spdGob;
			    }
			    break;
		    case 2:
			    if (dyGob <= 0) {
				    dyGob += spdGob;
			    }
			    break;
		    case 3:
			    if (dxGob <= 230) {
				    dxGob += spdGob;
			    }
			    break;
		    case 4:
			    if (dxGob >= -230) {
				    dxGob -= spdGob;
			    }
			    break;
	    }
    }

    // location values of mc and ONE SINGLE GOBLIN
    // this is a batshit implementation but the classes themselves don't store the actual locations
    // literally will break as soon as there is more than one goblin
    int xLocMC, yLocMC, xLocGob, yLocGob;
    private void determineLocations() {
        xLocMC = (400 + dxMC);
        yLocMC = (565 + dyMC);
        xLocGob = (RAND_X_COORD + dxGob);
        yLocGob = (RAND_Y_COORD + dyGob);
    }

    private double calcDistance(int xd, int yd) {
        return Math.sqrt((xd*xd) + (yd*yd));
    }
        
    // determine enemy movement state
    // called once per game loop
    private void enemyMove() {
        int xDist = xLocMC - xLocGob;
        int yDist = yLocMC - yLocGob;

        // distance between gob and player
        int d = (int) calcDistance(xDist, yDist);

        // followDistance = how close the player needs to be before goblin begins moving towards player
        // collisionDistance = how close the player needs to be to collide with the goblin
        int followDistance = 200, collisionDistance = 10;

        // move toward player if within following range
        if (d < followDistance && d > collisionDistance) {
            // set sign for speed based on where player is in relation to goblin
            int xsg = (xDist < 0) ? -1 : 1;
            int ysg = (yDist < 0) ? -1 : 1;
            if (calcDistance((xDist+xsg), yDist) > calcDistance(xDist, (yDist+ysg)))
                dxGob += xsg*spdGob;
            else
                dyGob += ysg*spdGob;
        // handle collisions
        } else if (d < collisionDistance) {
            // TODO: if collide, begin battle

        // move randomly otherwise
        } else { randMove(); }

        // collision testing
        
        

    }

    public class PlayerListener implements KeyListener {

        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
         */

        //Controls the MainCharacterFigure's movement based on user input from the arrow keys
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                case KeyEvent.VK_UP:
                    if (dyMC >= -560) { dyMC -= spdMC; }
                    break;
                case KeyEvent.VK_DOWN:
                    if (dyMC <= 0) { dyMC += spdMC; }
                    break;
                case KeyEvent.VK_LEFT:
                    if (dxMC >= -230) { dxMC -= spdMC; }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (dxMC <= 230) { dxMC += spdMC; }
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
                default:
                    break;
            }
        }

		/* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
        @Override
        public void keyReleased (KeyEvent e){
        }

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
            @Override
            public void keyTyped (KeyEvent e){
                return;
            }

        }
}
