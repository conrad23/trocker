import java.awt.Checkbox;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TrockerNewMemberPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel gNumberLabel, firstNameLabel, lastNameLabel;
	private JTextField gNumberTxt, firstNameTxt, lastNameTxt;
	private Checkbox waiverBox, experience1, experience2, experience3;

	public TrockerNewMemberPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(3, 2));
		gNumberLabel = new JLabel("G-Number: ");
		gNumberTxt = new JTextField(15);
		firstNameLabel = new JLabel("First Name: ");
		firstNameTxt = new JTextField(15);
		lastNameLabel = new JLabel("Last Name: ");
		lastNameTxt = new JTextField(15);
		topPanel.add(gNumberLabel);
		topPanel.add(gNumberTxt);
		topPanel.add(firstNameLabel);
		topPanel.add(firstNameTxt);
		topPanel.add(lastNameLabel);
		topPanel.add(lastNameTxt);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1, 1));
		waiverBox = new Checkbox("Waiver");
		middlePanel.add(waiverBox);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));
		experience1 = new Checkbox("Beginner");
		experience2 = new Checkbox("Intermediate");
		experience3 = new Checkbox("Expert");
		bottomPanel.add(experience1);
		bottomPanel.add(experience2);
		bottomPanel.add(experience3);

		this.setLayout(new GridLayout(3, 1));
		this.add(topPanel);
		this.add(middlePanel);
		this.add(bottomPanel);
	}

	public String getGNumber() {
		return gNumberTxt.getText();
	}
	
	public String getFirstName() {
		return firstNameTxt.getText();
	}
	
	public String getLastName() {
		return lastNameTxt.getText();
	}
	
	public boolean getWaiver() {
		if (waiverBox.getState())
			return true;
		else
			return false;
	}
	
	public int getExperience() {
		if (experience1.getState() && !experience2.getState() && !experience3.getState())
			return 1;
		if (!experience1.getState() && experience2.getState() && !experience3.getState())
			return 2;
		if (!experience1.getState() && !experience2.getState() && experience3.getState())
			return 3;
		return 1;
	}
}
