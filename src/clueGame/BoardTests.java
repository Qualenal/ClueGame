package clueGame;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import clueGame.*;
import clueGame.RoomCell.DoorDirection;

public class BoardTests {
	Board board;
	int NUM_ROOMS;
	
	@Before
	public void setUp(){
		ClueGame game = new ClueGame("ClueLayout.csv", "ClueLegend.txt");
		game.loadConfigFiles();
		board = game.getBoard();
		NUM_ROOMS = 9;
	}
	
	@Test
	public void checkRooms(){
		Map<Character, String> rooms = board.getRooms();
		Assert.assertEquals(NUM_ROOMS, rooms.size());
		Assert.assertEquals("Dungeon", rooms.get('D'));
		Assert.assertEquals("Bedroom", rooms.get('B'));
		Assert.assertEquals("Workshop", rooms.get('R'));
		Assert.assertEquals("Library", rooms.get('L'));
		Assert.assertEquals("Walkway", rooms.get('W'));
		Assert.assertEquals("Bathroom", rooms.get('P'));
		Assert.assertEquals("Theater", rooms.get('T'));
		Assert.assertEquals("Study", rooms.get('S'));
		Assert.assertEquals("Kitchen", rooms.get('K'));
		Assert.assertEquals("Dining Room", rooms.get('E'));
		Assert.assertEquals("Closet", rooms.get('X'));
	}
	
	
	@Test
	public void checkDimensions(){
		Assert.assertEquals(board.getRows(), 20);
		Assert.assertEquals(board.getColumns(), 21);
	}
	
	@Test
	public void doorCheck(){
		Assert.assertTrue(board.getCell(2,4).isDoorway());
		Assert.assertTrue(board.getCell(10,4).isDoorway());
		Assert.assertTrue(board.getCell(17,3).isDoorway());
		Assert.assertTrue(board.getCell(5,9).isDoorway());
		Assert.assertFalse(board.getCell(6,6).isDoorway());
		Assert.assertEquals(board.getRoomCell(2, 4).getDir(), DoorDirection.RIGHT);
		Assert.assertEquals(board.getRoomCell(10, 4).getDir(), DoorDirection.RIGHT);
		Assert.assertEquals(board.getRoomCell(17, 3).getDir(), DoorDirection.UP);
		Assert.assertEquals(board.getRoomCell(5, 9).getDir(), DoorDirection.RIGHT);
	}
	
	@Test
	public void numDoorCheck(){
		int numDoors = 0;
		for(int i = 0; i < board.getRows(); i++){
			for(int j = 0; j < board.getColumns(); j++){
				if(board.getCell(i, j).isDoorway())
					numDoors++;
			}}
		Assert.assertEquals(numDoors, 16);
	}
	
	@Test (expected = BadConfigFormatException.class)
	public void checkLayoutExceptions(){
		ClueGame badGame = new ClueGame("BadLayout.csv", "ClueLegend.txt");
	}
	
	@Test (expected = BadConfigFormatException.class)
	public void checkLegendExceptions(){
		ClueGame badGame = new ClueGame("ClueLayout.csv", "BadLegend.txt");
	}
}
