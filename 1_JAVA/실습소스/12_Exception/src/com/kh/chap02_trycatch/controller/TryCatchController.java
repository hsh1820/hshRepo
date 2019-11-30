package com.kh.chap02_trycatch.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchController {
	/*	try ~ catch 구문 : 
	 * Exception 이 발생한 곳에서 직접 처리하는 예외처리 방법
	 * 
	 *  - try : 예외가 발생할 가능성이 있는 코드를 
	 *  		try블록 {} 내에 넣고 시도
	 *  
	 *  - catch : try 블록 내에서 발생하는 (던져지는) Exception을 
	 *  		잡아내서 처리하는 방법을 기술.
	 *  
	 *  - finally : try~catch 수행 후 
	 *  			마지막으로 반드시 실행해야 하는 코드를 작성
	 *  
	 *  	
	 * */
	
	public void method1() {
		// Scanner 를 이용하여 입력된 두 수 나누기
		Scanner sc = new Scanner (System.in);
		try {
			System.out.println("입력된 두 수 나누기");
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();
			System.out.print("입력 2 : ");
			int num2 = sc.nextInt();			
			
			System.out.println("num1 / num2 = " + num1/num2);
			
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");					
		}catch(InputMismatchException e) {
			// catch 구문은 여러개 작성 가능함
			// 단, 여러개 작성시 상속 관계를 고려해야 함
			System.out.println("잘 못 입력하셨습니다. 정수만 입력해주세요");
		
		}catch(Exception e) { // 다형성을 이용한 Exception catch 
			System.out.println("예외상황 발생");
			// catch 구문을 여러 개 작성 할 경우
			// 상속 관계에서 가장 자식에 위치하는 Exception을 먼저 작성 할 것.
			// -> try 블록에서 Exception 이 발생하면 
			// 		catch 구문의 가장 윗부분 부터 Exception 일치 여부를 검사하는데
			// 		부모타입의 Exception이 윗부분에 자리 잡게 되면 
			// 		해당 타입의 자식 Exception 까지 모두 검출하게 됨.
			System.out.println(e);
		}
	}
	public void method2() {
		System.out.println("BufferedReader 를 이용하여 두 수 나누기");
		
		BufferedReader br = null;
		
		try { // IO 관련 객체 생성시 반드시 생성될 때부터 Exception을 확인해야 함
			br = new BufferedReader(new InputStreamReader(System.in));
			// int, double .. 등을 제외한 String 만 입력 받을 수 있음
			// 입력받은 문자를 버퍼에 저장해두었다가 \n전까지의 문자들을 문자열로 한번에 반환
			System.out.print("입력 1 : ");
			int num1 = Integer.parseInt(br.readLine());
			
			if(num1 == 1) return; 
			
			System.out.print("입력 2 : ");
			int num2 = Integer.parseInt(br.readLine());
			
			System.out.println("num1 / num2 = " + num1/num2);
			
		}catch (IOException e){
			System.out.println("입력 중 에러 발생");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(NumberFormatException e){
			System.out.println("정수만 입력해 주세요.");
		}catch(Exception e) {
			System.out.println("예외 상황 발생");
		}finally {
			// Exception 발생 여부와 관계 없이
			// 반드시 처리해야 하는 로직을 기술하는 부분
			 
			 // 자원 반납, 반환 시 사용
			 // 사용 완료된 버퍼 반환
			 try {
				 System.out.println("BufferedReader 반환");
				 br.close(); // 버퍼 반환 
				 // IOException 발생 가능하여 try-catch
				 
				 System.out.println("프로그램 종료");
				 
			 }catch(IOException e) {
				 System.out.println("반환 중 예외 발생");
			 }
		}
			
	}
	
	public void method3() {
		// try ~ with ~ resource
		// try 구문 선언 시 매개변수로 try 내부에서 사용할 자원을
		// 미리 함께 선언하여 
		// try 구문 종료 시 자동으로 반환하게 하는 예외처리 방법
		
			System.out.println("BufferedReader 를 이용하여 두 수 나누기");
			
			
			try (BufferedReader br 
					= new BufferedReader(
							new InputStreamReader(System.in))){				
				
				
				
				System.out.print("입력 1 : ");
				int num1 = Integer.parseInt(br.readLine());
				
				if(num1 == 1) return; 
				
				System.out.print("입력 2 : ");
				int num2 = Integer.parseInt(br.readLine());
				
				System.out.println("num1 / num2 = " + num1/num2);
				
			}catch (IOException e){
				System.out.println("입력 중 에러 발생");
			}catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}catch(NumberFormatException e){
				System.out.println("정수만 입력해 주세요.");
			}catch(Exception e) {
				System.out.println("예외 상황 발생");
			}finally {
				// Exception 발생 여부와 관계 없이
				// 반드시 처리해야 하는 로직을 기술하는 부분
				 
					 System.out.println("프로그램 종료");					 
			}
	}
}
