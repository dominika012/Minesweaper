package com.nessacademy.mines;

public class Mine extends Tile{

	public static int value = -1;

	public Mine(State state) {
		super(state, value);
	}

	
	
	@Override
	public String toString() {
		return "X";
	}

	
}
