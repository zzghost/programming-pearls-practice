package chapter01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class prac01 {
	public static List<Integer> getRandomList(int amount){
		List<Integer> aList = new ArrayList();
		Random random = new Random();
		
		while(aList.size() < (amount - 1)){
			int element = random.nextInt(amount - 1) + 1;
			
			if(!aList.contains(element))
				aList.add(element);
		}
		
		return aList;
	}
	
	public static List<Integer> bitMapSortedArray(List<Integer> aList){
		int amount = aList.size();
		
		int[] bitMapList = new int[(amount-1) / 32 + 1];
		for(int x : aList){
			int P = x / 32;
			int Q = x % 32;
			bitMapList[P] = bitMapList[P] | (1 << Q);
		}
		
		List<Integer> sortedList = new ArrayList();
		for(int i = 0; i < amount; i++){
			int P = i / 32;
			int Q = i % 32;
			int idx = Integer.bitCount(bitMapList[P] & (1 << Q));
			if(idx == 1)
				sortedList.add(i);
		}
		
		return sortedList;
	}
	public static void main(String[] args){
		System.out.println("Please define n(the amount of the array to be sorted):");
		Scanner sc = new Scanner(System.in);
		int amount = 0;
		if(sc.hasNext()){
			amount = sc.nextInt();
		}
		List<Integer> aList = getRandomList(amount);
		
		System.out.println("The array before sorting:");
		for(int x : aList){
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("Using Collections' sort() function for sorting:");
		long beforeSortTime = System.currentTimeMillis();
		Collections.sort(aList);
		long afterSortTime = System.currentTimeMillis();
		
		for(int x : aList){
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("It tooks " + (afterSortTime - beforeSortTime) + "s.");
		
		System.out.println("------------------");
		
		aList = getRandomList(amount);
		
		System.out.println("The array before sorting:");
		for(int x : aList){
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("Using bitmap for sorting:");
		long beforeSortTime2 = System.currentTimeMillis();
		aList = bitMapSortedArray(aList);
		long afterSortTime2 = System.currentTimeMillis();
		
		for(int x : aList){
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("It tooks " + (afterSortTime2 - beforeSortTime2) + "s.");
		
	}
}
