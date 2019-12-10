package com.kh.chap3_map.practice.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.kh.chap3_map.practice.model.vo.Member;

public class MemberController {
	
	private HashMap<String,Member> map = new HashMap<String,Member>();

	public boolean joinMembership(String id, Member m) {
		// ���� ���� id�� ���ٸ� id�� m�� map�� �߰� �� true ��ȯ
		// �ִٸ� false �� ��ȯ
		if(!map.containsKey(id)) {
			map.put(id, m);
			return true;
		} else {
			return false;
		}
	}
	
	public String logIn(String id, String password) {
		// ���� ���� id�� �����ϴ��� Ȯ�� �� �����ϸ� Member�� ����� ��й�ȣ��
		// ����ڰ� �Է��� ��й�ȣ�� ������ ��.
		// ���ٸ� ����� Member�� �̸� ��ȯ, �� �� ��� ��Ȳ���� null ��ȯ
		if(map.containsKey(id)) {
			Member m = map.get(id);
			String savedPw = m.getPassword();
			
			if(savedPw.equals(password))
				return m.getName();
			else
				return null;
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		// ���̵� �����ϸ鼭 ����� ��й�ȣ�� ����ڰ� �Է��� ��й�ȣ(oldPw)��
		// ���� �� ���ο� ��й�ȣ�� �ٲٰ� true ��ȯ, �ƴ϶�� false ��ȯ

		boolean existedId = map.containsKey(id);
		
		Member m = map.get(id);
		String savedPw = m.getPassword();
		boolean existedPw = savedPw.equals(oldPw);
		
		if(existedId && existedPw) {
			m.setPassword(newPw);
			return true;
		}
		
		return false;
	}
	
	public void changeName(String id, String newName) {
		//���� ���� id�� ���� Member�� �̸��� ���� �Է��� �̸����� ����
		Member m = map.get(id);
		m.setName(newName);
	}
	
	public Map<String,String> sameName(String name) {
			// ���� ���� name�� ����� �������� �̸��� ������
		// HashMap ��ü�� �ش� id�� �̸� ���� �� ��ü ��ȯ
		// ��, ������Ʈ �ϳ��� �̾Ƴ��� �������� keySet()�� �� ��
		HashMap<String,String> same = new HashMap<String,String>();
		
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			Member m = map.get(key);
			if(m.getName().equals(name)) {
				same.put(key, name);
			}
		}
		
		return same;
	}
}
