package clueTests;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clueGame.*;

public class PathTests {
	Board board;

	@Before
	public void setUp() {
		ClueGame game = new ClueGame("ClueLayoutStudents.csv", "roomConfig.txt");
		game.loadConfigFiles();
		board = game.getBoard();
	}
	
	//This test is designated as a light blue
	@Test
	public void walkwayTest() {
		LinkedList<BoardCell> adj = board.getAdjList(10, 19);
		for (int i = 0; i < adj.size(); i++) {
			Assert.assertTrue(adj.get(i).isWalkway());
		}
	}
	
	//These tests are designated as purple
	@Test
	public void edgeTests(){
		//Tests a square at each of the 4 walls
		LinkedList<BoardCell> adj = board.getAdjList(0, 8);
		for (int i = 0; i < adj.size(); i++) {
			Assert.assertTrue(adj.get(i).isRoom());
		}
		
		adj = board.getAdjList(8, 22);
		Assert.assertTrue(adj.contains(board.getCellAt(8,21)));
		
		adj = board.getAdjList(6, 0);
		Assert.assertTrue(adj.contains(board.getCellAt(7, 0)));
		Assert.assertTrue(adj.contains(board.getCellAt(5, 0)));
		Assert.assertTrue(adj.contains(board.getCellAt(6, 1)));

		adj = board.getAdjList(21,6);
		Assert.assertTrue(adj.contains(board.getCellAt(21,5)));
		Assert.assertTrue(adj.contains(board.getCellAt(20,6)));
	}
	
	//These tests are designated as light red and test for being near a room without a door
	@Test
	public void nearRoomTests(){
		LinkedList<BoardCell> adj = board.getAdjList(8, 8);
		Assert.assertTrue(adj.contains(board.getCellAt(8, 7)));
		Assert.assertTrue(adj.contains(board.getCellAt(7, 8)));
		Assert.assertTrue(adj.contains(board.getCellAt(8, 9)));
		Assert.assertFalse(adj.contains(board.getCellAt(9, 8)));

		adj = board.getAdjList(15, 8);
		Assert.assertTrue(adj.contains(board.getCellAt(15, 7)));
		Assert.assertTrue(adj.contains(board.getCellAt(16, 8)));
		Assert.assertTrue(adj.contains(board.getCellAt(15, 9)));
		Assert.assertFalse(adj.contains(board.getCellAt(14, 8)));
	}
	
	//These tests are designated as white and are testing for door direction
	@Test
	public void nearDoorwayTests(){
		LinkedList<BoardCell> adj = board.getAdjList(2, 5);
		Assert.assertTrue(adj.contains(board.getCellAt(2, 6)));
		Assert.assertTrue(adj.contains(board.getCellAt(1, 5)));
		Assert.assertTrue(adj.contains(board.getCellAt(2, 4)));
		Assert.assertTrue(adj.contains(board.getCellAt(3, 5)));
		
		adj = board.getAdjList(7, 20);
		Assert.assertTrue(adj.contains(board.getCellAt(7, 19)));
		Assert.assertTrue(adj.contains(board.getCellAt(6, 20)));
		Assert.assertTrue(adj.contains(board.getCellAt(8, 20)));
		Assert.assertFalse(adj.contains(board.getCellAt(7, 21)));

		adj = board.getAdjList(11, 6);
		Assert.assertTrue(adj.contains(board.getCellAt(11, 7)));
		Assert.assertTrue(adj.contains(board.getCellAt(10, 6)));
		Assert.assertTrue(adj.contains(board.getCellAt(11, 5)));
		Assert.assertTrue(adj.contains(board.getCellAt(12, 6)));
		
		adj = board.getAdjList(21, 22);
		Assert.assertTrue(adj.contains(board.getCellAt(21, 20)));
		Assert.assertTrue(adj.contains(board.getCellAt(20, 22)));
	}
	
	//These tests are designated by gray
	public void DoorwayTests(){
		LinkedList<BoardCell> adj = board.getAdjList(5, 7);
		Assert.assertTrue(adj.contains(board.getCellAt(5, 6)));
		Assert.assertTrue(adj.contains(board.getCellAt(5, 8)));
		Assert.assertTrue(adj.contains(board.getCellAt(4, 7)));
		Assert.assertTrue(adj.contains(board.getCellAt(6, 7)));
		
		adj = board.getAdjList(5, 11);
		Assert.assertTrue(adj.contains(board.getCellAt(5, 12)));
		Assert.assertTrue(adj.contains(board.getCellAt(5, 10)));
		Assert.assertTrue(adj.contains(board.getCellAt(4, 11)));
		Assert.assertTrue(adj.contains(board.getCellAt(6, 11)));
	}
	
	
	
	
	
	

}
