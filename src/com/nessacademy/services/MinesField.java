package com.nessacademy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nessacademy.entity.Clue;
import com.nessacademy.entity.Mine;
import com.nessacademy.entity.State;
import com.nessacademy.entity.Tile;

public class MinesField{

	private int mineCounter;
	private int rowCounter;
	private int columnCounter;
	private Tile[][] tiles;
	
	
	public MinesField(int mineCounter, int rowCounter, int columnCounter) {
		super();
		this.mineCounter = mineCounter;
		this.rowCounter = rowCounter;
		this.columnCounter = columnCounter;
		this.tiles = new Tile[rowCounter][columnCounter];
	}
	
	
	public Tile[][] getTiles() {
		return tiles;
	}

	
	public void setTiles() {
		randomMines();
		fillGrid(rowCounter, columnCounter);
	}

	
	public void printMinesField(){
		
		System.out.print("\t");
		for(int column = 0; column<columnCounter;column++)
			System.out.print(column + "\t");
		System.out.println();
		
		
		for(int row=0;row<rowCounter;row++){
				System.out.print((char)(row + 65) + "\t");
			for(int column=0;column<columnCounter;column++){
				State state = tiles[row][column].getState();
				String output = null;
				
				if(state.equals(State.CLOSED))
					output = "-";
				else if(state.equals(State.OPEN))
					output = tiles[row][column].toString();
				else if(state.equals(State.MARKED))
					output = "M";

				System.out.print(output + "\t");
			}
			System.out.println("\n");
		}
	}
	
	
	public void changeTileState(int row, int column, State state){
		if(tiles[row][column]!=null){
			tiles[row][column].setState(state);
		}
			
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
	
	
	private void fillGrid(int rowCounter, int columnCounter){
		State state = null;
		for(int row=0;row<rowCounter;row++){
			for(int column=0;column<columnCounter;column++){
				if(tiles[row][column]==null)
					tiles[row][column] = new Clue(state.CLOSED,mineNeighborsCounter(row, column));
			}
		}
	}	
	
	
	private List<Tile> getNeighbors( int row, int column ) {
	    List<Tile> neighbors = new ArrayList<Tile>();
	    for( int r = -1; r <= 1; ++r ) {
	        for( int c = -1; c <= 1; ++c ) {
	            if( r == 0 && c == 0 ) 
	                continue;
	            if( r + row >= 0 && r + row < rowCounter && c + column >= 0 && c + column < columnCounter ) 
	            	if(tiles[r + row][c + column]!=null)
	                    neighbors.add(tiles[r + row][c + column]);
	        }
	    }
	    return neighbors;
	}
	
	public boolean isNeighborsMine(int row, int column){
		for(Tile tile : getNeighbors(row, column)){
			if(tile instanceof Mine)
				return true;
			else
				if(tile.getState().equals(State.CLOSED))
				tile.setState(State.OPEN);
		}
		return false;
	}
	
	private int mineNeighborsCounter(int row, int column){
		int counter = 0;
		for(Tile tile : getNeighbors(row, column)){
			if(tile instanceof Mine)
				counter+=1;
		}
		return counter;
	}
}
