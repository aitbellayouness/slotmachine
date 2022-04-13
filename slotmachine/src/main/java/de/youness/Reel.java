package de.youness;


public class Reel {
	
	private int size;
	private char[] outChar;

	public Reel(int size) {
		this.size = size;
		this.outChar = new char[size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char[] getOutChar() {
		return outChar;
	}

	public void setOutChar(char[] outChar) {
		this.outChar = outChar;
	}

}
