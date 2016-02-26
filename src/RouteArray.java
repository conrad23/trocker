/**********************************************************************
 * RouteArray stores all of the routes a Member has participated in.
 * 
 * @author Stephanie Cappello
 * @author Conner Toney
 * @author Tony Alberty
 *********************************************************************/
import java.util.ArrayList;

public class RouteArray {

	public long timeSpentAtGym;
	public ArrayList<Route> listOfRoutes;

	/******************************************************************
	 * Basic constructor creates empty routearray
	 *****************************************************************/
	public RouteArray() {
		listOfRoutes = new ArrayList<Route>();
		timeSpentAtGym = 0;
	}

	/******************************************************************
	 * Creates a String version of the total time spent at the gym
	 *****************************************************************/
	public String timeAtGymToString() {
		timeSpentAtGym = 0;
		for (int i = 0; i < listOfRoutes.size(); i++) 
			timeSpentAtGym += listOfRoutes.get(i).getTotalTime();
		String str = "";
		long hours = timeSpentAtGym / 3600;
		long minutes = (timeSpentAtGym % 3600) / 60;
		long seconds = timeSpentAtGym % 60;
		str += (Long.toString(hours) + ":");
		str += (Long.toString(minutes) + ":");
		str += (Long.toString(seconds));
		return str;
	}

	public ArrayList<Route> getRouteList() {
		return listOfRoutes;
	}

	public Route getSpecificRoute(int index) {
		return listOfRoutes.get(index);
	}

	/******************************************************************
	 * Adds a route to the end of the arraylist
	 *****************************************************************/
	public void insertRoute(Route route) {
		listOfRoutes.add(route);
	}

	/******************************************************************
	 * Finds a Route based on the given route name
	 *****************************************************************/
	public Route findRoute(String routeName) {
		if (!routeName.matches("[a-zA-Z]+") || routeName.length() == 0)
			throw new IllegalArgumentException();

		for(int i = 0; i < listOfRoutes.size(); i++) {
			if (listOfRoutes.get(i).getName().equals(routeName))
				return listOfRoutes.get(i);
		}
		return null;
	}

	/******************************************************************
	 * Determines the total number of attempts for all routes
	 *****************************************************************/
	public int getTotalAttempts() {
		int totalAttempts = 0;
		for (int i = 0; i < listOfRoutes.size(); i++) {
			int routeAttempts = listOfRoutes.get(i).getNumOfAttempts();
			totalAttempts += routeAttempts;
		}
		return totalAttempts;
	}

	/******************************************************************
	 * Determines the total number of completions for all routes
	 *****************************************************************/
	public int getTotalCompletions() {
		int totalCompletions = 0;
		for (int i = 0; i < listOfRoutes.size(); i++) {
			if (listOfRoutes.get(i).isCompleted())
				totalCompletions++;
		}
		return totalCompletions;
	}

	/******************************************************************
	 * Creates a String version of the routes in the array
	 *****************************************************************/
	public String toString() {
		String str = "";

		for (int i = 0; i < listOfRoutes.size(); i++) {
			str += listOfRoutes.get(i).toString();
			str += "\n";
		}
		return str;
	}
}