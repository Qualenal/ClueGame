package clueGame;

import java.util.Map;

public class Board {
	private BoardCell[][] board;
	Map<Character,String> rooms;
	private int numRooms;
	private int numRows;
	private int numColumns;
	
	public void loadBoardConfig(){
		
	}
	
	public int getRows(){
		return numRows;
	}
	
	public int getColumns(){
		return numColumns;
	}
	
	public Map<Character, String> getRooms(){
		return rooms;
	}
	
	public BoardCell getCell(int row, int col){
		return board[row][col];
	}
	
	public RoomCell getRoomCell(int row, int col){
		return (RoomCell) board[row][col];
	}
}
