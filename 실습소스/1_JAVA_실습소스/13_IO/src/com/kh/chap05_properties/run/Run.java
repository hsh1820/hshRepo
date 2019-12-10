package com.kh.chap05_properties.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Run {
	public static void main(String[] args) {
		
		// Properties : K,V 모두 String 타입인 Map
		
		Properties prop = new Properties();
		// k, v = 무조건 String,String 
		// 별도의 타입제한 없음
		HashMap<String, String> map = new HashMap<String, String>();
		// Properties는 무조건 K,V 가 String 이기 때문에 
		// 1) 별도의 제네릭을 이용한 타입제한이 필요없음
		
//		map.put(key, value);
//		prop.put(key, value);
		// Hashtable 상속이기때문에 설명에서는 object
		
		//setProperty(key, value) : 값 추가
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		
		System.out.println(prop);
		// Map의 키만 모았을때는 set성질을 가짐
		// set의 특징 : 1) 중복 안됨 
				//   2) 순서 유지 안됨
		
		
		// getPropertie(key)
		System.out.println(prop.getProperty("List")); // 키로 값 가져옴
		// get() 의 경우 부모객체를 받아오는 것이기 때문에 오브젝트 타입을 매개변수로 가져오게됨
		
		// store(OutputStream os, String Comments)
		// -> Properties 객체에 담긴 K,V 값을 파일로 출력
		try {
			prop.store(new FileOutputStream("test.properties"), "Test Properties File");
			// comment 는 properties 상단에 #으로 주석 처리되어 출력됨
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
