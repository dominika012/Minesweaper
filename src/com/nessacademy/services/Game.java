package com.nessacademy.services;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nessacademy.entity.State;

public class Game {

	private Pattern pattern;
	private Matcher matcher;
	
	private static final String INPUT = "^[MAX][A-Z][0-9]$";
	
	MinesField minesField;
	
	public boolean validate(final String input){
		 pattern = Pattern.compile(INPUT);
		  matcher = pattern.matcher(input);
		  return matcher.matches();
	    	    
	  }
	
	private int getRowFromString(String input){
		
		return 0;
	}
	
	public void play(){
		inicializeField();
		while(true){
			selection();
		}
		
	}
	
	private void inicializeField(){
		Scanner in = new Scanner(System.in);
		System.out.println("Number of mines: ");
		int minesCounter = in.nextInt();
		System.out.println("Number of rows: ");
		int rowsCounter = in.nextInt();
		System.out.println("Number of columns: ");
		int columnsCounter = in.nextInt();
		
		minesField = new MinesField(minesCounter, rowsCounter, columnsCounter);
		minesField.setTiles();
		minesField.printMinesField();
	}
	
	private void selection(){
		System.out.println("Please eneter your selection: <X> EXIT, <MA1> MARK tile A1, <OA1> OPEN tile A1 ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(validate(input)==true){
			String selection = input.substring(0, 1);
			int row = Character.getNumericValue(input.charAt(1))-10;
			int column = Integer.valueOf(input.substring(2,3));
			if(selection.equals("O"))
				minesField.changeTileState(row, column, State.OPEN);
			else if(selection.equals("M"))
				minesField.changeTileState(row, column, State.MARKED);
			
			if(checkWin(row, column)==true){
				System.out.println("Goo job, continue");
				minesField.printMinesField();
			}
			else {
				System.out.println("You loose");
				minesField.printMinesField();
				System.exit(0);
			}
		}
		else if(input.equals("X"))
			System.exit(0);
	}
	
	private boolean checkWin(int selectedRow, int selectedColumn){
		if(minesField.isNeighborsMine(selectedRow, selectedColumn)==false)
			return true;
		return false;
	}
}
