
public class Route {

	public String name;
	public int difficulty;
	public int numOfAttempts;
	public boolean completed;
	//TODO: bestTime, totalTime

	//constructor takes in route name and difficulty level
	public Route(String name, int difficulty) {
		this.name = name;
		this.difficulty = difficulty;
		this.numOfAttempts = 0;
		this.completed = false;
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

	public String toString() {
		String str = "";

		str += (name + " ");
		if (difficulty == 1)
			str += ("Beginner ");
		if (difficulty == 2)
			str += ("Intermediate ");
		if (difficulty == 3)
			str += ("Expert ");
		str += (numOfAttempts + " attempts ");
		if (completed)
			str += ("Route Completed");
		if (!completed)
			str += ("Route NOT Completed");

		return str;
	}
}