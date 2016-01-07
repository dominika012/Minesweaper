package com.nessacademy.mines;

public class Clue extends Tile{

	private int value;



	public Clue(State state, int value) {
		super(state, value);
		
	}

	
	public int getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return  value+"";
	}
}
