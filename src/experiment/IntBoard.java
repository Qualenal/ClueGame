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
		board = new BoardCell[NUM_ROWS][NUM_COLS];
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
		return adjList.get(cell);
	}
	public BoardCell getCell(int row, int col){
		return board[row][col];
	}
	
	//Target-Finding Algorithm
	public void calcAdjacencies(){
		adjList = new HashMap<BoardCell,LinkedList<BoardCell>>();
		for(int i = 0; i < NUM_ROWS; i++){
			for(int j = 0; j < NUM_COLS; j++){
				//Add the current cell to the Map and add the LinkedList
				adjList.put(board[i][j], new LinkedList<BoardCell>());
				//Four possible cases for each cell
				if(i-1 > -1)
					adjList.get(board[i][j]).add(board[i-1][j]);
				if(j-1 > -1)
					adjList.get(board[i][j]).add(board[i][j-1]);
				if(i+1 < NUM_ROWS)
					adjList.get(board[i][j]).add(board[i+1][j]);
				if(j+1 < NUM_COLS)
					adjList.get(board[i][j]).add(board[i][j+1]);
			}
		}
	}
	public void calcTargets(BoardCell initialCell, int moves){
		
	}
}
