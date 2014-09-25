import java.util.*;


public class IntBoard {
	public static int NUM_ROWS = 4;
	public static int NUM_COLS = 4;
	
	private BoardCell[][] board;
	private Set<BoardCell> targets;
	private Map<BoardCell,LinkedList<BoardCell>> adjList;
	//Constructor
	public IntBoard() {
		
	}
	// "Getters"
	public HashSet<BoardCell> getTargets(){
		return new HashSet<BoardCell>();
	}
	public LinkedList<BoardCell> getAdjList(){
		return new LinkedList<BoardCell>();
	}
	public BoardCell getCell(int row, int col){
		return board[row][col];
	}
	//Target-Finding Algorithm
	public void calcAdjacencies(){
		
	}
	public void calcTargets(){
		
	}
}
