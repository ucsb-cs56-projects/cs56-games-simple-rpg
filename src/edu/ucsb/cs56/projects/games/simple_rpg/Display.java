/**
 *
 */
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
 * @author Alvin Tan
 */
public class Display extends JPanel {

	Game gm;
	int dx = 0;
	int dy = 0;

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
        g2.setColor(g2Color);
	gm.mc.setX(400 + dx);
	gm.mc.setY(550 + dy);	
	//Adds a new Area object with all the pieces of the character
	Ellipse 
	
    }

    public class PlayerListener implements KeyListener {

        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
         */
        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
		dy++;
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
