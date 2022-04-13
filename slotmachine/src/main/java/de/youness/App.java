package de.youness;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
		System.out.print("Winline for A: ");
		int wins_a= scanner.nextInt();
		System.out.print("Winline for B: ");
		int wins_b= scanner.nextInt();
		System.out.print("Winline for C: ");
		int wins_c= scanner.nextInt();
		scanner.close();
		SlotMachine slotMachine = new SlotMachine(wins_a,wins_b,wins_c);
		slotMachine.calculateAmount();
		}catch(InputMismatchException ex) {
			System.out.println("This is not a number !");
		}
	}

}
