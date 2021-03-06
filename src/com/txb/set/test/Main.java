package com.txb.set.test;

import java.util.ArrayList;

import com.txb.set.util.AVLSet;
import com.txb.set.util.BSTSet;
import com.txb.set.util.LinkedListSet;
import com.txb.util.FileOperation;

public class Main {

	//测试LinkedListSet
	private static void testLinkedListSet() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        LinkedListSet<String> bstSet = new LinkedListSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());

        System.out.println("\n a-tale-of-two-cities: ");
        list = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt", list);
        System.out.println("Total words: " + list.size());

        bstSet = new LinkedListSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());
    }


    private static void testBSTSet() {
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
    private static void testAVLSet() {
        System.out.println("pride-and-prejudice: ");
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);
        System.out.println("Total words: " + list.size());

        AVLSet<String> bstSet = new AVLSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());

        System.out.println("\n a-tale-of-two-cities: ");
        list = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt", list);
        System.out.println("Total words: " + list.size());

        bstSet = new AVLSet<>();
        for (String s : list) {
            bstSet.add(s);
        }
        System.out.println("Total different words: " + bstSet.getSize());
    }
    
	public static void main(String[] args) {
		testLinkedListSet();
		testBSTSet();
		testAVLSet();
	}

}
