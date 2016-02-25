import java.io.Serializable;
import java.util.GregorianCalendar;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	public String gNumber;
	public String firstName;
	public String lastName;
	public boolean waiver;
	public int experienceLevel;
	public GregorianCalendar startDate;

	//constructor creates new member
	public Member(String gNumber, String firstName, String lastName, 
			boolean waiver, int experienceLevel, 
			GregorianCalendar startDate) {
		this.gNumber = gNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.waiver = waiver;
		this.experienceLevel = experienceLevel;
		this.startDate = startDate;
	}

	public String getgNumber() {
		return gNumber;
	}

	public void setgNumber(String gNumber) {
		this.gNumber = gNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isWaiver() {
		return waiver;
	}
	
	public String getWaiver() {
		if (waiver)
			return "Yes";
		else
			return "No";
	}

	public void setWaiver(boolean waiver) {
		this.waiver = waiver;
	}

	public int getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

}
