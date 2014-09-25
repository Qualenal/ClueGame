package experiment;
import java.util.*;


public class IntBoard {
	public static int NUM_ROWS = 4;
	public static int NUM_COLS = 4;
	
	private BoardCell[][] board;
	private Set<BoardCell> targets;
	private Map<BoardCell,LinkedList<BoardCell>> adjList;
	
	//Constructor
	public IntBoard() {
		for(int i = 0; i < NUM_ROWS; i++){
			for(int j = 0; j < NUM_COLS; j++){
				board[i][j] = new BoardCell(i,j);
			}
		}
	}
	
	// "Getters"
	public HashSet<BoardCell> getTargets(BoardCell initialCell, int moves){
		return new HashSet<BoardCell>();
	}
	public LinkedList<BoardCell> getAdjList(BoardCell cell){
		return new LinkedList<BoardCell>();
	}
	public BoardCell getCell(int row, int col){
		return board[row][col];
	}
	
	//Target-Finding Algorithm
	public void calcAdjacencies(){
		adjList = new HashMap<BoardCell,LinkedList<BoardCell>>();
		for(int i = 0; i < NUM_ROWS; i++){
			for(int j = 0; j < NUM_COLS; j++){
				
			}
		}
	}
	public void calcTargets(BoardCell initialCell, int moves){
		
	}
}
