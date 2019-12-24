package keybord.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypingJapanese {

	private List<Word> japanese;
	String en = System.lineSeparator();

	//漢字リスト
	public TypingJapanese() {
		List<Word> Words = new ArrayList<Word>();

		//あ
		Word issyu = new Word("一蹴", "いっしゅう");
		//か
		Word kencho = new Word("顕著", "けんちょ");
		//さ
		Word zindai = new Word("甚大", "じんだい");
		Word sekkei = new Word("雪渓", "せっけい");
		//た
		Word dekiai = new Word("溺愛", "できあい");
		//な
		Word naraku = new Word("奈落", "ならく");
		//は
		Word himen = new Word("罷免", "ひめん");
		//ま
		Word musaboru = new Word("貪る", "むさぼる");
		//や
		Word yaocho = new Word("八百長", "やおちょう");
		//ら
		Word rakuno = new Word("酪農", "らくのう");
		Word rotei = new Word("露呈", "ろてい");
		//わ
		Word wairo = new Word("賄賂", "わいろ");

		Collections.addAll(Words, issyu, kencho, zindai, sekkei, dekiai, naraku, himen, musaboru, yaocho, rakuno,
				rotei, wairo);

		Collections.shuffle(Words);

		japanese = new ArrayList<Word>(Words);
	}

	public Word	 pickJapaneseword() {
		Word Q = japanese.get(0);
		return Q;
	}

	//正誤判定(読み)
	public String judgeYomi(String ent) {
		char[] t = ent.toCharArray();
		char[] A = japanese.get(0).getSpell().toCharArray();

		if (ent.equals(japanese.get(0).getYomi())) {
			//				japanese.remove(0);
			System.out.println("正解！"+en);
			//				return ent;
		} else if ((ent.length() == japanese.get(0).getSpell().length()) && (ent != (japanese.get(0).getSpell()))) {
			for (int i = 0; i < ent.length(); i++) {
				if (t[i] != A[i]) {
					System.out.println((i + 1) + "番目の文字が違います。");
				}
			}
			System.out.println("不正解！"+en);
		} else {
			System.out.println("入力した文字が違います。"+en);
			//				japanese.remove(0);
			//				System.out.println("不正解！");
			//				return ent;
		}
		japanese.remove(0);
		return ent;
	}
}
