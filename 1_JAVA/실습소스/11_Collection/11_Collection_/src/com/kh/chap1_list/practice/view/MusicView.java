package com.kh.chap1_list.practice.view;

import java.util.Scanner;

import com.kh.chap1_list.practice.controller.MusicController;
import com.kh.chap1_list.practice.model.vo.Music;

public  class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public  void mainMenu() {
		int sel = 0;
		
		do {
			System.out.println(
					"******* 메인 메뉴 *******\n" + 
					"1. 마지막 위치에 곡 추가 \n" + 
					"2. 첫 위치에 곡 추가 \n" + 
					"3. 전체 곡 목록 출력 \n" + 
					"4. 특정 곡 검색 \n" + 
					"5. 특정 곡 삭제 \n" + 
					"6. 특정 곡 정보 수정 \n" + 
					"7. 곡명 오름차순 정렬 \n" + 
					"8. 가수명 내림차순 정렬\n" + 
					"9. 종료"  );
			System.out.print("메뉴 번호 선택 : ");
			sel = sc.nextInt();
			
			
			switch(sel) {
			case 1 : addList(); break;				
			case 2 : addAtZero(); break;				
			case 3 : printAll(); break;				
			case 4 : searchMusic();break;				
			case 5 : removeMusic();break;				
			case 6 : setMusic();break;				
			case 7 : ascTitle(); break;				
			case 8 : descSinger();break;				
			case 9 : System.out.println("프로그램 종료");break;				
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");				
			}
			
		}while(sel !=9);
		
	}
	public void addList() {
		//1. 마지막 위치에 곡 추가
		sc.nextLine();
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();		
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		
		boolean result = mc.addList(new Music(title, singer));
		if(result = true) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
		
	}
	public void addAtZero() { 
		//add(index, e element) 
		sc.nextLine();
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		int result = mc.addAtZero(new Music(title, singer));
		
		if(result==1){
			System.out.println("추가 성공");
		}else if (result==2){
			System.out.println("추가 실패");
		}
		
		
		// contains(Object o) return t/f 
		
		
	}
	public void printAll() {
		sc.nextLine();
		System.out.println("****** 전체 곡 목록 출력 ******");
			
		mc.printAll();
		
		
	}
	public void searchMusic() {
		sc.nextLine();
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		Music mc2 = mc.searchMusic(title) ;
		if( mc2 == null ) {
			System.out.println(title + "이라는 곡이 없습니다.");
		}else {			
			System.out.println(mc2);
		}
			
		
		
	}
	public void removeMusic() {
		sc.nextLine();
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		

			if (  mc.removeMusic(title) != null) {			
				System.out.println("을(를) 삭제했습니다.");			
			}
			System.out.println(title+"이란 곡이 없습니다.");
		}
	
	public void setMusic() {
		sc.nextLine();
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String search = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String edit = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String singer = sc.nextLine();
		
		
		
		System.out.println( mc.setMusic(search, new Music(edit, singer))+ " 가 값이 변경되었습니다.");
	}
	// 오름차순
	public void ascTitle() {
		int result = mc.ascTitle();
		if(result == 1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
		
	}
	
	//내림 차순
	public void descSinger() {
		// 리스트 가수 명 내림차순 정렬, 1 리턴
		if(mc.descSinger() == 1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
	}
}
