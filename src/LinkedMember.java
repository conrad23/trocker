import java.util.GregorianCalendar;

public class LinkedMember{
	public NodeMember first;

	public LinkedMember(){
		first = null;
	}

	public boolean isEmpty(){
		if(first==null){
			return true;
		}
		return false;
	}

	public void insert(Member m, RouteArray ra) {
		NodeMember link = new NodeMember(m, ra);
		link.next = first;
		first = link;
	}

	//    //Prints list data used to do qquick testing
	//    public void printList() {
	//	    NodeMember currentLink = first;
	//	    System.out.print("List: ");
	//	    while(currentLink != null) {
	//		    currentLink.printLink();
	//		    currentLink = currentLink.next;
	//	    }
	//	    System.out.println("");
	//    }
	//	
	//
	//    public static void main(String[] args) {
	//	    LinkedMember list = new LinkedMember();
	//	    RouteArray ra = new RouteArray();
	//	    GregorianCalendar j = new GregorianCalendar(12,13,1996);
	//	    Member mk = new Member("g00970785","Steph",true,1, j);
	//	    Member ki = new Member("g00970769","kim",false,2, j);
	//	    list.insert(mk, ra);
	//	    list.insert(ki,ra);
	//
	//	    list.printList();
	//    }
}

