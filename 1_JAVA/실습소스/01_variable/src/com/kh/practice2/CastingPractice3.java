package com.kh.practice2;

import java.math.BigInteger;

//		선언 및 초기화된 5개의 변수를 가지고 알맞은 사칙연산(+, -, *, /)과 형변환을 이용하여
	//		주석에 적힌 값과 같은 값이 나오도록 코드를 작성하세요.
		
		public class CastingPractice3 { // 기능 제공용 클래스
			public void method() {
			int iNum1 = 10;
			int iNum2 = 4;
			float fNum = 3.0f;
			double dNum = 2.5;
			char ch = 'A';
			System.out.println( iNum1/iNum2 ); // 2
			System.out.println( (int)dNum ); // 2
			System.out.println( (float)Math.round(iNum2* dNum) ); // 10.0
			System.out.println( (float)iNum1 ); // 10.0
			System.out.println( (float)iNum1/ iNum2 ); // 2.5
			System.out.println( dNum ); // 2.5
			System.out.println( (int)fNum ); // 3
			System.out.println( (int)((iNum1* (int)fNum)*0.1)); // 3
			System.out.println( iNum1/ fNum );// 3.3333333
			System.out.println( (double)iNum1/ fNum ); // 3.3333333333333335
			// 실무에서는 높은 정확도를 가진 BigInteger 사용		
			//BigInteger aa;
			
			System.out.println( ch ); // 'A'
			System.out.println( (int)ch ); // 65
			System.out.println( ch+ iNum1 ); // 75
			System.out.println( (char)(ch+ iNum1) ); // 'K'
	}
}
