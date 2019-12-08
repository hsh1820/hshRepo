package model.vo;

public class Menu {
	private int mNo;
	private int menuCategory;
	private String menuTitle;
	private String menuContent;
	private int menuPrice;
	private int menuQuantity;
	private String cateTitle;
	
	public Menu() {
		
	}

	public Menu(String cateTitle, String menuTitle, int menuPrice, int menuQuantity) {
		this.cateTitle = cateTitle;
		this.menuTitle = menuTitle;
		this.menuPrice = menuPrice;
		this.menuQuantity = menuQuantity;
		
	}

	public Menu(int mNo, int menuCategory, String menuTitle, String menuContent, int menuPrice, int menuQuantity) {
		this.mNo = mNo;
		this.menuCategory = menuCategory;
		this.menuTitle = menuTitle;
		this.menuContent = menuContent;
		this.menuPrice = menuPrice;
		this.menuQuantity = menuQuantity;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(int menuCategory) {
		this.menuCategory = menuCategory;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuContent() {
		return menuContent;
	}

	public void setMenuContent(String menuContent) {
		this.menuContent = menuContent;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getMenuQuantity() {
		return menuQuantity;
	}

	public void setMenuQuantity(int menuQuantity) {
		this.menuQuantity = menuQuantity;
	}

	public String getCateTitle() {
		return cateTitle;
	}
	
	public void setCateTitle(String cateTitle) {
		this.cateTitle = cateTitle;
	}

	@Override
	public String toString() {
		return "Menu [mNo=" + mNo + ", menuCategory=" + menuCategory + ", menuTitle=" + menuTitle + ", menuContent="
				+ menuContent + ", menuPrice=" + menuPrice + ", menuQuantity=" + menuQuantity + "]";
	}

	
	
}
