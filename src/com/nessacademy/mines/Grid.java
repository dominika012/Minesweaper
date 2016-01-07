package com.nessacademy.mines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid{

	private int mineCounter;
	private int rowCounter;
	private int columnCounter;
	public Tile[][] tiles;
	
	public Grid(int mineCounter, int rowCounter, int columnCounter) {
		super();
		this.mineCounter = mineCounter;
		this.rowCounter = rowCounter;
		this.columnCounter = columnCounter;
		this.tiles = new Tile[rowCounter][columnCounter];
	}

	public int getMineCounter() {
		return mineCounter;
	}

	public void setMineCounter(int mineCounter) {
		this.mineCounter = mineCounter;
	}

	public int getRowCounter() {
		return rowCounter;
	}

	public void setRowCounter(int rowCounter) {
		this.rowCounter = rowCounter;
	}

	public int getColumnCounter() {
		return columnCounter;
	}

	public void setColumnCounter(int columnCounter) {
		this.columnCounter = columnCounter;
	}

	
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles() {
		randomMines();
		fillGrid(rowCounter, columnCounter);
	}

	private int randomValue(int max){
		Random random = new Random();
		return random.nextInt(max);
	}
	
	private void randomMines(){
		State state = null;
		for(int count = 0; count<mineCounter;count++){
			int randomRow = randomValue(rowCounter);
			int randomColumn = randomValue(columnCounter);
			if(tiles[randomRow][randomColumn]==null)
				tiles[randomRow][randomColumn]= new Mine(state.CLOSED);
			else
				count-=1;
		}
	}
	
	private void fillByZeros(int rowCounter, int columnCounter){
		State state = null;
		for(int row=0;row<rowCounter;row++){
			for(int column=0;column<columnCounter;column++){
				if(tiles[row][column]==null){
					tiles[row][column] = new Clue(state.CLOSED,0);
					
				}
			}
		}
	}
	
	private void fillGrid(int rowCounter, int columnCounter){
		State state = null;
		fillByZeros(rowCounter, columnCounter);
		for(int row=0;row<rowCounter;row++){
			for(int column=0;column<columnCounter;column++){
				if(tiles[row][column]==null){
					tiles[row][column].setValue(mineNeighborsCounter(row, column));
				}
			}
		}
	}	
	
	
	public List<String> getNeighbors( int row, int column ) {
	    List<String> neighbors = new ArrayList<String>();

	    for( int r = -1; r <= 1; ++r ) {
	        for( int c = -1; c <= 1; ++c ) {
	            if( r == 0 && c == 0 ) {
	                continue;
	            }
	            if( r + row >= 0 && r + row < rowCounter &&
	                c + column >= 0 && c + column < columnCounter ) {
	                    neighbors.add(tiles[r + row][c + column].toString());
	            }
	        }
	    }
	    return neighbors;
	}
	
	public int mineNeighborsCounter(int row, int column){
		int counter = 0;
		for(String tile : getNeighbors(row, column)){
			if(tile.equals("X")){
				counter+=1;
			}
		}
		return counter;
	}
	
	
	public void printGrid(){
		State state = null;
		for(int row=0;row<rowCounter;row++){
			for(int column=0;column<columnCounter;column++){
				state = tiles[row][column].getState();
				String output = null;
				/*if(state.equals(State.CLOSED))
					output = "-";
				else if(state.equals(State.OPEN))*/
					output = String.valueOf(tiles[row][column]);
				/*else if(state.equals(State.MARKED))
					output = "M";*/
					System.out.print(output + "\t");
			}
			System.out.println("\n");
		}
		
	}
	
}
