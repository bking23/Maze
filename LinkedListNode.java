/*
 * Program Name: Maze
 * 
 * Name: Benjamin King
 * 
 * Date: October 11, 2019
 * 
 */
public class LinkedListNode<T> {
	public T rowInfo;
	public T colInfo;
	public LinkedListNode<T> next;
	public LinkedListNode() {
		rowInfo = null;
		colInfo = null;
		next = null;
	}
	public LinkedListNode(T row, T col) {
		rowInfo = row;
		colInfo = col;
	}
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	public LinkedListNode<T> getNext() {
		return next;
	}
	public String getValue() {
		return null;
	}
}