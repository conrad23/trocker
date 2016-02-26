/**********************************************************************
 * Member object is used to contain various information about the
 * members of the GVSU rock climbing club.
 * 
 * @author Stephanie Cappello
 * @author Conner Toney
 * @author Tony Alberty
 *********************************************************************/

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	public String gNumber;
	public String firstName;
	public String lastName;
	public boolean waiver;
	public int experienceLevel;
	public Date startDate;

	/******************************************************************
	 * Basic constructor for Member object.
	 * @param gNumber student's gnumber
	 * @param firstName student's first name
	 * @param lastName student's last name
	 * @param waiver has student signed waiver
	 * @param experienceLevel level of student's experience
	 *****************************************************************/
	public Member(String gNumber, String firstName, String lastName, 
			boolean waiver, int experienceLevel) {
		if (gNumber.length() != 9 || !gNumber.matches("[0-9]+"))
			throw new IllegalArgumentException();
		if (!firstName.matches("[a-zA-Z]+") || firstName.length() == 0)
			throw new IllegalArgumentException();
		if (!lastName.matches("[a-zA-Z]+") || lastName.length() == 0)
			throw new IllegalArgumentException();
		if (experienceLevel < 1 || experienceLevel > 3)
			throw new IllegalArgumentException();

		this.gNumber = gNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.waiver = waiver;
		this.experienceLevel = experienceLevel;
		this.startDate = new Date();		
	}

	/******************************************************************
	 * Gets a String version of whether or not the waiver form's signed
	 * @return yes if signed, no if not
	 *****************************************************************/
	public String getWaiver() {
		if (waiver)
			return "Yes";
		else
			return "No";
	}

	/******************************************************************
	 * 
	 * Various getters & setters for Member object.
	 * 
	 *****************************************************************/

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

	public void setWaiver(boolean waiver) {
		this.waiver = waiver;
	}

	public int getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}