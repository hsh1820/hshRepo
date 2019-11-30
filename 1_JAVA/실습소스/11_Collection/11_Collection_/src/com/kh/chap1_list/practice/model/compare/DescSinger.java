package com.kh.chap1_list.practice.model.compare;

import java.util.Comparator;

import com.kh.chap1_list.practice.model.vo.Music;

// 클릭하고 f2 번 = rename
public class DescSinger implements Comparator<Music>{
	// Music에 정의된 가수명 오름차순 이외의 
		// 정렬을 위하여 생성한 클래스
		// Comparator 사용
		
	@Override
	public int compare(Music o1, Music o2) {   
		//2개의 값중에 어느것이 큰지 작은지 비교
		// 기준 : 첫번째 매개변수가 기준이 됨
		// ==> o1을 기준으로 o1이 o2보다 큰지 작은지 비교
		
		// 가수명 내림차순 정렬만들기
		return -o1.getSinger().compareTo(o2.getSinger()); 
		// 가수명 오름차순을 -로 인해서 부호반전 가능 == 내림차순
		
	}
	
}
