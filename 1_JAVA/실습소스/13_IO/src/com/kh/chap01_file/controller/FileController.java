package com.kh.chap01_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method1() {
		try {
			// 1. 현재 프로젝트에 test.txt 파일 생성하기
			File f1 = new File("test.txt");
			// --> f1 : 생성되지 않은 파일이지만 존재한다고 가정한 상태
			// test.txt를 메모리에 가상으로 만들어둔 상태
			// 파일의 경로를 지정하지 않으면 프로젝트 내부 최상단에 파일 생성
			
			f1.createNewFile();// 해당 메소드가 실행되야 파일 생성됨
			// checked exception인 IOException 발생
			// try-catch 문 필요
			
			// 2. 기존에 존재하는 폴더에 파일을 생성
			File f2 = new File("C:\\dev\\test.txt");
			// \ --> 1개만 쓰면 이스케이프문자로 인식함
			
			f2.createNewFile();
			
			//3. 기존에 없는 폴더에 파일 생성 -- 지정된 경로를 찾을 수 없습니다. 예외 발생
//			File f3 = new File("c:\\dev\\temp\\test.txt");
			
//			f3.createNewFile();
			// -> 없는 경로에는 파일 생성 불가능(IOException 발생)
			
			// 폴더 생성
			File f3 = new File("c:\\dev\\temp\\t1");
			f3.mkdir(); // 폴더 생성 메소드
			// mkdir() : 하위폴더 생성 불가 .
			// 하위폴더 포함 생성은 mkdirs()
			
			File f4 = new File("c:\\dev\\temp\\test.txt");
			f4.createNewFile();
			
			File f5 = new File("c:\\dev\\temp2\\test"); 
			f5.mkdirs();// 폴더까지만 생성되고 txt파일은 생성 안됨			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void method2() {
		// c:\\dev\\temp3 폴더가 있는지 검사 후 없으면 생성하고
		// temp3 폴더에 person.txt 을 생성
		// ==> 생성 성공 시 메세지 출력
			File folder = new File("c:\\dev\\temp3");
			if(!folder.exists()) { // temp3 폴더가 존재하지 않는다면
				folder.mkdir();// 폴더 생성
				// mkdir(), mkdirs() : 어떤 운영체제에도 모두 존재하는 명령어이기때문에 
				// Exception 처리 필요 없음
				System.out.println(folder.getName()+ " 폴더를 생성 하였습니다.");
		}
			try {
				File file = new File("c:\\dev\\temp3\\person.txt");
				if(file.createNewFile()) { // person.txt 생성 성공 시
					System.out.println(file.getName() + " 파일을 생성하였습니다.");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
