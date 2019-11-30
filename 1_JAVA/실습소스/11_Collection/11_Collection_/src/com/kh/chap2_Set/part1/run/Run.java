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
		// Set --> ���� ������ X, �ߺ� ����  X
		// --> index�� ���� �Ұ� (�Ϲ� for�� ��� �Ұ�)
		
		Set<String> testSet			 = new HashSet<>();
		// ���ڿ��� ������ �ִ� �ָӴ� �����
		
		
		
		testSet.add(new String("���� 30�� ��"));
		testSet.add(new String("����÷� ������?"));
		testSet.add(new String("���� �ʹ� ����Ŀ�"));
		testSet.add(new String("�Ұ�� �԰�ʹ�."));
		
		System.out.println(testSet);
		// ���� ���� X Ȯ��
		
		testSet.add(new String("���� 30�� ��"));
		System.out.println(testSet);
		// ���� ���� 2�� �ȳ��� == �ߺ� ���� Ȯ�� 
		// String�� �̹� hashCode(), equals()�� �������̵��� �Ǿ� ����
		// -> HashSet ���� �� �ߺ��� ���ŵ�
		
		
		
		
//		Set<Student> hs = new HashSet<>();
		Set<Student> hs = new LinkedHashSet<Student>();
		// ������ �����Ǵ� HashSet
		
		hs.add(new Student("������", 27, 100));
		hs.add(new Student("�����", 27, 80));
		hs.add(new Student("������", 30, 60));
		hs.add(new Student("������", 27, 100));
		
		System.out.println(hs);
		// 1) �������̵��� --> �ߺ� ���Ű� �̷�� ���� ����

		// 2) equals() �������̵� �� --> �ߺ� ���Ű� ���� ����
		//	why?  HashSet�� ���� hashCode() ���� ������ ���� �Ǻ��� �ϱ� ������
		//		 equals() ����� true���� hashCode()�� ���� �ٸ���
		//		  ���� �ٸ� ��ü�� �ν��Ѵ�.
		
		
		// Set�� ����� ��ü�� �ϳ��� �����ϴ� ���
		
		// 1. Set -> List�� ��� �� �� �����ϱ�
		List<Student> list = new ArrayList<Student>(hs); 
		
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("===============================================");
		// 2. �ݺ��� Iterator ����Ͽ� ���� => �÷��ǿ��� ���������� ����� �� �ִ� ���
		Iterator<Student> it = hs.iterator();//iterator = �ݺ���
		// hs.iterator()�� ���� �ݺ��Ҽ� �ִ� ��ü�� ��ȯ�� it�� ����
		while(it.hasNext()) { 
			// Iterator���� ���� ����Ű�� �ִ� ��ġ ���� �κп� -->���� : �ּ� -> �ε��� ->... 
			// ���� ���� ��� true
			// ������ false
			
			System.out.println(it.next()); // ����ĭ ���� �����Ͷ�			
			
		}// ����ĭ ������ �ݺ��� ����
		
		
		// 3. ���� for�� ==> java, javascript(for-each)���� ��밡��, �迭������ ��밡��
		// for(������ : �迭 �Ǵ� Collection)
		// --> �������� �迭 �Ǵ� Collection�� ��Ҹ�
		// 	�ϳ��� ���������� �����ϴ� ������ �ݺ���
		
		System.out.println("===============================================");
		for( Student s : hs) // hs : set
			// for �� �������� s�� hs�� �ϳ��� ����
			{
				System.out.println(s);
			}
			
		
		
		
		
		
	}
}
