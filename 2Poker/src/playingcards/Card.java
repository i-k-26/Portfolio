package playingcards;

public class Card {

	private String suit;
	private String rank;
	private int number;

	public Card(String suit, String rank, int number) {

		this.suit = suit;
		this.rank = rank;
		this.number = number;

	}

	public String getsuit() {
		return this.suit;
	}

	public String getrank() {
		return this.rank;
	}

	public int getnumber() {
		return this.number;
	}
}