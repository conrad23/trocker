import java.io.Serializable;

public class LinkedList implements Serializable {

	private static final long serialVersionUID = 1L;
	private int count;
	private Node head;
	private boolean isFound;

	//constructor creates empty list
	public LinkedList() {
		head = null;
		count = 0;
	}

	//adds new node with member & routearray
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

	//gets node at given index
	public Node getNode(int index) {
		if (index <= 0)
			throw new IndexOutOfBoundsException();

		Node current = head;

		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;
			current = current.getNext();
		}
		return current;
	}

	//finds node with given gnumber
	public Node find(String gNumber) {
		Node current = head;
		isFound = false;

		while (current != null) {
			if (current.getMemberData().getgNumber().equals(gNumber)) {
				isFound = true;
				return current;
			}
			current = current.getNext();
		}
		return null;
	}


}
