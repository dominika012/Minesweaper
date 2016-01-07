package com.nessacademy.entity;

public abstract class Tile {

	private State state;
	
	
	public Tile(State state) {
		super();
		this.state = state;
	}
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	

}
