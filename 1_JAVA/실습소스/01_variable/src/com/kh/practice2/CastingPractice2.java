package com.kh.practice2;

import java.util.Scanner;

public class CastingPractice2 {
	public void practice1() {
	float kor;
	float eng;
	float mat;
	
		
	Scanner sc = new Scanner(System.in);
	
	System.out.print("국어 : ");
	kor=sc.nextFloat();
	System.out.print("영어 : ");
	eng=sc.nextFloat();
	System.out.print("수학 : ");
	mat=sc.nextFloat();
			
	int i = (int) (kor+eng+mat);
	System.out.printf("\n총점 : %d\n", i);
	System.out.printf("총점 : %d", (int)(kor+eng+mat)/3);
	}
}
