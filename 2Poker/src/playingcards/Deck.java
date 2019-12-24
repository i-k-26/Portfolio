package playingcards;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Deck {

	private Deque<Card> deck = null;

	public Deck() {
		List<Card> tmpInitValues = new ArrayList<Card>();

		Card Spade1 = new Card("♠", "A", 1);
		Card Spade2 = new Card("♠", "2", 2);
		Card Spade3 = new Card("♠", "3", 3);
		Card Spade4 = new Card("♠", "4", 4);
		Card Spade5 = new Card("♠", "5", 5);
		Card Spade6 = new Card("♠", "6", 6);
		Card Spade7 = new Card("♠", "7", 7);
		Card Spade8 = new Card("♠", "8", 8);
		Card Spade9 = new Card("♠", "9", 9);
		Card Spade10 = new Card("♠", "10", 10);
		Card Spade11 = new Card("♠", "J", 11);
		Card Spade12 = new Card("♠", "Q", 12);
		Card Spade13 = new Card("♠", "K", 13);

		Card Heart1 = new Card("♥", "A", 1);
		Card Heart2 = new Card("♥", "2", 2);
		Card Heart3 = new Card("♥", "3", 3);
		Card Heart4 = new Card("♥", "4", 4);
		Card Heart5 = new Card("♥", "5", 5);
		Card Heart6 = new Card("♥", "6", 6);
		Card Heart7 = new Card("♥", "7", 7);
		Card Heart8 = new Card("♥", "8", 8);
		Card Heart9 = new Card("♥", "9", 9);
		Card Heart10 = new Card("♥", "10", 10);
		Card Heart11 = new Card("♥", "J", 11);
		Card Heart12 = new Card("♥", "Q", 12);
		Card Heart13 = new Card("♥", "K", 13);

		Card Diamond1 = new Card("♦", "A", 1);
		Card Diamond2 = new Card("♦", "2", 2);
		Card Diamond3 = new Card("♦", "3", 3);
		Card Diamond4 = new Card("♦", "4", 4);
		Card Diamond5 = new Card("♦", "5", 5);
		Card Diamond6 = new Card("♦", "6", 6);
		Card Diamond7 = new Card("♦", "7", 7);
		Card Diamond8 = new Card("♦", "8", 8);
		Card Diamond9 = new Card("♦", "9", 9);
		Card Diamond10 = new Card("♦", "10", 10);
		Card Diamond11 = new Card("♦", "J", 11);
		Card Diamond12 = new Card("♦", "Q", 12);
		Card Diamond13 = new Card("♦", "K", 13);

		Card Club1 = new Card("♣", "A", 1);
		Card Club2 = new Card("♣", "2", 2);
		Card Club3 = new Card("♣", "3", 3);
		Card Club4 = new Card("♣", "4", 4);
		Card Club5 = new Card("♣", "5", 5);
		Card Club6 = new Card("♣", "6", 6);
		Card Club7 = new Card("♣", "7", 7);
		Card Club8 = new Card("♣", "8", 8);
		Card Club9 = new Card("♣", "9", 9);
		Card Club10 = new Card("♣", "10", 10);
		Card Club11 = new Card("♣", "J", 11);
		Card Club12 = new Card("♣", "Q", 12);
		Card Club13 = new Card("♣", "K", 13);

		Collections.addAll(tmpInitValues,
				Spade1, Spade2, Spade3, Spade4, Spade5, Spade6, Spade7, Spade8,Spade9, Spade10,
				Spade11, Spade12, Spade13,
				Heart1, Heart2, Heart3, Heart4, Heart5, Heart6,Heart7, Heart8, Heart9, Heart10,
				Heart11, Heart12, Heart13,
				Diamond1, Diamond2, Diamond3,Diamond4, Diamond5, Diamond6, Diamond7, Diamond8,
				Diamond9, Diamond10, Diamond11, Diamond12,Diamond13,
				Club1, Club2, Club3, Club4, Club5, Club6,  Club7, Club8, Club9, Club10,
				Club11, Club12, Club13);

		Collections.shuffle(tmpInitValues);

		deck = new ArrayDeque<Card>(tmpInitValues);
	}

	public Card draw() {
		return deck.pop();
	}

	public Deque<Card> getdeck() {
		return this.deck;
	}

	public int residue() {
		return deck.size();
	}

}