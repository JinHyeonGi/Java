package Vo;

public class OrderVo {
	
	private String menu_Name;
	private int Count;
	private int Price;

	public OrderVo(String menu_Name, int Count, int Price) {
		this.menu_Name = menu_Name;
		this.Count = Count;
		this.Price = Price;
	}

	public String getMenu_Name() {
		return menu_Name;
	}

	public void setMenu_Name(String menu_Name) {
		this.menu_Name = menu_Name;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "OrderVo [menu_Name=" + menu_Name + ", Count=" + Count + ", Price=" + Price + "]";
	}

}