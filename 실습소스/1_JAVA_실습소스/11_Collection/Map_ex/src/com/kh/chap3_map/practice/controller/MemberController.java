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
				// map�� key���� ���޹��� id�� ���ԵǾ� �ִٸ� 
				return false;
			}else {
				// ���޹��� id�� ���ԵǾ� ���� �ʴٸ�
				map.put(id, m);
				return true;	
			}
		
	}
	
	public String logIn(String id, String password) {
		 // �̸�, ��й�ȣ �ʿ�
		if(map.containsKey(id)) {
			if(map.get(id).getPassword().equals(password)) {
				String name = map.get(id).getName();
				return name;
			}
		} return null;
		
		}
	public boolean changePassword(String id, String oldPw,String newPw) {
		// id, oldpw, newpw
		// ���̵� �����ϸ鼭 ����� ��й�ȣ�� ����ڰ� �Է��� ��й�ȣ(oldPw)��
		// ���� �� ���ο� ��й�ȣ�� �ٲٰ� true ��ȯ, �ƴ϶�� false ��ȯ
		if(map.get(id)!=null) {
			if(map.get(id).getPassword().equals(oldPw)) {
				map.get(id).setPassword(newPw);
				return true;
			}
		}
		return false;
	}
	public void changeName(String id,String newName) {
		//���� ���� id�� ���� Member�� �̸��� ���� �Է��� �̸����� ����
		map.get(id).setName(newName);
		
	}			// id , member(name, password)
	public  Map<String, String> sameName(String name){//id	
		//			
		// ���� ���� name�� ����� �������� �̸��� ������
		// HashMap ��ü�� �ش� id�� �̸� ���� �� ��ü ��ȯ
		// ��, ������Ʈ �ϳ��� �̾Ƴ��� �������� keySet()�� �� ��
		Map<String, String> resultMap = new HashMap<String, String>();

		Set<String> keySet = map.keySet();//Ű ����
		
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			// �ݺ��ڸ� �̿��Ͽ� key ���� �� �� ����.
			String id = it.next();  // it.next()�� Ű���� ��� String ������ �����س��� String ������ ���� 
			//	=> �޼ҵ带 ȣ���Ҷ����� �ش� �޼ҵ尡 �����ϱ� ������ 
			if(map.get(id).getName().equals(name)) {
				resultMap.put(id, name);
				
			}
			
		}
		return resultMap;
		 
	}
	public List<Map.Entry<String, Integer>> ascAddress() {
 		Map<String, String> infoMap   = new HashMap<String, String>();
		
		// infoMap�� ���� map ��������
 		// Map<String, Member> map  << map Ÿ��
 		// >> iterator�� �����Ͽ� put
 		Set<String> keySet = map.keySet();
 		
 		Iterator<String> it = keySet.iterator();
 		
 		while(it.hasNext()) {
 			String key = it.next(); //Ű = id
 			map.get(key); // Ű���ش��ϴ� map�� ��
 			infoMap.put(key, map.get(key).getAddress()); // map �� �ִ� id�� address infoMap �ֱ�
 		}// infoMap(id , address)
 		
 		
 		List<String> list = new ArrayList<String>(); // list�� �ּҳֱ�
 		list.addAll(infoMap.values());
		
		Collections.sort(list);//����
		
		
//		
//		// id�� �ּ� ���� ���� �����ͼ� resultmap�� ������ ����
//		// list�� �ߺ��� �Ǵϱ� -> id�� �ش��ϴ� �ּҸ� ���ο� list�� �ְ�
//		// �ش� ����Ʈ ���� 
//		Map<String, String> resultMap   = new HashMap<String, String>();
//		
//		Iterator<String> listIt = list.iterator();
//		//list���� ���ĵ� �ּҸ�����
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

