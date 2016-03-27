package cis350.group.trocker.model;

public class Member {

	private String firstName;
	private String lastName;
	private String gNumber;
	private String phoneNumber;
	private String waiver;
	private String experience;

	public Member() {
	}

	public Member(String firstName, String lastName, String gNumber, String phoneNumber, String waiver,
			String experience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gNumber = gNumber;
		this.phoneNumber = phoneNumber;
		this.waiver = waiver;
		this.experience = experience;
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

	public String getgNumber() {
		return gNumber;
	}

	public void setgNumber(String gNumber) {
		this.gNumber = gNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String isWaiver() {
		return waiver;
	}

	public void setWaiver(String waiver) {
		this.waiver = waiver;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
