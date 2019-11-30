package com.kh.chap1_poly.practice.controller;

import com.kh.chap1_poly.practice.model.vo.AniBook;
import com.kh.chap1_poly.practice.model.vo.Book;
import com.kh.chap1_poly.practice.model.vo.CookBook;
import com.kh.chap1_poly.practice.model.vo.Member;

public class LibraryController {
	private Member mem = new Member();
	private Book[] bList = new Book[5];
	
	
	{ // 초기화 블록
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	
	
	
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	public Member myInfo() {
		
		return mem;
		
	}
	
	public Book[] selectAll() {
		return bList;
		
	}
	
	public Book[] searchBook(String keyword) {
		
		Book[] searchList = new Book[5];
		
		int index = 0;
		for(int i =0;i<bList.length;i++) {
			
			if(bList[i].getTitle().contains(keyword)) {
				searchList[index++] = bList[i];
			}
		}
		return searchList; // searchList 크기가 5개라 일치값없으면 null뜸 어케함?
		
	}
	
	public int rentBook(int index)	{  // int result 값 반환
		//		public int rentBook(int index) {
			// int result = 0;
			// 전달 받은 index의 bList 객체가 만화책을 참조하고 있고
			// 해당 만화책의 제한 나이와 회원의 나이를 비교하여 회원 나이가 적을 경우
			// result를 1로 초기화  나이제한으로 대여 불가
			// 전달 받은 index의 bList 객체가 요리책을 참조하고 있고
			// 해당 요리책의 쿠폰유무가 “유”일 경우
			// 회원의 couponCount 1 증가 처리 후
			// result를 2로 초기화  성공적으로 대여 완료, 요리학원 쿠폰 발급
			// result 값 리턴
		int result = 0;
		
		if(bList[index] instanceof AniBook) { //bList 객체가 만화책 참조 하고있고,
			AniBook ani = (AniBook)bList[index];
			
			if(mem.getAge() > ani.getAccessAge()) {
				result = 1;
			}
					}
		if(bList[index] instanceof CookBook) {
			CookBook cook = (CookBook)bList[index];
			
			if(cook.isCoupon()) {
				int couponCount = 0;
				mem.setCouponCount(couponCount);
				System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
				result = 2;
			}else {
				System.out.println("성공적으로 대여되었습니다.");
				result = 2;
			}
			
		}
		
		return result;
	}
	
}
