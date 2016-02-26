/**********************************************************************
 * Node contains a Member and RouteArray object and is stored in
 * the LinkedList object.
 * 
 * @author Stephanie Cappello
 * @author Conner Toney
 * @author Tony Alberty
 *********************************************************************/
import java.io.Serializable;

public class Node implements Serializable {

	private static final long serialVersionUID = 1L;
	private Member memberData;
	private RouteArray routeData;
	private Node next;

	/******************************************************************
	 * Basic constructor creates empty Node
	 *****************************************************************/
	public Node() {}

	/******************************************************************
	 * Constructor takes in Member, RouteArray and is connected to
	 * next Node
	 *****************************************************************/
	public Node(Member data, RouteArray routeData, Node next) {
		this.memberData = data;
		this.routeData = routeData;
		this.next = next;
	}

	/******************************************************************
	 * Constructor takes in Member & RouteArray
	 *****************************************************************/
	public Node(Member data, RouteArray routeData) {
		this.next = null;
		this.routeData = routeData;
		this.memberData = data;
	}

	/******************************************************************
	 * 
	 * Various getters & setters for Node
	 * 
	 *****************************************************************/
	public Member getMemberData() {
		return memberData;
	}

	public void setMemberData(Member memberData) {
		this.memberData = memberData;
	}

	public RouteArray getRouteArrayData() {
		return routeData;
	}

	public void setRouteArrayData(RouteArray routeData) {
		this.routeData = routeData;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}