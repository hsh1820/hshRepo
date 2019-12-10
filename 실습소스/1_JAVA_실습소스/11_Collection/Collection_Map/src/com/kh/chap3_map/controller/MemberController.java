package com.kh.chap3_map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.kh.chap3_map.model.vo.Member;

public class MemberController {
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public boolean joinMembership(String id, Member m) {
		// 전달 받은 id가 없다면 id와 m을 map에 추가 후 true 반환
		// 있다면 false 값 반환
		if(map.containsKey(id)) {
			return false;			
		}else {
			map.put(id, m);
			return true;
		}
		
	}
	public String login(String id, String password) {
		// 전달 받은 id가 존재하는지 확인 후 존재하면 Member에 저장된 비밀번호와
		// 사용자가 입력한 비밀번호가 같은지 비교.
		// 같다면 저장된 Member의 이름 반환, 그 외 모든 상황에는 null 반환
		if(map.get(id) != null) {
			if(map.get(id).getPassword().equals(password)) {
				String result = map.get(id).getName();
				return result;
			}return null;
			
		}return null;
	}
	public boolean changePassword(String id, String oldPw, String newPw) {
		// 아이디가 존재하면서 저장된 비밀번호와 사용자가 입력한 비밀번호(oldPw)가
		// 같을 때 새로운 비밀번호로 바꾸고 true 반환, 아니라면 false 반환
		if(map.get(id) != null && (map.get(id).getPassword().equals(oldPw))) {
				map.get(id).setPassword(newPw);
				return true;
		}
		return false;
	}
	public void changeName(String id, String newName) {
		//전달 받은 id를 통해 Member의 이름을 새로 입력한 이름으로 변경
		map.get(id).setName(newName);
		
	}
	public Map<String, String> sameName(String name){
		// 전달 받은 name이 저장된 데이터의 이름과 같으면
		// HashMap 객체에 해당 id와 이름 저장 후 객체 반환
		// 단, 엘리먼트 하나씩 뽑아내는 과정에서 keySet()을 쓸 것
			Map<String, String> returnMap = new HashMap<String, String>();
			//id추출
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				if(map.get(key).getName().contains(name)) {
				// id 나옴
				returnMap.put(key,name);
				}
				return null;
		}
			return returnMap;
	}
	
}
