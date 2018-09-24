package com.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;





public class DuplicateInArray {

	public static void main(String[] args) {
		int arr[]= {20,4,6,4,20,9,5,1,6};
		List<Integer> val=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			if(!val.contains(arr[i])) {
				val.add(arr[i]);
			}
		}
		for(Integer v:val) {
			System.out.println(v);
		}	

	}
}
