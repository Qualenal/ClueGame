import static org.junit.Assert.*;

import java.util.HashSet;
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
	//getAdjList tests
	@Test
	public void testAdj00(){
		BoardCell cell = board.getCell(0, 0);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(1,0)));
		Assert.assertTrue(testList.contains(board.getCell(0,1)));
		Assert.assertEquals(2,testList.size());
	}
	
	@Test
	public void testAdj11(){
		BoardCell cell = board.getCell(1, 1);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(1,0)));
		Assert.assertTrue(testList.contains(board.getCell(0,1)));
		Assert.assertTrue(testList.contains(board.getCell(2,1)));
		Assert.assertTrue(testList.contains(board.getCell(1,2)));
		Assert.assertEquals(4,testList.size());
	}
	
	@Test
	public void testAdj22(){
		BoardCell cell = board.getCell(2, 2);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(1,2)));
		Assert.assertTrue(testList.contains(board.getCell(2,1)));
		Assert.assertTrue(testList.contains(board.getCell(2,3)));
		Assert.assertTrue(testList.contains(board.getCell(3,2)));
		Assert.assertEquals(4,testList.size());
	}
	
	@Test
	public void testAdj03(){
		BoardCell cell = board.getCell(0, 3);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(0,2)));
		Assert.assertTrue(testList.contains(board.getCell(1,3)));
		Assert.assertEquals(2,testList.size());
	}
	@Test
	public void testAdj33(){
		BoardCell cell = board.getCell(3, 3);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(2,3)));
		Assert.assertTrue(testList.contains(board.getCell(3,2)));
		Assert.assertEquals(2,testList.size());
	}
	@Test
	public void testAdj30(){
		BoardCell cell = board.getCell(3, 0);
		LinkedList<BoardCell> testList = board.getAdjList();
		Assert.assertTrue(testList.contains(board.getCell(2,0)));
		Assert.assertTrue(testList.contains(board.getCell(3,1)));
		Assert.assertEquals(2,testList.size());
	}
	//getTargets tests
	@Test
	public void testTargets0(){
		BoardCell cell = board.getCell(0, 0);
		HashSet targets = board.getTargets(cell,1);
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
		Assert.assertEquals(2, targets.size());
	}
}
