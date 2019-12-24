package task;

public class Main {

	public static void main(String[] args) {

		Register regi = new Register();
		regi.RegiSter();

		System.out.println("total:"+(regi.Payment())+"yen");

		while(true) {

			if(regi.retryaction() == 1) {
				regi.RegiSter();
				System.out.println("total:"+(regi.Payment())+"yen");
			}else {
				break;
			}
		}
	}

}
