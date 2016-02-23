import java.util.GregorianCalendar;

public class Member {
	/**
	 * @author Stephanie Cappello
	 * Class for attributes of student members
	 */

	public String gNumber;
	public String studentName;
	public boolean waiver;
	public int experienceLevel;
	public GregorianCalendar startDate;

	public Member(String gNumber, String studentName, boolean waiver, int experienceLevel, GregorianCalendar startDate) {
		this.gNumber = gNumber;
		this.studentName = studentName;
		this.waiver = waiver;
		this.experienceLevel = experienceLevel;
		this.startDate = startDate;
	}

	/**
	 * @return the gNumber
	 */
	public String getgNumber() {
		return gNumber;
	}

	/**
	 * @param gNumber the gNumber to set
	 */
	public void setgNumber(String gNumber) {
		this.gNumber = gNumber;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the waiver
	 */
	public boolean isWaiver() {
		return waiver;
	}

	/**
	 * @param waiver the waiver to set
	 */
	public void setWaiver(boolean waiver) {
		this.waiver = waiver;
	}

	/**
	 * @return the experienceLevel
	 */
	public int getExperienceLevel() {
		return experienceLevel;
	}

	/**
	 * @param experienceLevel the experienceLevel to set
	 */
	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	/**
	 * @return the startDate
	 */
	public GregorianCalendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

}
