package ngword.filter;

public class NgWordFilter {

	private String NGword;
	//	private List<String> NGwords;
	//	private List<String> NGwords = new ArrayList<String>();

	//	public void createNgFilter() {
	//		List<String> NGwords = new ArrayList<String>();
	//		this.NGwords = NGwords;
	//	}

	/**
	NGワードを登録する。登録済みの場合は新しいNGワードに入れ替える
	**/
	public void registerNgWord(String ngWord) {

		//		List<String> NGwords = new ArrayList<String>();

		if (NGword != null) {
			NGword = ngWord;
		} else {
			this.NGword = ngWord;
		}

		//		if (NGwords.isEmpty()) {
		//			NGwords.add(ngWord);
		//		}
		//
		//		if (NGwords.size() > 0) {
		//			for (int i = 0; i < NGwords.size(); i++) {
		//				if (NGwords.get(i).equals(ngWord)) {
		//					NGwords.remove(ngWord);
		//					NGwords.add(ngWord);
		//				}
		//			}
		//			NGwords.add(ngWord);
		//		}
		//		NGwords = NGwords.stream().distinct().collect(Collectors.toList());
	}

	/**
	現在登録済みのNGワードを取得する
	*/
	public String getNgWord() {
		//		String s = null;
		//		for (int i = 0; i < NGwords.size(); i++) {
		//			s = NGwords.get(i);
		//			System.out.println(NGwords);
		//			System.out.println(s);
		//		}
		//		return s;

//		System.out.println(NGword);
		return NGword;
	}

	/**
	与えられた文字列にNGワードが含まれているかどうか判定する。含まれて入ればTrueを返す
	*/
	public boolean containsNgWord(String input) {
		if (input.contains(NGword)) {
//			System.out.println("NGワードが含まれています");
			return true;
		}
		return false;
	}

	/**
	与えられた文字列にNGワードが含まれていたら、
	"<censored>"という文字列に入れ替えた文字列を返す。
	*/
	public String replaceNgWord(String input) {
//		String in = input;
		if (input.contains(NGword)) {
//			System.out.println(in.replace(NGword, "<censored>"));
			return input.replace(NGword, "<censored>");
		}
		return input;

	}

}
