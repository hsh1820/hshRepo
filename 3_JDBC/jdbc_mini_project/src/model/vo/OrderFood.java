package model.vo;


public class OrderFood {
	private int quantity;
	private String menuName;
	private int price;
	
	public OrderFood() {
		// TODO Auto-generated constructor stub
	}

	public OrderFood(int quantity, String menuName, int price) {
		this.quantity = quantity;
		this.menuName = menuName;
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	



	@Override
	public String toString() {
		return "OrderFood [quantity=" + quantity + ", menuName=" + menuName + ", price=" + price
				;
	}


	
}
