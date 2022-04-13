package de.youness;

import java.util.Random;

public class SlotMachine {
	
	private static final int SIZE_OF_REEL3 = 21;
	private static final int SIZE_OF_REEL2 = 20;
	private static final int SIZE_OF_REEL1 = 22;

	private int wins_a;
	private int wins_b;
	private int wins_c;

	int winAmount = 0;
	Random random = new Random();
	String setOfCharacters = "ABC";

	int randomInt = random.nextInt(setOfCharacters.length());
	char randomChar = setOfCharacters.charAt(randomInt);

	Reel reel1 = new Reel(SIZE_OF_REEL1);
	Reel reel2 = new Reel(SIZE_OF_REEL2);
	Reel reel3 = new Reel(SIZE_OF_REEL3);

	public SlotMachine(int wins_a, int wins_b, int wins_c) {
		this.wins_a = wins_a;
		this.wins_b = wins_b;
		this.wins_c = wins_c;
	}

	public int calculateAmount() {
		collectRandomPositions(random, setOfCharacters, reel1);
		collectRandomPositions(random, setOfCharacters, reel2);
		collectRandomPositions(random, setOfCharacters, reel3);
		showMatrix(reel1, reel2, reel3);
		int size = reel2.getSize();
		for (int position = 0; position < size; position++) {

			if (horizonWinLine(reel1, reel2, reel3, position) || diagonalWinLineDown(reel1, reel2, reel3, position)
					|| diagonalWinLine(reel1, reel2, reel3, position)) {
				switch (reel1.getOutChar()[position]) {
				case 'A':
					winAmount += wins_a;
					break;
				case 'B':
					winAmount += wins_b;
					break;
				case 'C':
					winAmount += wins_c;
					break;

				default:
					break;
				}
			}

		}
		System.out.println("winAmount: " + winAmount + " cents");
		return winAmount;
	}

	public boolean diagonalWinLine(Reel reel1, Reel reel2, Reel reel3, int position) {
		boolean isWinLine = position > 1 && reel1.getOutChar()[position] == reel2.getOutChar()[position - 1]
				&& reel1.getOutChar()[position] == reel3.getOutChar()[position - 2];
		if (isWinLine)
			System.out.println("Position " + position + " Diagonal WinLine Up: " + reel1.getOutChar()[position]);
		return isWinLine;
	}

	public boolean diagonalWinLineDown(Reel reel1, Reel reel2, Reel reel3, int position) {
		boolean isWinLine = position < 19 && reel1.getOutChar()[position] == reel2.getOutChar()[position + 1]
				&& reel1.getOutChar()[position] == reel3.getOutChar()[position + 2];
		if (isWinLine)
			System.out.println("Position " + position + " Diagonal WinLine Down: " + reel1.getOutChar()[position]);
		return isWinLine;
	}

	public boolean horizonWinLine(Reel reel1, Reel reel2, Reel reel3, int position) {
		boolean isWinLine = reel1.getOutChar()[position] == reel2.getOutChar()[position]
				&& reel2.getOutChar()[position] == reel3.getOutChar()[position];
		if (isWinLine)
			System.out.println("Position " + position + " Horizontal WinLine: " + reel1.getOutChar()[position]);
		return isWinLine;
	}

	public void showMatrix(Reel reel1, Reel reel2, Reel reel3) {
		System.out.println("" + "\t" + "Reel1" + "\t" + "Reel2\t" + "Reel3");
		System.out.println("-----" + "\t" + "-----\t" + "-----" + "-----");
		for (int position = 0; position < SIZE_OF_REEL1; position++) {
			if (position < SIZE_OF_REEL2) {
				System.out.println(
						position + "\t" + reel1.getOutChar()[position] + "\t" + reel2.getOutChar()[position] + "\t" + reel3.getOutChar()[position]);
			}
			if (position == SIZE_OF_REEL2) {
				System.out.println(position + "\t" + reel1.getOutChar()[position] + "\t" + "" + "\t" + reel3.getOutChar()[position]);
			}
			if (position > SIZE_OF_REEL2) {
				System.out.println(position + "\t" + reel1.getOutChar()[position] + "\t" + "" + "\t" + "");
			}
		}
	}

	public void collectRandomPositions(Random random, String setOfCharacters, Reel reel) {
		int size = reel.getSize();
		for (int position = 0; position < size; position++) {
			reel.getOutChar()[position] = setOfCharacters.charAt(random.nextInt(setOfCharacters.length()));

		}
	}
}
