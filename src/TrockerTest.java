/**********************************************************************
 * TrockerTest tests various details for Trocker.
 * 
 * @author Stephanie Cappello
 * @author Conner Toney
 * @author Tony Alberty
 *********************************************************************/
import static org.junit.Assert.*;
import org.junit.Test;

@SuppressWarnings("unused")
public class TrockerTest {

	//test LinkedList constructor
	@Test
	public void testLinkedList1() {
		LinkedList l = new LinkedList();
		int size = 0;
		assertEquals(size, l.getSize());
	}

	@Test
	public void testLinkedList2() {
		LinkedList l = new LinkedList();
		int size = 1;
		assertNotEquals(size, l.getSize());
	}

	//test LinkedList add() getNode()
	@Test
	public void testLinkedList3() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		assertEquals(l.getNode(1).getMemberData(), m);	
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testLinkedList4() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.getNode(0);	
	}

	@Test
	public void testLinkedList5() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		Member m2 = new Member("999999999", "Jane", "Doe", false, 2);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.add(m2, ra);
		assertEquals(l.getNode(1).getMemberData(), m);
		assertEquals(l.getNode(2).getMemberData(), m2);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testLinkedList6() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.getNode(2);	
	}

	//test LinkedList find()
	@Test (expected = IllegalArgumentException.class)
	public void testLinkedList7() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.find("1234567891");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLinkedList8() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.find("12345678");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLinkedList9() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.find("abcdefghi");
	}

	@Test
	public void testLinkedList10() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		assertEquals(l.find("123456789").getMemberData(), m);
	}

	@Test
	public void testLinkedList11() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		Member m2 = new Member("999999999", "Jane", "Doe", false, 2);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.add(m2, ra);
		assertEquals(l.find("123456789").getMemberData(), m);
	}

	@Test
	public void testLinkedList12() {
		LinkedList l = new LinkedList();
		Member m = new Member("123456789", "John", "Doe", true, 3);
		Member m2 = new Member("999999999", "Jane", "Doe", false, 2);
		RouteArray ra = new RouteArray();
		l.add(m, ra);
		l.add(m2, ra);
		assertEquals(l.find("999999999").getMemberData(), m2);
	}


	//test Member constructor
	@Test (expected = IllegalArgumentException.class)
	public void testMember1() {
		Member m = new Member("12345678", "John", "Doe", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember2() {
		Member m = new Member("1234567891", "John", "Doe", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember3() {
		Member m = new Member("abcdefghi", "John", "Doe", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember4() {
		Member m = new Member("", "John", "Doe", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember5() {
		Member m = new Member("123456789", "", "Doe", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember6() {
		Member m = new Member("123456789", "123", "Doe", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember7() {
		Member m = new Member("123456789", "John1", "Doe", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember9() {
		Member m = new Member("123456789", "John", "", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember10() {
		Member m = new Member("123456789", "John", "123", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember11() {
		Member m = new Member("123456789", "John", "Doe1", true, 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember12() {
		Member m = new Member("123456789", "John", "Doe", true, 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMember13() {
		Member m = new Member("123456789", "John", "Doe", true, 4);
	}

	//test Member getWaiver()
	@Test
	public void testMember14() {
		Member m = new Member("123456789", "John", "Doe", false, 3);
		assertEquals(m.getWaiver(), "No");
	}

	@Test
	public void testMember15() {
		Member m = new Member("123456789", "John", "Doe", true, 3);
		assertEquals(m.getWaiver(), "Yes");
	}


	//test Route constructor
	@Test (expected = IllegalArgumentException.class)
	public void testRoute1() {
		Route r = new Route("", 2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testRoute2() {
		Route r = new Route("Rocky Road", 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testRoute3() {
		Route r = new Route("", 4);
	}

	//test Route addAttempts()
	@Test
	public void testRoute4() {
		Route r = new Route("Rocky Road", 2);
		r.addAttempts(4);
		int x = 4;
		assertEquals(r.getNumOfAttempts(), x);
	}

	//test Route addTime()
	@Test (expected = IllegalArgumentException.class)
	public void testRoute5() {
		Route r = new Route("Rocky Road", 2);
		r.addTime(5, 60, 10);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testRoute6() {
		Route r = new Route("Rocky Road", 2);
		r.addTime(5, 6, 60);
	}


	//test Route bestTimeToString()
	@Test
	public void testRoute7() {
		Route r = new Route("Rocky Road", 2);
		r.addTime(5, 59, 10);
		r.addTime(4, 59, 10);
		assertEquals(r.bestTimeToString(), "4:59:10");
	}

	//test Route totalTimeToString()
	@Test
	public void testRoute8() {
		Route r = new Route("Rocky Road", 2);
		r.addTime(5, 59, 59);
		r.addTime(0, 0, 1);
		assertEquals(r.totalTimeToString(), "6:0:0");
	}
}