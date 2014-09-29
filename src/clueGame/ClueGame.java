package clueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ClueGame {
	private Map<Character,String> rooms;
	private Board board;
	private String mapFile;
	private String legendFile;
	public ClueGame(String map, String legend){
		this.board = new Board();
		this.rooms = new HashMap<Character,String>();
		this.mapFile = map;
		this.legendFile = legend;
	}

	public Board getBoard(){
		return board;
	}

	public void loadConfigFiles(){
		try{
			board.loadBoardConfig(mapFile);
			loadRoomConfig();
		} catch(BadConfigFormatException e){
			System.err.println(e.getMessage());
		}
		System.out.println(rooms.size());
	}
	public void loadRoomConfig() throws BadConfigFormatException{
		FileReader reader = null;
		Scanner fileIn = null;
		try{
			reader = new FileReader(legendFile);
			fileIn = new Scanner(reader);
		} catch(FileNotFoundException e){
			System.err.println(e.getLocalizedMessage());
		}
		// Parse Line by line
		while(fileIn.hasNextLine()){
			String newLine = fileIn.nextLine();
			String[] parts = newLine.split(",");
			// Should have 2 parts per line
			if(parts.length != 2)
				throw new BadConfigFormatException();
			// Make sure first part is a char
			if(parts[0].length() != 1){
				throw new BadConfigFormatException();
			}
			// Remove spaces from parts[1]
			parts[1] = parts[1].trim();
			this.rooms.put(parts[0].charAt(0), parts[1]);
		}
		board.setNumRooms(rooms.size());
		board.setRooms(rooms);
	}
}
