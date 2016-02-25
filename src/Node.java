import java.io.Serializable;

public class Node implements Serializable {

	private static final long serialVersionUID = 1L;

	private Member memberData;
	private RouteArray routeData;
	private Node next;

	//empty node
	public Node() {}

	//constructor for new node
	public Node(Member data, RouteArray routeData, Node next) {
		this.memberData = data;
		this.routeData = routeData;
		this.next = next;
	}

	//constructor for new node without next
	public Node(Member data, RouteArray routeData) {
		this.next = null;
		this.routeData = routeData;
		this.memberData = data;
	}

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
