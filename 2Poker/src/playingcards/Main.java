package playingcards;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		while(true) {

			System.out.println("2cardポーカーを開始します。　Yes:y or No:n");

			@SuppressWarnings("resource")
			Scanner poker = new Scanner(System.in);
			String ent = poker.nextLine();

			if(ent.equals("y")) {
				Field GameStart = new Field();
				GameStart.run();
				break;
			}else if(ent.equals("n")){
				break;
			}else {
				System.out.println("y か n を入力してください。");
			}
		}
	}
}

//		String ent = null;
//
//		while(true) {
//			System.out.println("2cardポーカーを開始します。　Yes:y or No:n");
//
//			if("n".equals(ent)) {
//				break;
//			} else if("y".equals(ent)) {
//				Field GameStart = new Field();
//				GameStart.run();
//			} else {
//				System.out.println("入力内容が不適切です。y か n を入力してください。");
//			}
//		}
//	}
//}