package com.kh.chap3_map.part1.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap3_map.part1.model.vo.Snack;

public class Run {
	public static void main(String[] args) {
		// key는 String, value는 Snack으로 타입을 제한한 HashMap 객체 생성
		Map<String, Snack> map = new HashMap<String, Snack>();
		
		// 1. put(K key, V value) --> Map에 데이터를 추가하는 메소드
		map.put("오리온", new Snack("다이제",2500, 1105));
		map.put("해태제과", new Snack("맛동산",1500, 420));
		map.put("농심", new Snack("바나나킥",1500, 315));
		
		System.out.println(map);
		
		// 중복되는 키값의 데이터 추가
		map.put("오리온", new Snack("초코파이", 4000, 2052));
		
		System.out.println(map);
		// 키값이 중복되면 마지막에 추가된 Value로 덮어 씌움
		
		// 2. get(Object key)
		// --> Map에서 해당하는 key값의 value를 얻어오는 메소드
		System.out.println(map.get("농심"));
		// 키값으로 검색
		
		// 3. size()
		// --> Map에 저장되어있는 key의 개수를 반환
		System.out.println("Map에 저장된 데이터의 개수 : " + map.size());
		
		// 4. replace(K key, V value)  
		// --> Map에 저장된 데이터 중 key 값이 같은 Entry의 value를 수정
		// * Entry 란 ? key = value 한 쌍을 일컫는 말
		map.replace("오리온",new Snack("다이제",2500, 1105));
		System.out.println(map);
		
		// put() 같은 경우에는 key값이 중복되지 않으면 데이터가 추가되지만
		// replace()는 key 값이 중복되지 않으면 데이터를 추가하지 않고 
		// null값을 반환
		
		// 5. remove(K key)
		// --> 해당 key를 가지고 있는 Entry를 삭제
		map.remove("해태제과");
		System.out.println(map);
			
		
		// Map에 저장된 데이터를 하나 씩 반복 접근하기

		// Iterator 반복자 사용
		
		// 1. keySet() 활용
		// --> Map에 저장된 데이터 중 key 값들만 Set으로 추출
		Set<String> keySet = map.keySet();
		
		Iterator<String> it = keySet.iterator();
		// keySet이 참조하고 있는 Set의 값들을
		// Iterator를 이용하여 반복자에 담는 과정
		
		// 반복문을 이용하여 key와 value 출력하기
		while(it.hasNext()) {
			// 반복자를 이용하여 key 값을 알 수 있음.
			String key = it.next();  // it.next()의 키값을 담는 String 변수에 저장해놓고 String 변수를 재사용 
									 //	=> 메소드를 호출할때마다 해당 메소드가 동작하기 때문에 
			System.out.println("key : " + key);
			System.out.println("value : " + map.get(key));
		}

		// 2. keySet() + 향상된 for문
		System.out.println();
		for(String key : keySet) {
			System.out.println("key : " + key);
			System.out.println("value : " + map.get(key));
		}
		
		// 3. entrySet() 활용
		// Map인터페이스 안에 entry 내부 인터페이스 있음
		// --> 이벤트(내부 클래스)에 해당하는 동작을 구현할 때 사용.
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		
		// Iterator 반복 접근
		Iterator<Entry<String, Snack>> it2 = entrySet.iterator(); // Set과 동일한 타입제한
		System.out.println();
		while(it2.hasNext()){
			Entry<String, Snack> entry = it2.next(); // Entry<String, Snack> 형태
			System.out.println("key : " + entry.getKey());
			System.out.println("key : " + entry.getValue());
			
			
		}
		
	}
}
