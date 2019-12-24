package ngword.filter;

public class Main {

	public static void main(String[] args) {

		NgWordFilter ngfilter = new NgWordFilter();

//		ngfilter.createNgFilter();
//		ngfilter.getNgWord();

		ngfilter.registerNgWord("ape");
		String a = ngfilter.getNgWord();
		System.out.println(a);

		ngfilter.registerNgWord("dog");
		ngfilter.getNgWord();

		ngfilter.registerNgWord("cat");
		ngfilter.getNgWord();

		ngfilter.registerNgWord("mouse");
		ngfilter.getNgWord();


		if(ngfilter.containsNgWord("mikky=mouse")) {
			System.out.println("OK");
		}

		String b = ngfilter.replaceNgWord("mikky=mouse");
		if(("mikky=<censored>").equals(ngfilter.replaceNgWord("mikky=mouse"))){
			System.out.println(b);
		}

		if(("mikky=<censored>-mikky=<censored>").equals(ngfilter.replaceNgWord("mikky=mouse-mikky=mouse"))){
			System.out.println("OK");
		}
//		ngfilter.replaceNgWord("mikky=mouse-mikky=mouse");


		System.out.println();

	}

}
