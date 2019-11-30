package com.kh.chap05_properties.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Run {
	public static void main(String[] args) {
		
		// Properties : K,V ��� String Ÿ���� Map
		
		Properties prop = new Properties();
		// k, v = ������ String,String 
		// ������ Ÿ������ ����
		HashMap<String, String> map = new HashMap<String, String>();
		// Properties�� ������ K,V �� String �̱� ������ 
		// 1) ������ ���׸��� �̿��� Ÿ�������� �ʿ����
		
//		map.put(key, value);
//		prop.put(key, value);
		// Hashtable ����̱⶧���� �������� object
		
		//setProperty(key, value) : �� �߰�
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		
		System.out.println(prop);
		// Map�� Ű�� ��������� set������ ����
		// set�� Ư¡ : 1) �ߺ� �ȵ� 
				//   2) ���� ���� �ȵ�
		
		
		// getPropertie(key)
		System.out.println(prop.getProperty("List")); // Ű�� �� ������
		// get() �� ��� �θ�ü�� �޾ƿ��� ���̱� ������ ������Ʈ Ÿ���� �Ű������� �������Ե�
		
		// store(OutputStream os, String Comments)
		// -> Properties ��ü�� ��� K,V ���� ���Ϸ� ���
		try {
			prop.store(new FileOutputStream("test.properties"), "Test Properties File");
			// comment �� properties ��ܿ� #���� �ּ� ó���Ǿ� ��µ�
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
