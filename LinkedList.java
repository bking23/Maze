/*
 * Program Name: Maze
 * 
 * Name: Benjamin King
 * 
 * Date: October 11, 2019
 * 
 */
public class LinkedList<T> {
	public LinkedListNode<T> first = null;
	public void insert(LinkedListNode<T> node) {
		node.setNext(first);
		first = node;
	}
	public void remove(){
		if(first.getNext()!=null)
			first = first.getNext();
		else first = null;
	}
	private void printList(LinkedListNode<T> node) {
		System.out.println("Node is " + node.getValue());
		if(node.getNext()!=null) printList(node.getNext());
	}
	public void print(){
		printList(first);
	}
}