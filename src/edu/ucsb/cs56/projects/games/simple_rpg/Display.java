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
    public static final int playerSpawnCoordX = 400;
    public static final int playerSpawnCoordY = 565;

    public static final int goblinSpawnCoordX = 300;
    public static final int goblinSpawnCoordY = 100;

    public static final int cowardSpawnCoordX = 300;
    public static final int cowardSpawnCoordY = 500;

	Game gm;
	boolean isSpawned = false;
	boolean firstSpawn = true;

    // hacky location handling
    // currently, has main character, a goblin, and a coward
	int dxMC = 0, dyMC = 0, dxGob = 0, dyGob = 0, dxCow = 0, dyCow = 0;

    // determines how fast anything moves
    // ideally this should be determined by stats
    int spdMC = 6;
    int spdGob = 3;
    int spdCow = 2;

    // wall or edge locations
    int topEdge = -560;
    int botEdge = 0;
    int leftEdge = -230;
    int rightEdge = 230;

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
    GoblinFigure cf = new GoblinFigure(gm.cow);
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
	mcf.mc.setX(playerSpawnCoordX + dxMC);
	mcf.mc.setY(playerSpawnCoordY + dyMC);
	g2.draw(mcf);

    // uhhhhhh why is the enemy behavior determined in display
	spawn();
	if(isSpawned == true) {
		  determineLocations(); // determine locations of gob and player every loop
          enemyMove(); // determines enemy behavior
            
		  g2.setColor(Color.RED);
			gf.gob.setX(goblinSpawnCoordX + dxGob);
			gf.gob.setY(goblinSpawnCoordY + dyGob);
			g2.draw(gf);
          g2.setColor(Color.YELLOW);
            cf.gob.setX(cowardSpawnCoordX + dxCow);
			cf.gob.setY(cowardSpawnCoordY + dyCow);
			g2.draw(cf);
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
			    if (dyGob >= topEdge) { dyGob -= spdGob; }
			    break;
		    case 2:
                if (dyGob <= botEdge) { dyGob += spdGob; }
			    break;
		    case 3:
			    if (dxGob >= leftEdge) { dxGob -= spdGob; }
			    break;
		    case 4:
			    if (dxGob <= rightEdge) { dxGob += spdGob; }
                
			    break;
	    }
    }

    // location values
    // this is a batshit implementation but the classes themselves don't store the actual locations
    int xLocMC, yLocMC, xLocGob, yLocGob, xLocCow, yLocCow;
    private void determineLocations() {
        xLocMC = (playerSpawnCoordX + dxMC);
        yLocMC = (playerSpawnCoordY + dyMC);
        xLocGob = (goblinSpawnCoordX + dxGob);
        yLocGob = (goblinSpawnCoordY + dyGob);
        xLocCow = (cowardSpawnCoordX + dxCow);
        yLocCow = (cowardSpawnCoordY + dyCow);
    }

    private double calcDistance(int xd, int yd) {
        return Math.sqrt((xd*xd) + (yd*yd));
    }
        
    // determine enemy movement state
    // called once per game loop
    private void enemyMove() {
        goblinMove();
        cowardMove();
    }

    // normal goblin behavior
    private void goblinMove() {
        int xDist = xLocMC - xLocGob;
        int yDist = yLocMC - yLocGob;

        // distance between gob and player
        int d = (int) calcDistance(xDist, yDist);

        // followDistance = how close the player needs to be before goblin begins moving towards player
        // collisionDistance = how close the player needs to be to collide with the goblin
        int followDistance = 200, collisionDistance = 10;

        // if within following range
        if (d < followDistance && d > collisionDistance) {
            // set sign for speed based on where player is in relation to goblin
            int xDir = (xDist < 0) ? -1 : 1;
            int yDir = (yDist < 0) ? -1 : 1;

            // move TOWARD player if within follow distance
            if (calcDistance((xDist+xDir), yDist) > calcDistance(xDist, (yDist+yDir)))
                dxGob += xDir*spdGob;
            else
                dyGob += yDir*spdGob;

        // handle collisions
        } else if (d < collisionDistance) {
            gm.mc.attacked(2);
        // out of range
        } else { randMove(); }
    }

    // cowardly goblin behavior
    private void cowardMove() {
        int pxDist = xLocMC - xLocCow, pyDist = yLocMC - yLocCow;
        int gxDist = xLocGob - xLocCow, gyDist = yLocGob - yLocCow;
        int pd = (int) calcDistance(pxDist, pyDist); // distance between coward and player
        int gd = (int) calcDistance(gxDist, gyDist); // distance between coward and other goblin

        //int exDist = Math.min(Math.abs(xLocCow - leftEdge), Math.abs(rightEdge - xLocCow));
        //int eyDist = Math.min(Math.abs(yLocCow - topEdge), Math.abs(botEdge - yLocCow));
        //int ed = Math.min(exDist, eyDist); // distance between coward and closest edge

        // followDistance = how close the player needs to be before coward begins moving towards player
        // scaredDistance = how close the player needs to be before coward GOES FAST
        // collisionDistance = how close the player needs to be to collide with the coward
        int followDistance = 150, scaredDistance = 50, collisionDistance = 10;

        int xDir, yDir; // used for direction calculation; sets sign based on location

        // if within following range of player
        if (pd < followDistance && gd >= followDistance) {
            xDir = (pxDist < 0) ? -1 : 1;
            yDir = (pyDist < 0) ? -1 : 1;
            if (pd < scaredDistance) { xDir += 1; yDir += 1; } // run faster if player is close by

            // move AWAY from player
            if (calcDistance((pxDist+xDir), pyDist) < calcDistance(pxDist, (pyDist+yDir)))
                dxCow -= xDir*spdCow;
            else 
                dyCow -= yDir*spdCow;

        // if within following range of both player and other goblin
        } else if (pd < followDistance && gd < followDistance) {
            xDir = (gxDist < 0) ? -1 : 1;
            yDir = (gyDist < 0) ? -1 : 1;
            if (pd < scaredDistance) { xDir += 1; yDir += 1; } // run faster if player is close by

            // move TOWARD from other goblin
            if (calcDistance((gxDist+xDir), gyDist) > calcDistance(gxDist, (gyDist+yDir)))
                dxCow += xDir*spdCow;
            else 
                dyCow += yDir*spdCow;
        // handle collisions
        } else if (pd < collisionDistance) {
            //gm.mc.setXp(gm.mc.getXp() + 10);
        }
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
                    if (dyMC >= topEdge) { dyMC -= spdMC; }
                    break;
                case KeyEvent.VK_DOWN:
                    if (dyMC <= botEdge) { dyMC += spdMC; }
                    break;
                case KeyEvent.VK_LEFT:
                    if (dxMC >= leftEdge) { dxMC -= spdMC; }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (dxMC <= rightEdge) { dxMC += spdMC; }
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
