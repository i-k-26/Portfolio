package task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Register {

	private List<ItemInformation> ItemList = new ArrayList<ItemInformation>();;

	public void RegiSter() {
		loop1: while (true) {
			System.out.println("商品名を入力してください");
			Scanner sc = new Scanner(System.in);
			String itemname = sc.nextLine();

			System.out.println("値段を入力してください");
			int itemprice = sc.nextInt();

			ItemInformation item = new ItemInformation(itemname, itemprice);
			ItemList.add(item);

			System.out.println("次の商品を入力しますか？ はい:y　いいえ:n");
			String nextaction = sc.nextLine();

			while (true) {

				if (nextaction.equals("y")) {
					break;
				} else if (nextaction.equals("n")) {
					break loop1;
				} else {
					System.out.println("y か n を入力してください");
					String nextaction2 = sc.nextLine();
					nextaction = nextaction2;
				}
			}
		}
	}

	public int Payment() {
		int totalprice = 0;

		for (ItemInformation i : ItemList) {
			totalprice = totalprice + i.getItemprice();
		}

		ItemList.clear();
		return totalprice;
	}

	public int retryaction() {
		System.out.println("もう一度行いますか？ はい:y　いいえ:n");
		Scanner sc = new Scanner(System.in);
		String action = sc.nextLine();

		while (true) {

			if (action.equals("y")) {
				return 1;
			} else if (action.equals("n")) {
				return 2;
			} else {
				System.out.println("y か n を入力してください");
				String action2 = sc.nextLine();
				action = action2;
			}
		}
	}
}
