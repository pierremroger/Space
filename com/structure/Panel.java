package com.structure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import com.spaceComponents.Planet;
import com.spaceComponents.Satellite;

public class Panel extends JPanel { 

	public Satellite s;
	public LinkedList<Planet> p;

	public Panel() {
	}

	public Panel(Satellite s, LinkedList<Planet> p) {
		super();
		this.s = s;
		this.p = p;
	}

	public void paintComponent(Graphics g){

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.BLACK);
		for (int i=0;i<p.size();i++) {
			g.fillOval(p.get(i).locX, p.get(i).locY, 2*p.get(i).radius, 2*p.get(i).radius);
		}

		g.setColor(Color.RED);
		g.fillOval((int)(s.c.getLast().x)-s.size,(int)(s.c.getLast().y)-s.size, 2*s.size, 2*s.size);

		for (int i=0; i<s.c.size()-1;i++) {
			g.fillOval((int)(s.c.get(i).x)-s.size, (int)(s.c.get(i).y)-s.size, 3, 3);
		}
		g.setColor(Color.green);
		g.fillRect(1200, 300, 50, 5);
		g.fillRect(800, 200, 5, 50);
	}

}