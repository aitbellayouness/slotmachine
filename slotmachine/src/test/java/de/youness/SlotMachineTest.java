package de.youness;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SlotMachineTest {

	SlotMachine cut;
	Reel reel1;
	Reel reel2;
	Reel reel3;
	private int wins_a = 10;
	private int wins_b = 15;
	private int wins_c = 20;
	private static final int SIZE_OF_REEL3 = 21;
	private static final int SIZE_OF_REEL2 = 20;
	private static final int SIZE_OF_REEL1 = 22;

	@Before
	public void setUp() throws Exception {
		cut = new SlotMachine(wins_a, wins_b, wins_c);
		reel1 = new Reel(SIZE_OF_REEL1);
		reel2 = new Reel(SIZE_OF_REEL2);
		reel3 = new Reel(SIZE_OF_REEL3);
	}

	@Test
	public void testHorizonWinLine() {
		int position = 1;
		reel1.getOutChar()[position] = 'A';
		reel2.getOutChar()[position] = 'A';
		reel3.getOutChar()[position] = 'A';
		boolean result = cut.horizonWinLine(reel1, reel2, reel3, position);
		assertTrue(result);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testHorizonWinLineException() {
		int position = 21;
		reel1.getOutChar()[position] = 'A';
		reel2.getOutChar()[position] = 'A';
		reel3.getOutChar()[position] = 'A';
		boolean result = cut.horizonWinLine(reel1, reel2, reel3, position);
		assertTrue(result);
	}

	@Test
	public void testHorizonWinLineFalse() {
		int position = 1;
		reel1.getOutChar()[position] = 'A';
		reel2.getOutChar()[position] = 'B';
		reel3.getOutChar()[position] = 'A';
		boolean result = cut.horizonWinLine(reel1, reel2, reel3, position);
		assertFalse(result);
	}

	@Test
	public void testDiagonalWinLineTrue() {
		int position = 2;
		reel1.getOutChar()[position] = 'A';
		reel2.getOutChar()[position - 1] = 'A';
		reel3.getOutChar()[position - 2] = 'A';
		boolean result = cut.diagonalWinLine(reel1, reel2, reel3, position);
		assertTrue(result);
	}

	@Test
	public void testDiagonalWinLineFalse() {
		int position = 2;
		reel1.getOutChar()[position] = 'A';
		reel2.getOutChar()[position - 1] = 'A';
		reel3.getOutChar()[position - 2] = 'B';
		boolean result = cut.diagonalWinLine(reel1, reel2, reel3, position);
		assertFalse(result);
	}

	@Test
	public void testDiagonalWinLineDownTrue() {
		int position = 0;
		reel1.getOutChar()[position] = 'A';
		reel2.getOutChar()[position + 1] = 'A';
		reel3.getOutChar()[position + 2] = 'A';
		boolean result = cut.diagonalWinLineDown(reel1, reel2, reel3, position);
		assertTrue(result);
	}

	@Test
	public void testDiagonalWinLineDownFalse() {
		int position = 0;
		reel1.getOutChar()[position] = 'A';
		reel2.getOutChar()[position + 1] = 'A';
		reel3.getOutChar()[position + 2] = 'C';
		boolean result = cut.diagonalWinLineDown(reel1, reel2, reel3, position);
		assertFalse(result);
	}

}
