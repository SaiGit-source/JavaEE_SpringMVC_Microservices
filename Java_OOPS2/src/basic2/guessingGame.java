package basic2;

import java.util.Scanner;

class Guessor {
	int guessorNum;
	
	int guessingNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Guessor: enter the guess in range 0-10: ");
		guessorNum = scan.nextInt();
		while (guessorNum<0 || guessorNum>10) {
			System.out.print("Guessor: enter the guess in range 0-10: ");
			guessorNum = scan.nextInt();
		}
		// guessorNum = scan.nextInt();
		return guessorNum;
	}
}

class Player {
	int playerNum;
	
	int guessingNumber(String player) {
	Scanner scan = new Scanner(System.in);
	System.out.printf("%s: enter the guess between 0 to 10: ", player);
	playerNum = scan.nextInt();
	while (playerNum<0 || playerNum>10) {
		System.out.printf("%s: enter the guess between 0 to 10: ", player);
		playerNum = scan.nextInt();
	}
	// playerNum = scan.nextInt();
	return playerNum;
	}
}

class Umpire {
	int numFromGuessor;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	
	void collectFromGuessor() {
		Guessor guessor = new Guessor();
		numFromGuessor = guessor.guessingNumber();
	}
	
	void collectFromPlayers() {
		Player player1 = new Player();
		numFromPlayer1 = player1.guessingNumber("Player1");
		Player player2 = new Player();
		numFromPlayer2 = player2.guessingNumber("Player2");
		Player player3 = new Player();
		numFromPlayer3 = player3.guessingNumber("Player3");
	}
	
	void decision() {
		if (numFromPlayer1==numFromGuessor) {
			if (numFromPlayer2==numFromGuessor && numFromPlayer3==numFromGuessor) {
				System.out.println("Player1, 2, 3 won and guessed correctly");
			}
			else if (numFromPlayer2==numFromGuessor) {
				System.out.println("Player1, 2 won and guessed correctly");
			}
			else if (numFromPlayer3==numFromGuessor) {
				System.out.println("Player1, 3 won and guessed correctly");
			}
			else {
				System.out.println("Player1 won and guessed correctly");
			}
		}
		
		else if (numFromPlayer2==numFromGuessor) {
			if (numFromPlayer3==numFromGuessor) {
				System.out.println("Player 2 and 3 won");
			}
			else {
				System.out.println("Player 2 won");
			}
		}
		else if (numFromPlayer3==numFromGuessor) {
			System.out.println("Player 3 won");
		}
		else {
			System.out.println("None won all lost");
		}
		
	}
}

public class guessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Umpire umpire = new Umpire();
		umpire.collectFromGuessor();
		umpire.collectFromPlayers();
		umpire.decision();
	}

}
