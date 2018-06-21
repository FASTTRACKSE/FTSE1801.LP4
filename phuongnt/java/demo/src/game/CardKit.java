package game;

import java.util.ArrayList;
import java.util.Random;

public class CardKit {

	private static final String[] TYPE_CARD = new String[] { "Co", "Ro", "Chuon", "Bich" };
	private static final int[] NODE_VALUE_CARD = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
	private static final String[] NODE_DISPLAY_CARD = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"J", "Q", "K" };

	private ArrayList<Card> listCard;

	public CardKit() {
		listCard = new ArrayList<>();
		Card card = null;
		for (int i = 0; i < NODE_DISPLAY_CARD.length; i++) {
			for (int j = 0; j < TYPE_CARD.length; j++) {
				card = new Card();
				card.setType(TYPE_CARD[j]);
				card.setNodeDipslay(NODE_DISPLAY_CARD[i]);
				card.setNodeValue(NODE_VALUE_CARD[i]);
				listCard.add(card);
			}
		}
	}

	public void displayCardKit() {
		for (Card card : listCard) {
			System.out.println(card.inCard());
		}
	}

	public void randomCardKit() {
		Random rand = new Random();
		int position = 0;
		Card card = null;
		for (int i = 0; i < 2000; i++) {
			position = rand.nextInt(52);
			card = listCard.get(0);
			listCard.set(0, listCard.get(position));
			listCard.set(position, card);
		}
	}

	public Card getCardAtPositon(int position) {
		return listCard.get(position);
	}
}
