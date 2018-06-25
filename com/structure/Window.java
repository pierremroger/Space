package com.structure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Timer;

import javax.swing.JFrame;

import com.spaceComponents.Planet;
import com.spaceComponents.Satellite;

public class Window extends JFrame implements KeyListener, MouseListener {

	private Panel pan = new Panel();
	long start, end;

	public Window() {
		
		start=0;
		end = 0;
		
		LinkedList<Planet> P = new LinkedList<Planet>();
//		P.add(new Planet(300,400,40,700));
//		P.add(new Planet(800,400,40,700));
//		P.add(new Planet(550,200,40,700));

		pan.s = new Satellite(700,400,5,35,3,0);
		pan.p = P;
		
		this.setTitle(" Space by PierreM");
		this.setSize(1600, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pan);
		this.setVisible(true);

		// initialisation du listener keyboard
//		addKeyListener(this);
//		setFocusable(true);
		
		// initialisation du listener mouse
		addMouseListener(this);
		setFocusable(true);


		// Lancement du jeu
		Game();
	}

	public void Game() {
		while (true) {
			
			pan.s.getNextLocation(pan.p);
//			pan.s.displayInfo(pan.p);
			pan.repaint();

			try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int ux = (int)(Math.random()*1600);
		int uy = (int)(Math.random()*800);
		int t = (int)(Math.random()*50);
		
		pan.p.add(new Planet(ux,uy,t,700));
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		start = System.currentTimeMillis();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		end = System.currentTimeMillis();
		int size = (int) (end-start)/10;
		pan.p.add(new Planet(e.getX(),e.getY(),size,150));

		
	}

}
