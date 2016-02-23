/**
 * 
 */

/**
 * @author Stephanie
 *
 */
public class NodeMember {

	private Member member;
	private RouteArray routeRecord;
	public NodeMember next;

	public NodeMember(Member m, RouteArray rA) {
		member = m;
		routeRecord =rA;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public RouteArray getRouteRecord() {
		return routeRecord;
	}

	public void setRouteRecord(RouteArray routeRecord) {
		this.routeRecord = routeRecord;
	}

	public NodeMember getNext() {
		return next;
	}

	public void setNext(NodeMember next) {
		this.next = next;
	}

	//    //Print Link data for testing
	//    public void printLink() {
	//	    System.out.print(member.getgNumber() + routeRecord.getRoute1().getRouteName());
	//    }
}
