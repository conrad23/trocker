import javax.xml.datatype.Duration;

public class Route {

	public String name;
	public int difficulty;
	public int numOfAttempts;
	public boolean completed;
	public long bestTime;
	public long totalTime;

	//constructor takes in route name and difficulty level
	public Route(String name, int difficulty) {
		this.name = name;
		this.difficulty = difficulty;
		this.numOfAttempts = 0;
		this.completed = false;
		this.bestTime = 0;
		this.totalTime = 0;
	}
	
	public void addAttempts(int attempts) {
		numOfAttempts += attempts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getNumOfAttempts() {
		return numOfAttempts;
	}

	public void setNumOfAttempts(int numOfAttempts) {
		this.numOfAttempts = numOfAttempts;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public long getBestTime() {
		return bestTime;
	}

	public void setBestTime(long bestTime) {
		this.bestTime = bestTime;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	
	public void addTime(long hours, long minutes, long seconds) {
		long addedDuration = seconds + (minutes * 60) + (hours * 60 * 60);
		if (bestTime == 0)
			bestTime = addedDuration;
		if (addedDuration < bestTime)
			bestTime = addedDuration;
		totalTime += addedDuration;
	}
	
	public String bestTimeToString() {
		String str = "";
		long hours = bestTime / 3600;
		long minutes = (bestTime % 3600) / 60;
		long seconds = bestTime % 60;
		str += (Long.toString(hours) + ":");
		str += (Long.toString(minutes) + ":");
		str += (Long.toString(seconds));
		return str;
	}
	
	public String totalTimeToString() {
		String str = "";
		long hours = totalTime / 3600;
		long minutes = (totalTime % 3600) / 60;
		long seconds = totalTime % 60;
		str += (Long.toString(hours) + ":");
		str += (Long.toString(minutes) + ":");
		str += (Long.toString(seconds));
		return str;
	}

	public String toString() {
		String str = "";

		str += (name + " / ");
		if (difficulty == 1)
			str += ("Beginner / ");
		if (difficulty == 2)
			str += ("Intermediate / ");
		if (difficulty == 3)
			str += ("Expert / ");
		str += (numOfAttempts + " attempts / ");
		if (completed)
			str += ("Route Completed / ");
		if (!completed)
			str += ("Route NOT Completed / ");
		str += ("Total Time: " + totalTimeToString() + " / ");
		str += ("Best Time: " + bestTimeToString());

		return str;
	}
	
	public static void main(String[] args) {
		Route r = new Route("hi", 2);
		r.addTime(0, 35, 20);
		r.addTime(2, 10, 41);
		System.out.println(r.bestTimeToString());
		System.out.println(r.totalTimeToString());
		System.out.println(r.toString());
	}
}