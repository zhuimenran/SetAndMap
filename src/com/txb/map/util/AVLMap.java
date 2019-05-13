package com.txb.map.util;

public class AVLMap <K extends Comparable<K>,V> implements Map<K,V>{

	private AVLTree<K,V> tree;
	
	public AVLMap() {
		tree = new AVLTree<K,V>();
	}
	@Override
	public void add(K key, V value) {
		
		tree.add(key, value);
	}

	@Override
	public V remove(K key) {
		
		return tree.remove(key);
	}

	@Override
	public boolean contains(K key) {
		
		return tree.contains(key);
	}

	@Override
	public boolean isEmpty() {
		
		return tree.isEmpty();
	}

	@Override
	public int getSize() {
		return tree.getSize();
	}

	@Override
	public V get(K key) {
		return tree.get(key);
	}

	@Override
	public void set(K key, V value) {
		tree.set(key, value);
		
	}

}
