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
			loadRoomConfig();
			board.loadBoardConfig(mapFile);
		} catch(Exception e){
			System.err.println(e.getLocalizedMessage());
			System.exit(0);
		}
	}
	public void loadRoomConfig() throws BadConfigFormatException, FileNotFoundException{
		FileReader reader = new FileReader(legendFile);
		Scanner fileIn = new Scanner(reader);
		// Parse Line by line
		while(fileIn.hasNextLine()){
			String newLine = fileIn.nextLine();
			String[] parts = newLine.split(",");
			// Should have 2 parts per line
			if(parts.length != 2)
				throw new BadConfigFormatException("Room config has too many arguments on one line!");
			// Make sure first part is a char
			if(parts[0].length() != 1){
				throw new BadConfigFormatException("Room initial is not 1 letter!");
			}
			// Remove spaces from parts[1]
			parts[1] = parts[1].trim();
			this.rooms.put(parts[0].charAt(0), parts[1]);
		}
		board.setRooms(rooms);
	}
}
