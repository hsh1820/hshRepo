package com.kh.chap3_map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.kh.chap3_map.model.vo.Member;

public class MemberController {
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public boolean joinMembership(String id, Member m) {
		// ���� ���� id�� ���ٸ� id�� m�� map�� �߰� �� true ��ȯ
		// �ִٸ� false �� ��ȯ
		if(map.containsKey(id)) {
			return false;			
		}else {
			map.put(id, m);
			return true;
		}
		
	}
	public String login(String id, String password) {
		// ���� ���� id�� �����ϴ��� Ȯ�� �� �����ϸ� Member�� ����� ��й�ȣ��
		// ����ڰ� �Է��� ��й�ȣ�� ������ ��.
		// ���ٸ� ����� Member�� �̸� ��ȯ, �� �� ��� ��Ȳ���� null ��ȯ
		if(map.get(id) != null) {
			if(map.get(id).getPassword().equals(password)) {
				String result = map.get(id).getName();
				return result;
			}return null;
			
		}return null;
	}
	public boolean changePassword(String id, String oldPw, String newPw) {
		// ���̵� �����ϸ鼭 ����� ��й�ȣ�� ����ڰ� �Է��� ��й�ȣ(oldPw)��
		// ���� �� ���ο� ��й�ȣ�� �ٲٰ� true ��ȯ, �ƴ϶�� false ��ȯ
		if(map.get(id) != null && (map.get(id).getPassword().equals(oldPw))) {
				map.get(id).setPassword(newPw);
				return true;
		}
		return false;
	}
	public void changeName(String id, String newName) {
		//���� ���� id�� ���� Member�� �̸��� ���� �Է��� �̸����� ����
		map.get(id).setName(newName);
		
	}
	public Map<String, String> sameName(String name){
		// ���� ���� name�� ����� �������� �̸��� ������
		// HashMap ��ü�� �ش� id�� �̸� ���� �� ��ü ��ȯ
		// ��, ������Ʈ �ϳ��� �̾Ƴ��� �������� keySet()�� �� ��
			Map<String, String> returnMap = new HashMap<String, String>();
			//id����
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				if(map.get(key).getName().contains(name)) {
				// id ����
				returnMap.put(key,name);
				}
				return null;
		}
			return returnMap;
	}
	
}
