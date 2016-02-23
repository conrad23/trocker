import java.util.ArrayList;

public class RouteArray {
	public Routes route1;
	public Routes route2;
	public Routes route3;
	public Routes route4;
	public Routes route5;
	public ArrayList <Routes> listRoutes;

	public RouteArray(){
		listRoutes = new ArrayList<Routes>();
		route1 = new Routes("SideWalk",1,0);
		route2= new Routes("Mound",2,0);
		route3= new Routes("Meh",3,0);
		route4= new Routes("DAMMMM",4,0);
		route5= new Routes("Walk my dog up Mt everest on the Daily",5,0);
		listRoutes.add(0, route1);
		listRoutes.add(1, route2);
		listRoutes.add(2, route3);
		listRoutes.add(3, route4);
		listRoutes.add(4, route5);
	}

	public ArrayList<Routes> getListRoutes() {
		return listRoutes;
	}

	public void setListRoutes(ArrayList<Routes> listRoutes) {
		this.listRoutes = listRoutes;
	}

	/**
	 * @return the route1
	 */
	public Routes getRoute1() {
		return route1;
	}

	/**
	 * @return the route2
	 */
	public Routes getRoute2() {
		return route2;
	}

	/**
	 * @return the route3
	 */
	public Routes getRoute3() {
		return route3;
	}

	/**
	 * @return the route4
	 */
	public Routes getRoute4() {
		return route4;
	}

	/**
	 * @return the route5
	 */
	public Routes getRoute5() {
		return route5;
	}
}
