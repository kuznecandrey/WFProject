package org.wfproject;

import java.util.Stack;

/**
 * Simple binary tree filled by sorted array
 * @author kuznetsov
 *
 * @param <T>
 */
public class Tree<T>{
	private static class Node<T>{
		private Node<T> less;
		private Node<T> more;
		private T value;
		public Node<T> getLess() {
			return less;
		}
		public void setLess(Node<T> less) {
			this.less = less;
		}
		public Node<T> getMore() {
			return more;
		}
		public void setMore(Node<T> more) {
			this.more = more;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}		
		
	}
	private Node<T> root;
	private Node<T> add(T[] array, int start, int end){
		if (start > end)
			return null;
		Node<T> n = new Node<T>();
		int middleIndex = start+(end-start+1)/2; //middle of array
		n.setValue(array[middleIndex]);
		if (start != end){
			n.setLess(add(array, start, middleIndex - 1));
			n.setMore(add(array, middleIndex + 1, end));
		}
		return n;
	}
	/**
	 * Fill tree by sorted array
	 * @param array
	 */
	public void fillBySortedArray(T[] array){
		root = add(array,0,array.length - 1);
	}
	/**
	 * Print tree in sorted order
	 */
	public void print(){
		Stack<Node<T>> s = new Stack<Node<T>>();
		Node<T> t = root;
		while(t != null || !s.isEmpty()){
			if (!s.empty()){
                 t=s.pop();
                 System.out.print(" "+t.getValue());
                 t = t.getMore();
             }
             while (t !=null){
                 s.push(t);
                 t=t.getLess();
             }
		}
	}
}
