package com.txb.set.util;

import com.txb.map.util.AVLTree;
import com.txb.map.util.Map;

public class AVLSet <E extends Comparable<E>> implements Set<E>{

	private AVLTree<E,Object> tree;
	
	
	public AVLSet() {
		tree = new AVLTree<E,Object>();
	}
	
	@Override
	public void add(E e) {
		
		tree.add(e, null);
	}

	@Override
	public boolean isEmpty() {
		
		return tree.isEmpty();
	}

	@Override
	public boolean contains(E e) {
		
		return tree.contains(e);
	}

	@Override
	public int getSize() {
		
		return tree.getSize();
	}

	@Override
	public void remove(E e) {
		
		tree.remove(e);
	}

}
