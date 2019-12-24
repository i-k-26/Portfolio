package task;

public class NdigitsCalculator {

	private int digits;
//	private int a;
//	private int b;
	private String result;

	public void setDigits(int digits) {
		this.digits = digits;
	}

	public void mult(int a, int b) {
//		this.a = a;
//		this.b = b;
		result = Integer.toString(a * b);
	}

	public String printResult() {
		if (result.length() > digits) {
			result = "Overflow";
		}
		return result;
	}

}
