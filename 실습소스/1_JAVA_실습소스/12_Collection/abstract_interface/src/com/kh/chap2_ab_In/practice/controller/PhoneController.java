package com.kh.chap2_ab_In.practice.controller;

import com.kh.chap2_ab_In.practice.model.vo.GalaxyNote9;
import com.kh.chap2_ab_In.practice.model.vo.Phone;
import com.kh.chap2_ab_In.practice.model.vo.V40;

public class PhoneController {
	private String[] result = new String[2];
	
	
	
	public String[] method() {
		Phone[] parr = new Phone[2];
		
		parr[0] = new GalaxyNote9();
		parr[1] = new V40();
		
		for(int i =0;i<parr.length;i++) {
			if(parr[i] instanceof GalaxyNote9) {
				result[i] = ((GalaxyNote9) parr[i]).printInformation();
				
			}
			if(parr[i] instanceof V40) {
				result[i] = ((V40) parr[i]).printInformation();
				
			}
			
		}
		
		return result;
	}
}
