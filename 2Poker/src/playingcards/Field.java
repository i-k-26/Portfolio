package playingcards;

public class Field {

	public void run() {

		//デッキを準備
		Deck shuffledDeck = new Deck();

		//参加プレイヤーを定義
		Hand player = new Hand();
		Hand dealer = new Hand();

		//各プレイヤーに手札を配る
		player.addcard(shuffledDeck.draw());
		dealer.addcard(shuffledDeck.draw());
		player.addcard(shuffledDeck.draw());
		dealer.addcard(shuffledDeck.draw());

		//各プレイヤーの手札を公開して役を判定する
		System.out.println("自分の手札");
		System.out.println(player.gethand().get(0).getsuit());
		System.out.println(player.gethand().get(0).getrank());
		System.out.println(player.gethand().get(1).getsuit());
		System.out.println(player.gethand().get(1).getrank());
		int playerHand = player.judge();
		printHand(playerHand);

		System.out.println("相手の手札");
		System.out.println(dealer.gethand().get(0).getsuit());
		System.out.println(dealer.gethand().get(0).getrank());
		System.out.println(dealer.gethand().get(1).getsuit());
		System.out.println(dealer.gethand().get(1).getrank());
		int dealerHand = dealer.judge();
		printHand(dealerHand);

		//勝敗の判定をする
		if (playerHand > dealerHand) {
			System.out.println("あなたの勝ち");
		} else if (playerHand == dealerHand) {
			System.out.println("引き分け");
		} else {
			System.out.println("NPCの勝ち");
		}
	}

	public static void printHand(int hand) {
		switch(hand){
		case 4:
			System.out.println("フラッシュ");
			break;
		case 3:
			System.out.println("ストレート");
			break;
		case 2:
			System.out.println("ペア");
			break;
		case 1:
			System.out.println("ハイカード");
			break;
		}
	}


		//	List<Card> player = new ArrayList<Card>();

		//	deck = Deck.Deck();

		//	Shuffle ShuffledDeck = new Shuffle();
		//	(deck.getdeck().get(0));

		//	List<Card> player = new ArrayList<Card>();
		//	List<Card> dealer = new ArrayList<Card>();
		//
		//
		//	player.add(shuffledDeck.oneDraw());
		//	player.add(shuffledDeck.oneDraw());
		//
		//	dealer.add(shuffledDeck.oneDraw());
		//	dealer.add(shuffledDeck.oneDraw());

		//	Hand playerJudge = new Hand(player.get(0), player.get(1),dealer.get(0),dealer.get(1));

		//	hand.addHand();
		//	hand.addHand();
		//
		//	System.out.println("自分の手札");
		//
		//	System.out.println(player.get(0).getsuit());
		//	System.out.println(player.get(0).getrank());
		//
		//	System.out.println(player.get(1).getsuit());
		//	System.out.println(player.get(1).getrank());
		//
		//	hand.playerjudge();
		//
		//	System.out.println("相手の手札");
		//
		//	System.out.println(dealer.get(0).getsuit());
		//	System.out.println(dealer.get(0).getrank());
		//
		//	System.out.println(dealer.get(1).getsuit());
		//	System.out.println(dealer.get(1).getrank());
		//
		//	hand.dealerjudge();
		//
		//	hand.handReset();

		//	System.out.println(ShuffledDeck.residue());
		//	player.add(ShuffledDeck.oneDraw());
		//	System.out.println(ShuffledDeck.residue());

	}
