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
		
		System.out.print("�г� : ");
		st[count].setGrade(sc.nextInt());
		System.out.print("�� : ");
		st[count].setClassroom(sc.nextInt());
		sc.nextLine();
		System.out.print("�̸� : ");
		st[count].setName(sc.nextLine());
		System.out.print("�������� : ");
		st[count].setKor(sc.nextInt());
		System.out.print("�������� : ");
		st[count].setEng(sc.nextInt());
		System.out.print("�������� : ");
		st[count].setMath(sc.nextInt());
		sc.nextLine();
		
		count++;
		
		System.out.print("�߰��Ͻðڽ��ϱ�? (Y/N) : ");
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
	System.out.println("�г�\t"+"��\t"+"�̸�\t"+"��������\t"+"��������\t"+"��������\t"+"���");
	for(int i = 0;i<count;i++) {
		System.out.println(st[i].information()+"\t"+(st[i].getEng()+st[i].getKor()+st[i].getMath())/3);
			
		}
	
	}
}
