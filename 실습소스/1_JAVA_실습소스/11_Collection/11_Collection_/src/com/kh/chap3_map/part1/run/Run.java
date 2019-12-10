package com.kh.chap3_map.part1.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap3_map.part1.model.vo.Snack;

public class Run {
	public static void main(String[] args) {
		// key�� String, value�� Snack���� Ÿ���� ������ HashMap ��ü ����
		Map<String, Snack> map = new HashMap<String, Snack>();
		
		// 1. put(K key, V value) --> Map�� �����͸� �߰��ϴ� �޼ҵ�
		map.put("������", new Snack("������",2500, 1105));
		map.put("��������", new Snack("������",1500, 420));
		map.put("���", new Snack("�ٳ���ű",1500, 315));
		
		System.out.println(map);
		
		// �ߺ��Ǵ� Ű���� ������ �߰�
		map.put("������", new Snack("��������", 4000, 2052));
		
		System.out.println(map);
		// Ű���� �ߺ��Ǹ� �������� �߰��� Value�� ���� ����
		
		// 2. get(Object key)
		// --> Map���� �ش��ϴ� key���� value�� ������ �޼ҵ�
		System.out.println(map.get("���"));
		// Ű������ �˻�
		
		// 3. size()
		// --> Map�� ����Ǿ��ִ� key�� ������ ��ȯ
		System.out.println("Map�� ����� �������� ���� : " + map.size());
		
		// 4. replace(K key, V value)  
		// --> Map�� ����� ������ �� key ���� ���� Entry�� value�� ����
		// * Entry �� ? key = value �� ���� ���´� ��
		map.replace("������",new Snack("������",2500, 1105));
		System.out.println(map);
		
		// put() ���� ��쿡�� key���� �ߺ����� ������ �����Ͱ� �߰�������
		// replace()�� key ���� �ߺ����� ������ �����͸� �߰����� �ʰ� 
		// null���� ��ȯ
		
		// 5. remove(K key)
		// --> �ش� key�� ������ �ִ� Entry�� ����
		map.remove("��������");
		System.out.println(map);
			
		
		// Map�� ����� �����͸� �ϳ� �� �ݺ� �����ϱ�

		// Iterator �ݺ��� ���
		
		// 1. keySet() Ȱ��
		// --> Map�� ����� ������ �� key ���鸸 Set���� ����
		Set<String> keySet = map.keySet();
		
		Iterator<String> it = keySet.iterator();
		// keySet�� �����ϰ� �ִ� Set�� ������
		// Iterator�� �̿��Ͽ� �ݺ��ڿ� ��� ����
		
		// �ݺ����� �̿��Ͽ� key�� value ����ϱ�
		while(it.hasNext()) {
			// �ݺ��ڸ� �̿��Ͽ� key ���� �� �� ����.
			String key = it.next();  // it.next()�� Ű���� ��� String ������ �����س��� String ������ ���� 
									 //	=> �޼ҵ带 ȣ���Ҷ����� �ش� �޼ҵ尡 �����ϱ� ������ 
			System.out.println("key : " + key);
			System.out.println("value : " + map.get(key));
		}

		// 2. keySet() + ���� for��
		System.out.println();
		for(String key : keySet) {
			System.out.println("key : " + key);
			System.out.println("value : " + map.get(key));
		}
		
		// 3. entrySet() Ȱ��
		// Map�������̽� �ȿ� entry ���� �������̽� ����
		// --> �̺�Ʈ(���� Ŭ����)�� �ش��ϴ� ������ ������ �� ���.
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		
		// Iterator �ݺ� ����
		Iterator<Entry<String, Snack>> it2 = entrySet.iterator(); // Set�� ������ Ÿ������
		System.out.println();
		while(it2.hasNext()){
			Entry<String, Snack> entry = it2.next(); // Entry<String, Snack> ����
			System.out.println("key : " + entry.getKey());
			System.out.println("key : " + entry.getValue());
			
			
		}
		
	}
}
