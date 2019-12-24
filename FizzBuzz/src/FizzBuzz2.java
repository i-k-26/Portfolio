
public class FizzBuzz2 {

	public static void main(String[] args) {

		int number = 100;

		for (int i = 1; i <= number; i++) {

			//			System.out.println(i);

			if ((i % 5 == 0 || Integer.toString(i).contains("5")) && (i % 3 == 0 || Integer.toString(i).contains("3"))) {
				System.out.println("FizzBuzz");
			} else if (i % 5 == 0 || Integer.toString(i).contains("5")) {
				System.out.println("Buzz");
			} else if (i % 3 == 0 || Integer.toString(i).contains("3")) {
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}

		}

	}

}

