package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPractice {
	//	2차원 배열
	//	실습 문제
	//	▶ 문제 안내
	//	기능 제공 클래스 : com.kh.practice.dimension.DimensionPractice
	//	기능 실행 클래스 : com.kh.practice.run.Run
	//	한 실습 기능 클래스에 여러 메소드를 넣어 실습 진행
	//	▶ 실습문제1
	//	메소드 명 : public void practice1(){}
	//	3행 3열짜리 문자열 배열을 선언 및 할당하고
	//	인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
	//	ex.
	//	(0, 0)(0, 1)(0, 2)
	//	(1, 0)(1, 1)(1, 2)
	//	(2, 0)(2, 1)(2, 2)
	public void practice1() {
		String[][] arr = new String[3][3];
		
		arr[0][0] = "(0,0)";
		arr[0][1] = "(0,1)";
		arr[0][2] = "(0,2)";
		System.out.println(arr[0][0]+arr[0][1]+arr[0][2]);
		arr[1][0] = "(1,0)";
		arr[1][1] = "(1,1)";
		arr[1][2] = "(1,2)";
		System.out.println(arr[1][0]+arr[1][1]+arr[1][2]);
		arr[2][0] = "(2,0)";
		arr[2][1] = "(2,1)";
		arr[2][2] = "(2,2)";
		System.out.println(arr[2][0]+arr[2][1]+arr[2][2]);
	}
	
	
	
	
	
	
	
	//	▶ 실습문제2
	//	메소드 명 : public void practice2(){}
	//	4행 4열짜리 정수형 배열을 선언 및 할당하고
	//	1) 1 ~ 16까지 값을 차례대로 저장하세요.
	//	2) 저장된 값들을 차례대로 출력하세요.
	//	ex.
	//	1 2 3 4
	//	5 6 7 8
	//	9 10 11 12
	//	13 14 15 16 
	
	public void practice2()	{
		
		int count=1;
		
		int [][] arr = new int[4][4];
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0; j<arr[i].length;j++) {
				arr[i][j] = count;
				count++;
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		
	}
	
	
	
	
	
	
	//	▶ 실습문제3
	//	메소드 명 : public void practice3(){}
	//	4행 4열짜리 정수형 배열을 선언 및 할당하고
	//	1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
	//	2) 저장된 값들을 차례대로 출력하세요.
	//	ex.
	//	16 15 14 13
	//	12 11 10 9
	//	8 7 6 5
	//	4 3 2 1 
	public void practice3(){
		int[][] arr = new int[4][4];
		int count = 16;
		
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0 ; j<arr[i].length;j++) {
				arr[i][j] = count;
				count--;
				System.out.print(arr[i][j]+ " ");
			}System.out.println();
		}
	}
	
	
	//	▶ 실습문제4
	//	메소드 명 : public void practice4(){}
	//	4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
	//	아래의 내용처럼 처리하세요.
	//	ex.
	//	2 4 3 9
	//	10 2 2 14
	//	7 3 8 18
	//	19 9 13 62
	//	0열 1열 2열 3열
	//	0행 값 값 값 0행 값들의 합
	//	1행 값 값 값 1행 값들의 합
	//	2행 값 값 값 2행 값들의 합
	//	3행 0열 값들의 합 1열 값들의 합 2열 값들의 합 가로 세로 합
	public void practice4(){
		int[][] arr = new int[4][4];
		int vhap=0;
		int hhap=0;
		int total=0;
	
		
		for(int i =0; i<=arr.length/2;i++) {
			for(int j=0; j<=arr[i].length/2;j++) {
				arr[i][j]= (int)(Math.random()*10 +1);
				vhap += arr[i][j];
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.printf("%3d\n",vhap);
			total += vhap;
			vhap=0;
		}
		for(int i =0; i<=arr.length/2;i++) {
			for(int j=0; j<=arr[i].length/2;j++) {
				hhap += arr[j][i];
			}
			System.out.printf("%3d", hhap);
			total += hhap;
			hhap =0;
		}
		System.out.printf("%3d", total);
		
	}
	
	
	
	//	▶ 실습문제5
	//	메소드 명 : public void practice5(){}
	//	2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
	//	“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
	//	크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
	//	(char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
	//	ex.
	//	행 크기 : 5
	//	열 크기 : 4
	//	T P M B
	//	U I H S
	//	Q M B H
	//	H B I X
	//	G F X I 
	public void practice5(){
		Scanner sc = new Scanner(System.in);
		int row = 0;
		int col = 0;
		
		while(true) {
			System.out.print("행 크기 : ");
			row = sc.nextInt();
			System.out.print("열 크기 : ");
			col = sc.nextInt();
			
			if(!(row > 0 && row <11 && col >0 && col <11)) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				continue;
			}else {
				break;
			}
		}//while end
		
		char[][] arr = new char[row][col];
		for(int i =0 ;i<arr.length;i++) {
			for(int j =0; j<arr[i].length;j++) {
				arr[i][j]= (char)(Math.random()*10 + 65);
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		
	}
	
	
	
	
	//	▶ 실습문제6
	//	메소드 명 : public void practice6(){}
	//	String[][] strArr = new String[][] {{"이", "까", "왔", "앞", "힘"}, {"차", "지", "습", "으", "냅"}, {"원",
	//	"열", "니", "로", "시"}, {"배", "심", "다", "좀", "다"}, {"열", "히", "! ", "더", "!! "}};
	//	위의 초기화되어 있는 배열을 가지고 아래의 ‘[그림] 실습문제4 흐름’과 같은 방식으로 출력하세요.
	//	단, print()를 사용하고 값 사이에 띄어쓰기(“ “)가 존재하도록 출력하세요.
	//	1 4 7
	//	2 5 8
	//	3 6 9
	//	기존 흐름 실습문제6 흐름
	
	public void practice6(){
		String[][] strArr = new String[][] {{"이", "까", "왔", "앞", "힘"}, {"차", "지", "습", "으", "냅"}, {"원",
				"열", "니", "로", "시"}, {"배", "심", "다", "좀", "다"}, {"열", "히", "! ", "더", "!! "}};
		for(int i =0;i<strArr.length;i++) {
			for(int j =0; j<strArr[i].length;j++)	{
				System.out.print(strArr[j][i] + " ");
			}System.out.println();
		}
	}
	
	
	//	▶ 실습문제7
	//	메소드 명 : public void practice7(){}
	//	사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
	//	문자형 가변 배열을 선언 및 할당하세요.
	//	그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
	//	ex.
	//	행의 크기 : 4
	//	0열의 크기 : 2
	//	1열의 크기 : 6
	//	2열의 크기 : 3
	//	3열의 크기 : 5
	//	a b
	//	c d e f g h
	//	i j k
	//	l m n o p 
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		int col = 0;
		char alpha = 'a';
		
		char[][] arr = new char[row][];
		for(int i = 0 ;i<row;i++) {
			System.out.print(i+ "열의 크기 : ");
			col = sc.nextInt();			
			arr[i] = new char[col];
		}
		for(int i = 0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				arr[i][j] = alpha;
				alpha++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
}
