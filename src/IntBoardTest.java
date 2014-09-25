import static org.junit.Assert.*;

import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class IntBoardTest {
	IntBoard board;
	
	@Before
	public void setUp(){
		board = new IntBoard();
	}
	
	@Test
	public void testAdj0(){
		BoardCell cell = board.getCell(0, 0);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(1,0)));
		Assert.assertTrue(testList.contains(board.getCell(0,1)));
		Assert.assertEquals(2,testList.size());
	}
	
	@Test
	public void testAdj1(){
		BoardCell cell = board.getCell(1, 1);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(1,0)));
		Assert.assertTrue(testList.contains(board.getCell(0,1)));
		Assert.assertTrue(testList.contains(board.getCell(2,1)));
		Assert.assertTrue(testList.contains(board.getCell(1,2)));
		Assert.assertEquals(4,testList.size());
	}
}
