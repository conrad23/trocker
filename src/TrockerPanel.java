/**********************************************************************
 * TrockerPanel is the main panel used to interact with all the
 * rock club information.
 * 
 * @author Stephanie Cappello
 * @author Conner Toney
 * @author Tony Alberty
 *********************************************************************/
import java.awt.GridLayout;
import javax.swing.*;

public class TrockerPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel northPanel;
	private JLabel memberLabel, firstNameLabel, lastNameLabel;
	private JLabel waiverLabel, experienceLabel, startDateLabel;
	private JLabel timeLabel, attemptsLabel, completionsLabel;
	
	private JPanel southPanel;
	@SuppressWarnings("unused")
	private JScrollPane scrollPane;
	private JTextArea displayArea;
	
	private LinkedList memberDB;
	
	public TrockerPanel() {
		memberDB = new LinkedList();
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 3));
		memberLabel = new JLabel("Member: " + "          ");
		firstNameLabel = new JLabel("First Name: " + "          ");
		lastNameLabel = new JLabel("Last Name: " + "          ");
		waiverLabel = new JLabel("Waiver: " + "   ");
		experienceLabel = new JLabel("Experience: " + "            ");
		startDateLabel = new JLabel("Start Date: " + "          ");
		timeLabel = new JLabel("Time Spent at Gym: " + "          ");
		attemptsLabel = new JLabel("Total Attempts: " + "   ");
		completionsLabel = new JLabel("Total Completions: " + "   ");
		
		northPanel.add(memberLabel);
		northPanel.add(firstNameLabel);
		northPanel.add(lastNameLabel);
		northPanel.add(waiverLabel);
		northPanel.add(experienceLabel);
		northPanel.add(startDateLabel);
		northPanel.add(timeLabel);
		northPanel.add(attemptsLabel);
		northPanel.add(completionsLabel);
		
		southPanel = new JPanel();
		displayArea = new JTextArea(10, 50);
		southPanel.add(displayArea);
		scrollPane = new JScrollPane(southPanel);
		
		setLayout(new GridLayout(2, 1));
		add(northPanel);
		add(southPanel);
	}
	
	public LinkedList getList() {
		return memberDB;
	}

	public JLabel getMemberLabel() {
		return memberLabel;
	}

	public void setMemberLabel(String memberLabel) {
		this.memberLabel.setText(memberLabel);
	}

	public JLabel getFirstNameLabel() {
		return firstNameLabel;
	}

	public void setFirstNameLabel(String firstNameLabel) {
		this.firstNameLabel.setText(firstNameLabel);
	}

	public JLabel getLastNameLabel() {
		return lastNameLabel;
	}

	public void setLastNameLabel(String lastNameLabel) {
		this.lastNameLabel.setText(lastNameLabel);
	}

	public JLabel getWaiverLabel() {
		return waiverLabel;
	}

	public void setWaiverLabel(String waiverLabel) {
		this.waiverLabel.setText(waiverLabel);
	}

	public JLabel getExperienceLabel() {
		return experienceLabel;
	}

	public void setExperienceLabel(String experienceLabel) {
		this.experienceLabel.setText(experienceLabel);
	}

	public JLabel getStartDateLabel() {
		return startDateLabel;
	}

	public void setStartDateLabel(String startDateLabel) {
		this.startDateLabel.setText(startDateLabel);
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(String timeLabel) {
		this.timeLabel.setText(timeLabel);
	}

	public JLabel getAttemptsLabel() {
		return attemptsLabel;
	}

	public void setAttemptsLabel(String attemptsLabel) {
		this.attemptsLabel.setText(attemptsLabel);
	}

	public JLabel getCompletionsLabel() {
		return completionsLabel;
	}

	public void setCompletionsLabel(String completionsLabel) {
		this.completionsLabel.setText(completionsLabel);
	}
	
	public void setDisplayArea(String routes) {
		displayArea.setText(routes);
	}
}