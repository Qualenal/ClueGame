package clueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Board {
	public static int MAX_ROWS = 50;
	public static int MAX_COLS = 50;
	private BoardCell[][] board;
	Map<Character, String> rooms;
	private int numRows;
	private int numColumns;

	public void loadBoardConfig(String mapFile) throws FileNotFoundException,
			BadConfigFormatException {
		board = new BoardCell[MAX_ROWS][MAX_COLS];
		FileReader reader = new FileReader(mapFile);
		Scanner fileIn = new Scanner(reader);
		// Set numCols and numRows initially to 0
		numRows = 0;
		numColumns = 0;

		// Read board config file line by line
		while (fileIn.hasNextLine()) {
			// Read the first line
			String newLine = fileIn.nextLine();
			// Split the row into string "cells"
			String[] parts = newLine.split(",");
			// Set the numCols initially, or check to make sure it's the same
			if (numColumns == 0)
				numColumns = parts.length;
			else if (parts.length != numColumns)
				throw new BadConfigFormatException("Column length mismatch!");
			// Loop through the parts array to initialize cells
			for (int i = 0; i < parts.length; i++) {
				// Check first to make sure the first letter is an initial
				if (!rooms.containsKey(parts[i].charAt(0))) {
					throw new BadConfigFormatException("Bad room initial");
				}
				if (parts[i] == "W")
					board[numRows][i] = new WalkwayCell(numRows, i);
				else
					board[numRows][i] = new RoomCell(numRows, i, parts[i]);
			}
			// Update rows
			numRows++;
		}
	}

	// Getters
	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public Map<Character, String> getRooms() {
		return rooms;
	}

	public BoardCell getCellAt(int row, int col) {
		return board[row][col];
	}

	public RoomCell getRoomCellAt(int row, int col) {
		return (RoomCell) board[row][col];
	}

	public LinkedList<BoardCell> getAdjList(int row, int col) {
		return new LinkedList<BoardCell>();
	}
	
	public LinkedList<BoardCell> getTargets(int row, int col, int dist){
		return new LinkedList<BoardCell>();
	}
	

	// Setters
	public void setRooms(Map<Character, String> rooms) {
		this.rooms = rooms;
	}

}
