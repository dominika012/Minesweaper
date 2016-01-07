package com.nessacademy.mines;

import java.util.Random;

public class Launcher {

	public static void main(String[] args) {
		Grid grid = new Grid(6, 6, 6);
		grid.setTiles();
		grid.printGrid();
		
		System.out.println(grid.getNeighbors(1, 0));
		System.out.println(grid.mineNeighborsCounter(1, 0));
	}

}
