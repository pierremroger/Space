package com.structure;

public class Constants {
	
	
	public static double dt = 1; // s
	
	public static double G = 6.67e-11 * 1e7; // N.m2/kg2
	public static double massEarth = 5.97e24; //kg
	public static double radiusEarth = 6371000; // m
	
	public static double densityEarth = massEarth /(4/3*Math.PI*Math.pow(radiusEarth,3)); // kg/m3
}
