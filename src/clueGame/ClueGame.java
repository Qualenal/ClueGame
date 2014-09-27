package clueGame;

import java.util.Map;

public class ClueGame {
	private Map<Character,String> rooms;
	Board board = new Board();
	
	public ClueGame(String Map, String Legend){
		
	}
	public void loadConfigFiles(){
	}
	
	public Board getBoard(){
		return board;
	}
}
