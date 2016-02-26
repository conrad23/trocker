/**********************************************************************
 * LinkedList stores Members and their corresponding RouteArrays in
 * a linked list data structure.
 * 
 * @author Stephanie Cappello
 * @author Conner Toney
 * @author Tony Alberty
 *********************************************************************/
import java.io.Serializable;

public class LinkedList implements Serializable {

	private static final long serialVersionUID = 1L;
	private int count;
	private Node head;

	/******************************************************************
	 * Basic constructor creates empty linked list
	 *****************************************************************/
	public LinkedList() {
		head = null;
		count = 0;
	}

	/******************************************************************
	 * Adds a Member and RouteArray to the linked list
	 *****************************************************************/
	public void add(Member memberData, RouteArray raData) {
		Node temp = new Node(memberData, raData);
		Node current = head;

		if (head == null) {
			head = temp;
			count++;
			return;
		}

		if (count == 1) {
			head.setNext(temp);
			temp.setNext(null);
			count++;
			return;
		}

		while (current.getNext() != null)
			current = current.getNext();

		current.setNext(temp);
		temp.setNext(null);
		count++;
	}

	/******************************************************************
	 * Gets a Node from the given index
	 *****************************************************************/
	public Node getNode(int index) {
		if (index <= 0 || index > count)
			throw new IndexOutOfBoundsException();

		Node current = head;

		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;
			current = current.getNext();
		}
		return current;
	}

	/******************************************************************
	 * Find a Node based upon the given student's gnumber
	 *****************************************************************/
	public Node find(String gNumber) {
		if (gNumber.length() != 9 || !gNumber.matches("[0-9]+"))
			throw new IllegalArgumentException();

		Node current = head;

		while (current != null) {
			if (current.getMemberData().getgNumber().equals(gNumber)) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}

	/******************************************************************
	 * Gets the current size of the linked list
	 *****************************************************************/
	public int getSize() {
		return count;
	}


}
