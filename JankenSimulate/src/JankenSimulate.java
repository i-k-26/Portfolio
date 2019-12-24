
public class JankenSimulate {

	public static void main(String[] args) {

		int battle = 3;
		// 最大対戦回数

		int wincount1 = 0;
		int wincount2 = 0;
		// 勝ち点

		int set = 0;
		// 対戦回数

		System.out.println("プレイヤー1とプレイヤー2で「じゃんけん」を開始します。勝負は3回戦です。");

		for (int i = 1; i <= battle; i++) {

			int player1 = new java.util.Random().nextInt(3);
			int player2 = new java.util.Random().nextInt(3);

			switch (player1) {

			case 0:
				System.out.println("プレイヤー1は「グー」を出す");
				break;

			case 1:
				System.out.println("プレイヤー1は「チョキ」を出す");
				break;

			case 2:
				System.out.println("プレイヤー1は「パー」を出す");
				break;

			}

			switch (player2) {

			case 0:
				System.out.println("プレイヤー2は「グー」を出す");
				break;

			case 1:
				System.out.println("プレイヤー2は「チョキ」を出す");
				break;

			case 2:
				System.out.println("プレイヤー2は「パー」を出す");
				break;

			}

			if (player1 == 0 && player2 == 1) {
				wincount1 = wincount1 + 1;
				System.out.println("プレイヤー1の勝ち。勝ち点:プレイヤー1=" + wincount1 + "、プレイヤー2=" + wincount2);

			} else if (player1 == 1 && player2 == 2) {
				wincount1 = wincount1 + 1;
				System.out.println("プレイヤー1の勝ち。勝ち点:プレイヤー1=" + wincount1 + "、プレイヤー2=" + wincount2);

			} else if (player1 == 2 && player2 == 0) {
				wincount1 = wincount1 + 1;
				System.out.println("プレイヤー1の勝ち。勝ち点:プレイヤー1=" + wincount1 + "、プレイヤー2=" + wincount2);

			} else if (player1 == player2) {
				System.out.println("引き分け。勝ち点に変化はありません。勝ち点:プレイヤー1=" + wincount1 + "、プレイヤー2=" + wincount2);

			} else {
				wincount2 = wincount2 + 1;
				System.out.println("プレイヤー2の勝ち。勝ち点:プレイヤー1=" + wincount1 + "、プレイヤー2=" + wincount2);

			}

			set = set + 1;
			System.out.println("現在の対戦回数は" + set + "回目です。");

		}

		if (wincount1 > wincount2) {
			System.out.println("今回のじゃんけん3回勝負は「プレイヤー1の勝ち」です。");
		} else if (wincount1 < wincount2) {
			System.out.println("今回のじゃんけん3回勝負は「プレイヤー2の勝ち」です。");
		} else {
			System.out.println("今回のじゃんけん3回勝負は引き分けです。");
		}

	}

}
