package clueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import clueGame.RoomCell.DoorDirection;

public class Board {
	public static int MAX_ROWS = 50;
	public static int MAX_COLS = 50;
	private int numRows;
	private int numColumns;
	private BoardCell[][] board;
	Map<Character, String> rooms;
	Map<BoardCell,LinkedList<BoardCell>> adjList;

	public void loadBoardConfig(String mapFile) throws FileNotFoundException,
			BadConfigFormatException {
		board = new BoardCell[MAX_ROWS][MAX_COLS];
		FileReader reader = new FileReader(mapFile);
		Scanner fileIn = new Scanner(reader);
		// Set numCols and numRows initially to 0
		numRows = 0;
		numColumns = 0;

		// Read board configuration file line by line
		while (fileIn.hasNextLine()) {
			// Read the first line
			String newLine = fileIn.nextLine();
			// Split the row into string "cells"
			String[] parts = newLine.split(",");
			// Set the numCols initially, or check to make sure it's the same
			if (numColumns == 0)
				numColumns = parts.length;
			else if (parts.length != numColumns){
				fileIn.close();
				throw new BadConfigFormatException("Column length mismatch!");
			}
			// Loop through the parts array to initialize cells
			for (int i = 0; i < parts.length; i++) {
				// Check first to make sure the first letter is an initial
				if (!rooms.containsKey(parts[i].charAt(0))) {
					fileIn.close();
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
		fileIn.close();
	}
	//Adjacency and Target Finding
	public void calcAdjacencies(){
		adjList = new HashMap<BoardCell,LinkedList<BoardCell>>();
		//Calculate a list for each cell on the board
		for(int i = 0; i < numColumns; i++){
			for(int j = 0; j < numRows; j++){
				BoardCell currentCell = board[i][j];
				//Simple case, if cell is a doorway then only adj is direction of doorway
				if(currentCell.isDoorway()){
					//Convert BoardCell to RoomCell
					RoomCell currentRoomCell = (RoomCell) currentCell;
					//Create the LinkedList and add the appropriate direction
					LinkedList<BoardCell> currentAdjList = new LinkedList<BoardCell>();
					if(currentRoomCell.getDoorDirection() == DoorDirection.DOWN)
						currentAdjList.add(board[i+1][j]);
					if(currentRoomCell.getDoorDirection() == DoorDirection.RIGHT)
						currentAdjList.add(board[i][j+1]);
					if(currentRoomCell.getDoorDirection() == DoorDirection.LEFT)
						currentAdjList.add(board[i][j-1]);
					if(currentRoomCell.getDoorDirection() == DoorDirection.RIGHT)
						currentAdjList.add(board[i-1][j]);
					//Add the pair to the adjList map
					adjList.put(currentCell, currentAdjList);
				} else if(currentCell.isRoom()){
					//If it's a room and not a doorway, do nothing (for now)
				} else if(currentCell.isWalkway()){
					//Create the linked list and add all directions if they are allowed moves
					LinkedList<BoardCell> currentAdjList = new LinkedList<BoardCell>();
					
				}
			}
		}
	}
	public boolean isViableMove(BoardCell cell, DoorDirection allowedDoorDirection){
		//If the cell is out of bounds return false
		if(cell.getRow() < 0 || cell.getRow() >= numRows)
			return false;
		if(cell.getCol() < 0 || cell.getCol() >= numColumns)
			return false;
		//If cell is a room cell, check allowed direction
		if(cell.isRoom()){
			if(cell.isDoorway()){
				RoomCell aRoomCell = (RoomCell) cell;
			}
			//Not a doorway, return false
			
		}
		return true;
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
		return adjList.get(board[row][col]);
	}
	
	public LinkedList<BoardCell> getTargets(int row, int col, int dist){
		return new LinkedList<BoardCell>();
	}
	

	// Setters
	public void setRooms(Map<Character, String> rooms) {
		this.rooms = rooms;
	}

}
