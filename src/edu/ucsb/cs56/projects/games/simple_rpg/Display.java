package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Custom JPanel, to represent the game display
 *
 * @author Alvin Tan, Nick Perry, Daniel Chojnacki
 */
public class Display extends JPanel {

	Game gm;
	boolean goblIsSpawned = false;
	boolean trdrIsSpawned = false;
	boolean ambushPlayer = true;
	boolean mcOverlap = false;
	boolean escape = false;
        // the coordinates for our main character
        // index 0 is for our x component
        // index 1 is for our y component
				int[] dMC = {208,532};
        // the coordinates for our goblin
        int[] dGob = {592,36};
				int[] dTrdr = {300, 300};
        // our goblin
        Goblin gobl;
				Trader trdr;
    /**
     * Default Constructor. Adds a KeyListener.
     */
    public Display() {
        //We have a display, so now we need the actual game
        gm = new Game();
	//We create a new Goblin
	gobl = new Goblin();
	trdr = new Trader(2);
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

	// create our GobinFigure and MainCharacterFigure
	GoblinFigure gf = new GoblinFigure(gobl);
	MainCharacterFigure mcf = new MainCharacterFigure(gm.mc);
	TraderFigure trf = new TraderFigure(trdr);

        Color g2Color = g2.getColor();

	//draw the map for our Display
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
        g2.fill3DRect(30, 620, 150 * (gm.mc.getHP()/gm.mc.getMaxHP()), 20, true); // our HP bar
        g2.setColor(Color.BLUE);
        g2.fill3DRect(30, 660, 150 * (gm.mc.getMP()/gm.mc.getMaxMP()), 20, true); // our MP bar
        g2.setColor(Color.ORANGE);
        g2.fill3DRect(30, 700, gm.mc.getXP(), 20, true); // our EXP bar
        g2.setColor(Color.BLACK);
        g2.drawString("Press Esc to Exit", 0, 10);
        g2.drawString("HP", 10, 620);
        g2.drawString("MP", 10, 660);
        g2.drawString("EXP", 10, 700);
	g2.drawString("LEVEL " + gm.currentMap, 10, 750); // display which level we are on (currently, we can only go to level 0)
	g2.setColor(Color.BLACK);

	// set our MainCharacter's coordinates (based on the instance variables above)
	mcf.mc.setX(dMC[0]);
	mcf.mc.setY(dMC[1]);

	// draw our MainCharacterFigure
	g2.draw(mcf);

	// either spawn or move our Goblin
	spawnGoblin();
	if(goblIsSpawned) {
		  ambushMove();
		  g2.setColor(Color.RED);
		  // set our Goblin's coordinates
			gf.gob.setX(dGob[0]);
			gf.gob.setY(dGob[1]);
			g2.draw(gf);
	}

	spawnTrader();
	if(trdrIsSpawned) {
		  randMove();
			updateMCOverlap();
		  g2.setColor(Color.WHITE);
		  // set our Trader's coordinates
			trf.trdr.setX(dTrdr[0]);
			trf.trdr.setY(dTrdr[1]);
			g2.draw(trf);
	}
}

    /**
     * To spawn our Goblin
     */
    private void spawnGoblin() {
			int rand = (int)(1 + Math.random() * 10);
			if (rand <= 3)
				goblIsSpawned = true;
    }

		private void spawnTrader() {
			int rand = (int)(1 + Math.random() * 10);
			if (rand <= 1)
				trdrIsSpawned = true;
		}

		private void updateMCOverlap() {
			if(Math.abs(gm.mc.getX()-trdr.getX()) <= 4 || Math.abs(gm.mc.getY()-trdr.getY()) <= 4){
					 mcOverlap = true;
				 }
		}

    /**
     * Used to randomly move the Trader around on the screen
     * every time the Display is redrawn
     */
    private void randMove() {
	int rand = (int)(1 + Math.random() * 4);
	switch (rand) {
		case 1:
			if (dTrdr[1] >= 5) {
				dTrdr[1] -= 4;
			}
			break;
		case 2:
			if (dTrdr[1] <= 560) {
				dTrdr[1] += 4;
			}
			break;
		case 3:
			if (dTrdr[0] <= 625) {
				dTrdr[0] += 4;
			}
			break;
		case 4:
			if (dTrdr[0] >= 175) {
				dTrdr[0] -= 4;
			}
			break;
	}
    }

    /**
     * Used to move the Goblin closer to the MainCharacter
     * everytime the Display is redrawn
     */
    private void ambushMove() {
	if ( (Math.abs(dGob[0]-dMC[0]) > 0) || (Math.abs(dGob[1]-dMC[1]) > 0) ) {
	    if ( Math.abs(dGob[0]-dMC[0]) > Math.abs(dGob[1]-dMC[1]) ) {
		if (dGob[0] > dMC[0]) {
		    dGob[0] -= 4;
		}
		else {
		    dGob[0] += 4;
		}
	    }
	    else {
		if (dGob[1] > dMC[1]) {
		    dGob[1] -= 4;
		}
		else {
		    dGob[1] += 4;
		}
	    }
	}
    }

    public class PlayerListener implements KeyListener {

        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
         */
        @Override

        //Controls the MainCharacterFigure's movement based on user input from the arrow keys
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
								escape = true;
                System.exit(0);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
							if (dMC[1] >= 5) {
								dMC[1] -= 4;
							}
							repaint();
            	} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
								if (dMC[1] <= 560) {
									dMC[1] += 4;
								}
								repaint();
            	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
								if (dMC[0] <= 625) {
									dMC[0] += 4;
								}
								repaint();
            	} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
								if (dMC[0] >= 175) {
									dMC[0] -= 4;
								}
								repaint();
            }
  			}

		/* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
            @Override
            public void keyReleased (KeyEvent e){
                // TODO Auto-generated method stub
                return;
            }

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
            @Override
            public void keyTyped (KeyEvent e){
                // TODO Auto-generated method stub
                return;
            }

        }
}
