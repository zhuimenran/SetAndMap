package com.txb.set.test;

import java.util.ArrayList;

import com.txb.set.util.BSTSet;
import com.txb.util.FileOperation;

public class TestBSTSet {

	public static void main(String[] args) {
		System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        BSTSet<String> bstSet = new BSTSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());

        System.out.println("\n a-tale-of-two-cities: ");
        list = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt", list);
        System.out.println("Total words: " + list.size());

        bstSet = new BSTSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());

	}

}
