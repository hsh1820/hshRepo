package com.kh.chap2_Set.part1.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.kh.chap_set.part1.model.vo.Student;

public class Run {
	public static void main(String[] args) {
		// Set --> 순서 유지가 X, 중복 저장  X
		// --> index로 접근 불가 (일반 for문 사용 불가)
		
		Set<String> testSet			 = new HashSet<>();
		// 문자열만 넣을수 있는 주머니 만들기
		
		
		
		testSet.add(new String("점심 30분 전"));
		testSet.add(new String("뭐드시러 가세요?"));
		testSet.add(new String("지금 너무 배고파요"));
		testSet.add(new String("소고기 먹고싶다."));
		
		System.out.println(testSet);
		// 순서 유지 X 확인
		
		testSet.add(new String("점심 30분 전"));
		System.out.println(testSet);
		// 같은 문구 2번 안나옴 == 중복 제거 확인 
		// String은 이미 hashCode(), equals()가 오버라이딩이 되어 있음
		// -> HashSet 저장 시 중복이 제거됨
		
		
		
		
//		Set<Student> hs = new HashSet<>();
		Set<Student> hs = new LinkedHashSet<Student>();
		// 순서가 유지되는 HashSet
		
		hs.add(new Student("서진웅", 27, 100));
		hs.add(new Student("윤희빈", 27, 80));
		hs.add(new Student("문영준", 30, 60));
		hs.add(new Student("서진웅", 27, 100));
		
		System.out.println(hs);
		// 1) 오버라이딩전 --> 중복 제거가 이루어 지지 않음

		// 2) equals() 오버라이딩 후 --> 중복 제거가 되지 않음
		//	why?  HashSet은 먼저 hashCode() 값이 같은지 부터 판별을 하기 때문에
		//		 equals() 결과가 true여도 hashCode()가 값이 다르면
		//		  서로 다른 객체로 인식한다.
		
		
		// Set에 저장된 객체를 하나씩 접근하는 방법
		
		// 1. Set -> List에 담아 준 후 접근하기
		List<Student> list = new ArrayList<Student>(hs); 
		
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("===============================================");
		// 2. 반복자 Iterator 사용하여 접근 => 컬렉션에서 공통적으로 사용할 수 있는 방법
		Iterator<Student> it = hs.iterator();//iterator = 반복자
		// hs.iterator()를 통해 반복할수 있는 객체로 변환후 it로 참조
		while(it.hasNext()) { 
			// Iterator에서 현재 가리키고 있는 위치 다음 부분에 -->순서 : 주소 -> 인덱스 ->... 
			// 값이 있을 경우 true
			// 없으면 false
			
			System.out.println(it.next()); // 다음칸 값을 가져와라			
			
		}// 다음칸 없으면 반복문 종료
		
		
		// 3. 향상된 for문 ==> java, javascript(for-each)에서 사용가능, 배열에서도 사용가능
		// for(참조형 : 배열 또는 Collection)
		// --> 참조형이 배열 또는 Collection의 요소를
		// 	하나씩 순차적으로 참조하는 형태의 반복문
		
		System.out.println("===============================================");
		for( Student s : hs) // hs : set
			// for 문 돌때마다 s가 hs를 하나씩 참조
			{
				System.out.println(s);
			}
			
		
		
		
		
		
	}
}
