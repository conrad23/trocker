import java.util.ArrayList;

public class RouteArray {

	//TODO: total time for all routes
	
	public ArrayList<Route> listOfRoutes;
	
	public RouteArray() {
		listOfRoutes = new ArrayList<Route>();
	}
	
	public ArrayList<Route> getRouteList() {
		return listOfRoutes;
	}
	
	public Route getSpecificRoute(int index) {
		return listOfRoutes.get(index);
	}
	
	public void insertRoute(Route route) {
		listOfRoutes.add(route);
	}
	
	public Route findRoute(String routeName) {
		for(int i = 0; i < listOfRoutes.size(); i++) {
			if (listOfRoutes.get(i).getName().equals(routeName))
				return listOfRoutes.get(i);
		}
		return null;
	}
	
	public int getTotalAttempts() {
		int totalAttempts = 0;
		for (int i = 0; i < listOfRoutes.size(); i++) {
			int routeAttempts = listOfRoutes.get(i).getNumOfAttempts();
			totalAttempts += routeAttempts;
		}
		return totalAttempts;
	}
	
	public int getTotalCompletions() {
		int totalCompletions = 0;
		for (int i = 0; i < listOfRoutes.size(); i++) {
			if (listOfRoutes.get(i).isCompleted())
				totalCompletions++;
		}
		return totalCompletions;
	}
	
	public String toString() {
		String str = "";
		
		for (int i = 0; i < listOfRoutes.size(); i++) {
			str += listOfRoutes.get(i).toString();
			str += "\n";
		}
		return str;
	}
}
