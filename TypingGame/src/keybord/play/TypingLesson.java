package keybord.play;

import java.util.Scanner;

public class TypingLesson {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		String en = System.lineSeparator();

		System.out.println();

		while (true) {

			System.out.println("メニューを選択してください。" + en + "　英単語:1" + en + "　漢字:2");
			//			+ en + "　単語の追加:3"

			Scanner sc1 = new Scanner(System.in);
			String choice = sc1.nextLine();

			switch (Integer.valueOf(choice)) {
			case 1:
				System.out.println("コースを選択してください。" + en + "　タイピング:1" + en + "　逆引きクイズ:2");

				//				Scanner sc2 = new Scanner(System.in);
				String course = sc1.nextLine();

				if (course.equals("1")) {
					while (true) {

						TypingEnglish E = new TypingEnglish();

						System.out.println(E.pickEnglishword().getSpell());
						System.out.println("※endを入力で終了します。");

						//					Scanner sc3 = new Scanner(System.in);
						String typing = sc1.nextLine();

						if (typing.equals("end")) {
							break;
						} else {
							E.judgeSpell(typing);
						}
					}
					//					if(typing1.equals(E.englishPick().getSpell())){
					//						System.out.println("正解！");
					//					}else {
					//						System.out.println("不正解！");
					//					}
				} else if (course.equals("2")) {
					while (true) {

						TypingEnglish E = new TypingEnglish();

						System.out.println(E.pickEnglishword().getSense());
						System.out.println("※endを入力で終了します。");

						//					Scanner sc4 = new Scanner(System.in);
						String typing = sc1.nextLine();

						if (typing.equals("end")) {
							break;
						} else {
							E.judgeSence(typing);
						}
					}
				} else {
					System.out.println("1 か 2 を入力してください。");
				}
				break;
			case 2:
				while (true) {
					TypingJapanese J = new TypingJapanese();

					System.out.println("読みをひらがなで入力してください。");
					System.out.println(J.pickJapaneseword().getSpell());
					System.out.println("※endを入力で終了します。");

					//				Scanner sc3 = new Scanner(System.in);
					String typing = sc1.nextLine();

					if (typing.equals("end")) {
						break;
					} else {
						J.judgeYomi(typing);
					}
				}
				break;

			//			case 3:
			//				System.out.println("追加する単語を入力してください。次に意味または読みを入力します。");
			//				Scanner sc3 = new Scanner(System.in);
			//				String typing1 = sc3.nextLine();
			//
			//				System.out.println("意味または読みを入力してください。");
			//
			//				Scanner sc4 = new Scanner(System.in);
			//				String typing2 = sc4.nextLine();
			//
			//				System.out.println("文字数を入力してください。");
			//				Scanner sc5 = new Scanner(System.in);
			//				String typing3 = sc5.nextLine();
			//				Integer.parseInt(typing3);
			//
			//				TypingEnglish E = new TypingEnglish();
			//				Word  = new Word(typing1,typing2,typing3);
			//
			default:
				System.out.println("入力内容が違います。");
			}

		}
	}
}
