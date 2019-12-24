package playingcards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> hand;
	//	private int point;

	//手札を準備
	public Hand() {
		hand = new ArrayList<Card>();
	}

	//カードを追加
	public void addcard(Card card) {
		hand.add(card);
	}

	public List<Card> gethand() {
		return this.hand;
	}

	//役の判定
	public int judge() {
		if ((hand.get(0).getsuit()).equals((hand.get(1).getsuit()))) {
//			System.out.println("フラッシュ");
			return 4;
		} else if ((Math.abs(hand.get(0).getnumber() - hand.get(1).getnumber()) == 1) ||
				(Math.abs(hand.get(0).getnumber() - hand.get(1).getnumber()) == 12)) {
//			System.out.println("ストレート");
			return 3;
		} else if ((hand.get(0).getrank()).equals((hand.get(1).getrank()))) {
//			System.out.println("ペア");
			return 2;
		} else {
//			System.out.println("ハイカード");
			return 1;
		}

	}

	//	private Card card1;
	//	private Card card2;
	//	private String playerjudge;
	//	private String suit;
	//	private String rank;
	//	private int number;

	//	private List<Card> playerhand = new ArrayList<Card>();
	//	private List<Card> dealerhand = new ArrayList<Card>();
	//	Deck shuffledDeck = new Deck();

	//	public Hand(Card card1, Card card2, Card card3, Card card4) {
	//		this.card1 = card1;
	//		this.card2 = card2;
	//		this.card3 = card3;
	//		this.card4 = card4;
	//	}

	//	public Card set() {
	//		return this.playerhand;
	//	}

	//	public void addHand(){
	//		Card c1 = shuffledDeck.oneDraw();
	//		playerhand.add(c1);
	//		dealerhand.add(c1);
	//	}

	//	public boolean addCard() {
	//		return playerhand.add(shuffledDeck.oneDraw());
	//
	//	}

	//	public void playerjudge() {
	//		if ((playerhand.get(0).getsuit()).equals((playerhand.get(1).getsuit()))) {
	//			System.out.println("フラッシュ");
	//			return this.playerjudge;
	//		} else if ((playerhand.get(0).getrank()).equals((playerhand.get(1).getrank()))) {
	//			System.out.println("ペア");
	//			return this.playerjudge;
	//		} else if ((playerhand.get(0).getnumber() +1 == playerhand.get(1).getnumber()) ||
	//				(playerhand.get(0).getnumber() -1 == playerhand.get(1).getnumber())){
	//				System.out.println("ストレート");
	//				return this.playerjudge;
	//		} else {
	//			System.out.println("ハイカード");
	//			return playerjudge;
	//		}
	//	}
	//
	//	public void dealerjudge() {
	//		if ((dealerhand.get(0).getsuit()).equals((dealerhand.get(1).getsuit()))){
	//			System.out.println("フラッシュ");
	//			return this.playerjudge;
	//		} else if ((dealerhand.get(0).getrank()).equals((dealerhand.get(1).getrank()))){
	//			System.out.println("ペア");
	//			return this.playerjudge;
	//		} else if ((dealerhand.get(0).getnumber() +1 == dealerhand.get(1).getnumber()) ||
	//				(dealerhand.get(0).getnumber() -1 == dealerhand.get(1).getnumber())){
	//				System.out.println("ストレート");
	//				return this.playerjudge;
	//		} else {
	//			System.out.println("ハイカード");
	//			return playerjudge;
	//		}
	//	}
	//
	//	public void handReset() {
	//		playerhand.removeAll(playerhand);
	//		dealerhand.removeAll(dealerhand);
	//	}
	//

}
