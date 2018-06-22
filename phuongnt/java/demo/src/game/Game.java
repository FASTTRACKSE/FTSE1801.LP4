package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private CardKit cardKit;
	private ArrayList<Card> computer;
	private ArrayList<Card> player;

	public Game() {
		cardKit = new CardKit();
		computer = new ArrayList<Card>();
		player = new ArrayList<Card>();
	}

	public void randomCardKit() {
		cardKit.randomCardKit();
	}

	public void giveCard() {
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				computer.add(cardKit.getCardAtPositon(i));
			} else {
				player.add(cardKit.getCardAtPositon(i));
			}
		}
	}

	public int getScores(int scores) {
		return scores % 10;
	}

	public void displayGame() {
		System.out.println("Computer dang co bai nhu sau:");
		int scoresComputer = 0;
		for (Card card : computer) {
			System.out.println("\t" + card.inCard());
			scoresComputer += card.getNodeValue();
		}
		scoresComputer = getScores(scoresComputer);
		System.out.println("\t==>Tong diem la : " + scoresComputer);

		System.out.println("Player dang co bai nhu sau:");
		int scoresPlayer = 0;
		for (Card card : player) {
			System.out.println("\t" + card.inCard());
			scoresPlayer += card.getNodeValue();
		}
		scoresPlayer = getScores(scoresPlayer);
		System.out.println("\t==>Tong diem la : " + scoresPlayer);

		if (scoresComputer > scoresPlayer) {
			System.out.println("*** COMPUTER WIN ***");
		} else {
			if (scoresComputer < scoresPlayer) {
				System.out.println("*** PLAYER WIN ***");
			} else {
				System.out.println("*** DICKENS ***");
			}
		}
	}

	public void clearCardPlayer() {
		computer.clear();
		player.clear();
	}
	public static void main(String[] args) {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		int choose;
		do {
			game.randomCardKit();
			game.giveCard();
			game.displayGame();
			game.clearCardPlayer();
			System.out.println("1 - choi tiep ==== 2 - thoat game");
			choose = scanner.nextInt();
		} while (choose == 1);
		scanner.close();
	}
}
