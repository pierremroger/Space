package com.spaceComponents;

import java.util.LinkedList;

import com.structure.Constants;

public class Satellite {

	public LinkedList<Cinetic> c;
	public int size;
	public double mass;

	public Satellite() {		
	}

	public Satellite(double x, double y, int size, double mass, double vX, double vY) {
		super();

		this.size = size;
		this.mass = mass;
		this.c = new LinkedList<Cinetic>();
		c.add(new Cinetic(x,y,vX,vY));

	}

	public double getAmplitudeForce(Planet p) {
		return Constants.G * this.mass * p.mass / Math.pow(p.getDistanceCentre(this),2);
	}

//	public double getForceX(Planet p) {
//		return (p.x-this.c.getLast().x)*getAmplitudeForce(p);
//	}

	public double getForceX(LinkedList<Planet> p) {
		double f=0;
		for(int i=0; i<p.size();i++) {
			f += (p.get(i).x-this.c.getLast().x)*getAmplitudeForce(p.get(i));
		}
		return f;
	}

//	public double getForceY(Planet p) {
//		return (p.y-this.c.getLast().y)*getAmplitudeForce(p);
//	}
	
	public double getForceY(LinkedList<Planet> p) {
		double f=0;
		for(int i=0; i<p.size();i++) {
			f += (p.get(i).y-this.c.getLast().y)*getAmplitudeForce(p.get(i));
		}
		return f;
	}
	
//	public double getNextSpeedX(Planet p) {
//		return getForceX(p)*Constants.dt/this.mass + this.c.getLast().vX;
//	}
	
	public double getNextSpeedX(LinkedList<Planet> p) {
		return getForceX(p)*Constants.dt/this.mass + this.c.getLast().vX;
	}

//	public double getNextSpeedY(Planet p) {
//		return getForceY(p)*Constants.dt/this.mass + this.c.getLast().vY;
//	}
	
	public double getNextSpeedY(LinkedList<Planet> p) {
		return getForceY(p)*Constants.dt/this.mass + this.c.getLast().vY;
	}

//	public double getNextX(Planet p) {
//		return getNextSpeedX(p)*Constants.dt+this.c.getLast().x;
//	}
	
	public double getNextX(LinkedList<Planet> p) {
		return getNextSpeedX(p)*Constants.dt+this.c.getLast().x;
	}
	
//	public double getNextY(Planet p) {
//		return getNextSpeedY(p)*Constants.dt+this.c.getLast().y;
//	}
	
	public double getNextY(LinkedList<Planet> p) {
		return getNextSpeedY(p)*Constants.dt+this.c.getLast().y;
	}

//	public LinkedList<Cinetic> getNextLocation(Planet p) {
//		this.c.add(new Cinetic(getNextX(p),getNextY(p),getNextSpeedX(p),getNextSpeedY(p)));
//		return this.c;
//	}
	
	public LinkedList<Cinetic> getNextLocation(LinkedList<Planet> p) {
		this.c.add(new Cinetic(getNextX(p),getNextY(p),getNextSpeedX(p),getNextSpeedY(p)));
		return this.c;
	}
	

	public void displayInfo(LinkedList<Planet> p) {
		System.out.println(" Force X : " + getForceX(p));
		System.out.println(" Force Y : " + getForceY(p));
		System.out.println(" next xV : " + getNextSpeedX(p));
		System.out.println(" next yV : " + getNextSpeedY(p));
		System.out.println(" next x : " + getNextX(p));
		System.out.println(" next y : " + getNextY(p));

	}

	public class Cinetic {

		public double x, y;
		public double vX,vY;

		public Cinetic() {
		}

		public Cinetic(double x, double y, double vX, double vY) {
			this.x=x;
			this.y=y;
			this.vX=vX;
			this.vY=vY;
		}
	}

}
