package com.kh.chap3_map.practice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kh.chap3_map.practice.model.vo.Member;

public class MemberController {
	private Map<String, Member> map  = new HashMap<String, Member>();
	
	
	
	
	public boolean joinMembership(String id, Member m) {// id , m.name, m.pw

			if(map.containsKey(id)){
				// map의 key값중 전달받은 id가 포함되어 있다면 
				return false;
			}else {
				// 전달받은 id가 포함되어 있지 않다면
				map.put(id, m);
				return true;	
			}
		
	}
	
	public String logIn(String id, String password) {
		 // 이름, 비밀번호 필요
		if(map.containsKey(id)) {
			if(map.get(id).getPassword().equals(password)) {
				String name = map.get(id).getName();
				return name;
			}
		} return null;
		
		}
	public boolean changePassword(String id, String oldPw,String newPw) {
		// id, oldpw, newpw
		// 아이디가 존재하면서 저장된 비밀번호와 사용자가 입력한 비밀번호(oldPw)가
		// 같을 때 새로운 비밀번호로 바꾸고 true 반환, 아니라면 false 반환
		if(map.get(id)!=null) {
			if(map.get(id).getPassword().equals(oldPw)) {
				map.get(id).setPassword(newPw);
				return true;
			}
		}
		return false;
	}
	public void changeName(String id,String newName) {
		//전달 받은 id를 통해 Member의 이름을 새로 입력한 이름으로 변경
		map.get(id).setName(newName);
		
	}			// id , member(name, password)
	public  Map<String, String> sameName(String name){//id	
		//			
		// 전달 받은 name이 저장된 데이터의 이름과 같으면
		// HashMap 객체에 해당 id와 이름 저장 후 객체 반환
		// 단, 엘리먼트 하나씩 뽑아내는 과정에서 keySet()을 쓸 것
		Map<String, String> resultMap = new HashMap<String, String>();

		Set<String> keySet = map.keySet();//키 집합
		
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			// 반복자를 이용하여 key 값을 알 수 있음.
			String id = it.next();  // it.next()의 키값을 담는 String 변수에 저장해놓고 String 변수를 재사용 
			//	=> 메소드를 호출할때마다 해당 메소드가 동작하기 때문에 
			if(map.get(id).getName().equals(name)) {
				resultMap.put(id, name);
				
			}
			
		}
		return resultMap;
		 
	}
	public List<Map.Entry<String, Integer>> ascAddress() {
 		Map<String, String> infoMap   = new HashMap<String, String>();
		
		// infoMap에 현재 map 깊은복사
 		// Map<String, Member> map  << map 타입
 		// >> iterator로 접근하여 put
 		Set<String> keySet = map.keySet();
 		
 		Iterator<String> it = keySet.iterator();
 		
 		while(it.hasNext()) {
 			String key = it.next(); //키 = id
 			map.get(key); // 키에해당하는 map의 값
 			infoMap.put(key, map.get(key).getAddress()); // map 에 있는 id와 address infoMap 넣기
 		}// infoMap(id , address)
 		
 		
 		List<String> list = new ArrayList<String>(); // list에 주소넣기
 		list.addAll(infoMap.values());
		
		Collections.sort(list);//정렬
		
		
//		
//		// id로 주소 변수 값을 가져와서 resultmap에 저장후 리턴
//		// list는 중복이 되니까 -> id에 해당하는 주소를 새로운 list에 넣고
//		// 해당 리스트 정렬 
//		Map<String, String> resultMap   = new HashMap<String, String>();
//		
//		Iterator<String> listIt = list.iterator();
//		//list에는 정렬된 주소만있음
//		
//		
//		while(listIt.hasNext()) {
//			String sortedAdd = listIt.next();
//			String getKey = (String)getKeyFromValue(infoMap,sortedAdd);
//			resultMap.put(getKey,sortedAdd);
//		}
		List<Map.Entry<String, Integer>> resultMap = new ArrayList<Map.Entry<String, Integer>>(table.entrySet());
		
		return resultMap;
		
	}
	public static Object getKeyFromValue(Map hm, Object value) {
	    for (Object o : hm.keySet()) {
	      if (hm.get(o).equals(value)) {
	        return o;
	      }
	    }
	    return null;
	  }
	}

