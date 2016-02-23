
public class Routes {

	public String routeName;
	public int routeDifficulty;
	public int bestTime;


	public Routes(String name, int difficulty, int bestTime){
		this.routeName = name;
		this.routeDifficulty = difficulty;
		this.bestTime =bestTime;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public int getRouteDifficulty() {
		return routeDifficulty;
	}

	public void setRouteDifficulty(int routeDifficulty) {
		this.routeDifficulty = routeDifficulty;
	}

	public int getBestTime() {
		return bestTime;
	}

	public void setBestTime(int bestTime) {
		this.bestTime = bestTime;
	}

}
