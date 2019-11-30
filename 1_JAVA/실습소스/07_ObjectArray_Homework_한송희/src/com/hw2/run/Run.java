package com.hw2.run;

import java.util.Scanner;

import com.hw2.model.vo.Student;

public class Run {
public static void main(String[] args) {
	Student[] st = new Student[10];
	Scanner sc = new Scanner(System.in);
	int count = 0;
	
	while(true)	{
		st[count] = new Student();
		
		System.out.print("학년 : ");
		st[count].setGrade(sc.nextInt());
		System.out.print("반 : ");
		st[count].setClassroom(sc.nextInt());
		sc.nextLine();
		System.out.print("이름 : ");
		st[count].setName(sc.nextLine());
		System.out.print("국어점수 : ");
		st[count].setKor(sc.nextInt());
		System.out.print("영어점수 : ");
		st[count].setEng(sc.nextInt());
		System.out.print("수학점수 : ");
		st[count].setMath(sc.nextInt());
		sc.nextLine();
		
		count++;
		
		System.out.print("추가하시겠습니까? (Y/N) : ");
		char yn = sc.next().charAt(0);
			if(yn=='y' || yn=='Y') {
				continue;
			}else {
				for(int i = count;i<st.length;i++) {
					st[i] = new Student(0, 0, null, 0, 0, 0);
				}
				break;
			}
		}//while end
	System.out.println("학년\t"+"반\t"+"이름\t"+"국어점수\t"+"영어점수\t"+"수학점수\t"+"평균");
	for(int i = 0;i<count;i++) {
		System.out.println(st[i].information()+"\t"+(st[i].getEng()+st[i].getKor()+st[i].getMath())/3);
			
		}
	
	}
}
