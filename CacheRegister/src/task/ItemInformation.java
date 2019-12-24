package task;

public class ItemInformation {

	private String itemname;
	private int itemprice;


	public ItemInformation(String itemname,int itemprice) {
		this.itemname = itemname;
		this.itemprice = itemprice;
	}


	public String getItemname() {
		return itemname;
	}


	public int getItemprice() {
		return itemprice;
	}

}
