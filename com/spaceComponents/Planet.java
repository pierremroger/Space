package com.spaceComponents;

public class Planet {

	public int x;
	public int y;
	public int locX;
	public int locY;

	public int radius;
	public double density;

	public double mass;

	public Planet() {
	}

	public Planet(int centerX, int centerY, int radius, double density) {
		super();
		this.x = centerX;
		this.y = centerY;
		this.radius = radius;
		this.density = density;
		this.mass = getMass();
		this.locX = centerX-radius;
		this.locY = centerY-radius;
	}

	public double getMass() {
		return 2 * Math.PI * radius *density;
	}

	public double getDistanceCentre(Satellite s) {
		double d = Math.sqrt((this.x-s.c.getLast().x)*(this.x-s.c.getLast().x)+(this.y-s.c.getLast().y)*(this.y-s.c.getLast().y));
		if (d<5) { 
			return 5.0; // evite divergence 
		}
		else 
			return d;
	}

	public double getDistanceGround(Satellite s) {
		return getDistanceCentre(s)-this.radius;
	}

	public boolean isCrash(Satellite s) {
		return getDistanceGround(s) < 0;
	}

}
