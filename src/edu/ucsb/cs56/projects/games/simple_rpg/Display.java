package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;

import javax.swing.JPanel;

/**
 * Custom JPanel, to represent the game display
 *
 * @author Alvin Tan, Nick Perry
 */
public class Display extends JPanel {

	public static final int RAND_X_COORD = (int)(170 + Math.random() * 630);
	public static final int RAND_Y_COORD = (int)(5 + Math.random() * 565);

	Game gm;
	boolean isSpawned = false;
	boolean firstSpawn = true;
	int dxMC = 0;
	int dyMC = 0;
	int dxGob = 0;
	int dyGob = 0;
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
	spawn();
	if(isSpawned == true) {
		  randMove();
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
				dyGob -= 4;
			}
			break;
		case 2:
			if (dyGob <= 0) {
				dyGob += 4;
			}
			break;
		case 3:
			if (dxGob <= 230) {
				dxGob += 4;
			}
			break;
		case 4:
			if (dxGob >= -230) {
				dxGob -= 4;
			}
			break;
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
                System.exit(0);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
							if (dyMC >= -560) {
								dyMC -= 4;
							}
							repaint();
            	} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
								if (dyMC <= 0) {
									dyMC += 4;
								}
								repaint();
            	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
								if (dxMC <= 230) {
									dxMC += 4;
								}
								repaint();
            	} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
								if (dxMC >= -230) {
									dxMC -= 4;
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
