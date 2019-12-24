package keybord.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypingEnglish {

	private List<Word> english;
	String en = System.lineSeparator();
	//	private String ent;
	//	private Word Q;

	//英単語リスト
	public TypingEnglish() {
		List<Word> Words = new ArrayList<Word>();

		//3
		Word eye = new Word("eye", "目", 3);
		//4
		Word grow = new Word("grow", "育つ", 4);
		//5
		Word house = new Word("house", "家", 5);
		Word today = new Word("today", "今日", 5);
		//6
		Word yellow = new Word("yellow", "黄色", 6);
		//7
		Word diamond = new Word("diamond", "ダイアモンド", 7);
		//8
		Word employer = new Word("employer", "雇用主", 8);
		Word internet = new Word("internet", "インターネット", 8);
		//9
		Word yesterday = new Word("yesterday", "昨日", 9);
		Word afternoon = new Word("afternoon", "午後", 9);
		Word telephone = new Word("telephone", "電話", 9);

		Collections.addAll(Words, eye, grow, house, today, yellow, diamond, employer, internet, yesterday,
				afternoon, telephone);

		Collections.shuffle(Words);

		english = new ArrayList<Word>(Words);

	}

	//問題を出題
	public Word pickEnglishword() {
		Word Q = english.get(0);
		//		english.remove(0);
		return Q;
	}

	//正誤判定(スペル)
	public String judgeSpell(String ent) {
		char[] t = ent.toCharArray();
		char[] A = english.get(0).getSpell().toCharArray();

		//		(ent.charAt(i) != english.get(0).getSpell().charAt(i))

		if (ent.equals(english.get(0).getSpell())) {
			System.out.println("正解！"+en);
			//			english.remove(0);
		} else if (ent.length() > english.get(0).getSpell().length()) {
			System.out.println("入力した文字数が超過しています。"+en);
		} else {
			for (int i = 0; i < ent.length(); i++) {
				if (t[i] != A[i]) {
					System.out.println((i + 1) + "番目の文字が違います。入力:"+t[i]+"→正解:"+A[i]);
				}
			}
			System.out.println("不正解！"+en);
			//			System.out.println(((english.get(0).getSpell()).compareTo(ent))+"文字目が違います");
			//			english.remove(0);
		}
		english.remove(0);
		return ent;
	}

	//正誤判定(意味)
	public String judgeSence(String ent) {
		char[] t = ent.toCharArray();
		char[] A = english.get(0).getSpell().toCharArray();

		if (ent.equals(english.get(0).getSpell())) {
			System.out.println("正解！"+en);
			//			english.remove(0);
		} else if ((ent.length() == english.get(0).getSpell().length()) && (ent != (english.get(0).getSpell()))) {
			for (int i = 0; i < ent.length(); i++) {
				if (t[i] != A[i]) {
					System.out.println((i + 1) + "番目の文字が違います。入力:"+t[i]+"→正解:"+A[i]);
				}
			}
			System.out.println("不正解！"+en);
		} else {
			System.out.println("入力した文字が違います。+en");
			//			System.out.println(((english.get(0).getSpell()).compareTo(ent))+1+"文字目が違います");
			//			english.remove(0);
		}
		english.remove(0);
		return ent;
	}

}