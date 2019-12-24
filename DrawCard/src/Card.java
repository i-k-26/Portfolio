import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

	public static void main(String[] args) {

		int card = 52;
		List<Integer> deck = new ArrayList<>();
		int rank = 0;

		for (int i = 1; i <= card; i++) {
			deck.add(i);
		}

		Collections.shuffle(deck);


		if (1 <= deck.get(0) && deck.get(0) <= 13) {
			System.out.println("Spade");
		} else if (14 <= deck.get(0) && deck.get(0) <= 26) {
			System.out.println("Heart");
		} else if (27 <= deck.get(0) && deck.get(0) <= 39) {
			System.out.println("Dia");
		} else if (40 <= deck.get(0) && deck.get(0) <= 52) {
			System.out.println("Culb");
		}


		if (1 <= deck.get(0) && deck.get(0) <= 13) {
			rank = deck.get(0);
		} else if (14 <= deck.get(0) && deck.get(0) <= 26) {
			rank = deck.get(0)-13;
		} else if (27 <= deck.get(0) && deck.get(0) <= 39) {
			rank = deck.get(0)-26;
		} else if (40 <= deck.get(0) && deck.get(0) <= 52) {
			rank = deck.get(0)-39;
		}

		if (rank == 1) {
			System.out.println("A");
		}else if(rank == 11){
			System.out.println("J");
		}else if(rank == 12) {
			System.out.println("Q");
		}else if(rank == 13){
			System.out.println("K");
		}else {
			System.out.println(rank);
		}

		deck.remove(0);

	}

}