package com.kh.chap1_list.practice.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.chap1_list.practice.model.compare.DescSinger;
import com.kh.chap1_list.practice.model.vo.Music;

public class MusicController {
	private ArrayList<Music> list = new ArrayList<Music>();

	public boolean addList(Music music) {
		return list.add(music);
	}

	public int addAtZero(Music music) {
		list.add(0, music); // 전달 받은 Music 객체를
							// list 제일 앞에 추가
		// list내부에 전달받은 music객체가 포함되어 있는 경우
		if (list.contains(music) == true) {
			return 1;
		}
		return 0;
	}

	public ArrayList<Music> printAll() {
		System.out.print("[ ");
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				System.out.print(list.get(i));
			} else {
				System.out.print(", " + list.get(i));
			}
		}
		System.out.print(" ]\n");
		return list;
	}

	public Music searchMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				Music mc = list.get(i);
				return mc;
			}
		}
		return null;
	}

	public Music removeMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.remove(i);
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		// 1. 타이틀로 찾기
//		list.set(index, element);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.set(i, music);
			}
		}
		return null;
	}

	public int ascTitle() {  // try-catch 예외처리 적용 
		try { // 무조건 실행
			Collections.sort(list);
			return 1;			
		}catch(Exception e) {  // try 중에 발생하는 문제 catch
			return 0;			
		}			
	}
	

	public int descSinger() {
		Collections.sort(list, new DescSinger());
		// DescSinger() 정렬 기준을 이용하여 Collections.sort() 실행
		try {
			
			return 1;
		}catch(Exception e){
			return 0;			
		}
	}

}
