package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.service.MenuService;
import model.vo.Menu;
import model.vo.OrderFood;
import view.MenuView;

public class MenuController {

	private MenuView view = new MenuView();
	private MenuService nService = new MenuService();
	private static List<OrderFood> oList = new ArrayList<OrderFood>();
	
	public void selectMenu(int sel) {
		Map<Integer,Menu> menu = null;
		int chooseFoodNo = 0;

		try {
   			menu = nService.selectSubMenu(sel);
			
			if(!menu.isEmpty()) {
				chooseFoodNo = view.displaySubMenu(menu,menu.get(1).getCateTitle()); 
				
				if(chooseFoodNo > 0 && chooseFoodNo < (menu.size()+1)) { 
 					updateMenu(menu.get(chooseFoodNo).getMenuTitle());
					System.out.println(menu.get(chooseFoodNo).getMenuTitle());
					OrderFood order = new OrderFood(1,
							menu.get(chooseFoodNo).getMenuTitle(), 
							menu.get(chooseFoodNo).getMenuPrice());
					
					oList.add(order);

					view.mainMenu();
					
				}else {
					System.out.println("다시 입력해 주세요. ");
					selectMenu(sel);
				}
					
			}else {
				view.displayFail("서브메뉴 조회 결과가 없습니다.");
			}
			
		}catch(Exception e) {
			view.displayError("서브메뉴 조회중 에러 발생", e);
		
		}
		
	}
	
	public void updateMenu(String chooseFood) {
		int result = 0;
		try {
			result = nService.updateSubMenu(chooseFood );
			if(result > 0) {
				view.displaySuccess("상품 주문이 완료 되었습니다.");
			}else {
				view.displaySuccess("매진 되었습니다.");
			}
		}catch(Exception e) {
			view.displayError("상품 수량 변경중 예외발생", e);
		}
		
	}

	public void orderList() {
		view.displayreceipt(oList);
	}

	
}