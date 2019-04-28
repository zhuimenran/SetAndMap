package com.txb.map.test;

import java.util.ArrayList;

import com.txb.map.util.BSTMap;
import com.txb.map.util.LinkedListMap;
import com.txb.util.FileOperation;

public class Main {

	private static void testBSTMap() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        BSTMap<String, Integer> map = new BSTMap<>();
        for (String s : list) {
            if (map.contains(s)) {
                map.set(s, map.get(s) + 1);
            } else {
                map.add(s, 1);
            }
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride : " + map.get("pride"));
        System.out.println("Frequency of prejudice :  " + map.get("prejudice"));

    }

    private static void testLinkedListMap() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        for (String s : list) {
            if (map.contains(s)) {
                map.set(s, map.get(s) + 1);
            } else {
                map.add(s, 1);
            }
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride : " + map.get("pride"));
        System.out.println("Frequency of prejudice :  " + map.get("prejudice"));

    }



	public static void main(String[] args) {

		testLinkedListMap();
		testBSTMap();
		
	}

}
