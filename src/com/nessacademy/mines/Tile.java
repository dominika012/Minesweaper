package com.nessacademy.mines;

public abstract class Tile {

	private State state;
	private int value;
	
	
	public Tile(State state, int value) {
		super();
		this.state = state;
		this.value = value;
	}
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	

}
