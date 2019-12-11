package com.kh.chap1_list.part2.run;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import com.kh.chap1_list.part2.model.vo.Food;

public class Run {
	public static void main(String[] args) {
		
		// Food 만을 저장할 수 있는 List 객체 생성
		
		List<Food> list = new ArrayList<Food>()	; //각각 만들었을때는 서로 호환 불가
//		// List 자식들 == 실체화
//		ArrayList<Food> aList = new ArrayList<Food>();
//		LinkedList<Food> lList = new LinkedList<Food>();
//		
//		list = lList;
//		list = aList;
		
		// 1. add(E e) : 리스트의 끝에 인스턴스 데이터를 추가하는 메소드
		list.add(new Food("갈비찜", 15000));
		list.add(new Food("쌀국수", 9000));
		list.add(new Food("냉면", 13000));
		
		System.out.println(list);
		
		//2. add(int index, E e)
		// 인덱스를 지정하여 해당 인덱스에 인스턴스를 추가하는 메소드
		list.add(1, new Food("라면", 3000));
		
		System.out.println(list);
	
		// 3. set(int index, E e)
		// 해당 인덱스의 값을 새로운 인스턴스로 변경
		list.set(0, new Food("갈비찜",12000));
		System.out.println(list);
		
		// 4. size() : 리스트 내에 있는 객체의 개수 반환
		System.out.println("size() : "+list.size());
		
		// 5. get(int index)
		// 해당 인덱스에 저장된 인스턴스 반환
		System.out.println(list.get(2));
		
		// 6. remove(int index);
		// 해당 인덱스에 저장된 인스턴스 제거 후
		// 빈 공백을 뒤에서 당겨와서 매꿈
		list.remove(3);
		System.out.println(list);
		
		// 7. sublist(int index1, int index2);
		// 리스트의 index1 ~ index2 사이를 추출하여 
		// 별도의 리스트 생성
		List<Food> sub = list.subList(0, 2);
		System.out.println(sub);
		System.out.println(list);
		
		// 8. clear() : 리스트 내 내용 전부 삭제
		list.clear();
		System.out.println(list);
		
		
		// 9. isEmpty() : 리스트가 비어있는지 확인
		System.out.println(list.isEmpty());
		
		// 10. 
		
		
	}
	
}
