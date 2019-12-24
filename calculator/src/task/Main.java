package task;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		NdigitsCalculator calc = new NdigitsCalculator();

		System.out.println("表示できる桁数を設定してください");
		Scanner sc = new Scanner(System.in);
		int digits = sc.nextInt();

		calc.setDigits(digits);

		System.out.println("計算する数を項を一つ入力してください");
		int a = sc.nextInt();

		System.out.println("計算する数をもう一つの項を入力してください");
		int b = sc.nextInt();

		calc.mult(a, b);

		System.out.println("計算結果を表示します");
		System.out.println(calc.printResult());

		calc.setDigits(1);
		System.out.println(calc.printResult()); // Overflow

	}

}
