package com.txb.set.util;

public class LinkedListSet<E> implements Set<E> {

	private LinkedList<E> list;
	
	public LinkedListSet() {
		list = new LinkedList<E>();
	}
	@Override
	public void add(E e) {
		//并没有规定不能存贮相同的元素
		if(!list.contains(e)) {
			list.addFirst(e);
		}
		
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	@Override
	public boolean contains(E e) {
		
		return list.contains(e);
	}

	@Override
	public int getSize() {
		
		return list.getSize();
	}

	@Override
	public void remove(E e) {
		list.removeElement(e);
	}

}
