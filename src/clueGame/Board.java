package clueGame;

import java.util.LinkedList;
import java.util.Map;

public class Board {
	public static int MAX_ROWS = 50;
	public static int MAX_COLS = 50;
	private BoardCell[][] board;
	Map<Character,String> rooms;
	private int numRooms;
	private int numRows;
	private int numColumns;
	
	public void loadBoardConfig(String mapFile) throws BadConfigFormatException{
		board = new BoardCell[MAX_ROWS][MAX_COLS];
		
	}
	// Getters
	public int getNumRows(){
		return numRows;
	}
	
	public int getNumColumns(){
		return numColumns;
	}
	
	public Map<Character, String> getRooms(){
		return rooms;
	}
	
	public BoardCell getCellAt(int row, int col){
		return board[row][col];
	}
	
	public RoomCell getRoomCellAt(int row, int col){
		return (RoomCell) board[row][col];
	}
	public LinkedList<BoardCell> getAdjList(int row, int col){
		return new LinkedList<BoardCell>();
	}
	// Setters
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}
	public void setRooms(Map<Character, String> rooms) {
		this.rooms = rooms;
	}
	
}
