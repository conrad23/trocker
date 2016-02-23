/**
 * @author Stephanie
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;

import javax.swing.*;

@SuppressWarnings("serial")
public class MembershipPanel extends JPanel {
	//	private JPanel mp;
	private StartUpPanel sup;
	private JLabel gNumberLabel, nameLabel, waiverLabel, experienceLabel, dateLabel;
	private JTextField gNumberText, nameText, dateText;
	private JCheckBox waiverCheck;
	private JRadioButton oneLevel, twoLevel, threeLevel;
	private ButtonGroup group = new ButtonGroup();
	private JButton theFinalizer, cancelButton, resetButton;



	//	private Member member;
	private String inputgNumber;
	private String inputName;
	private boolean inputWaiver;
	private int inputExp;
	private GregorianCalendar inputDate;


	public MembershipPanel() 
	{

		//Labels instantiated
		gNumberLabel = new JLabel ("Enter Student gNumber");
		nameLabel = new JLabel ("Enter Student Name");
		waiverLabel = new JLabel ("Check if waiver signed");
		experienceLabel = new JLabel ("Exp Level");
		dateLabel = new JLabel ("Enter Start date (mm/dd/yyyy)");

		//Text fields
		gNumberText = new JTextField(9);
		nameText = new JTextField(30);
		dateText = new JTextField(10);

		//Waiver check box
		waiverCheck = new JCheckBox ("Signed waiver?");

		//Experience radio buttons
		oneLevel = new JRadioButton ("Completely new", false);
		twoLevel = new JRadioButton ("Some experience", false);
		threeLevel= new JRadioButton ("Basically climbed Mt Everest 8-)", false);
		group.add(oneLevel);
		group.add(twoLevel);
		group.add(threeLevel);

		//buttons
		theFinalizer = new JButton ("Enter");
		theFinalizer.addActionListener(new ButtonListener());
		resetButton = new JButton ("Reset");
		resetButton.addActionListener(new ButtonListener());
		cancelButton = new JButton ("Cancel");
		cancelButton.addActionListener(new ButtonListener());


		//adding these bitches to da yung panel
		add(gNumberLabel);
		add(gNumberText);

		add(nameLabel);
		add(nameText);

		add(waiverLabel);
		add(waiverCheck);

		add(experienceLabel);
		add(oneLevel);
		add(twoLevel);
		add(threeLevel);

		add(dateLabel);
		add(dateText);		

		add(theFinalizer);
		add(resetButton);
		add(cancelButton);

		//Make it cute
		setBackground (Color.lightGray);
		setPreferredSize(new Dimension(300,400));		
	}

	/*
	 * Gnumber situation
	 */

	private boolean gNumberCheck(String gNumberEntry){
		if(gNumberEntry.length() == 9){
			try {
				String numbersOnly = gNumberEntry.substring(1);
				int numberDerivedFromID = Integer.parseInt(numbersOnly);
				if(numberDerivedFromID <= 99999999)
				{
					if(gNumberEntry.substring(0, 1) == "g" || gNumberEntry.substring(0, 1) == "G")
						return true;
				}    
			} catch (NumberFormatException e) 
			{
				return false;
				//Dummies don't know how to enter gNumber
			}
			return true;
		}
		return false;
	}

	private void gNumberHelper(){
		String tempGNumber = gNumberText.getText();
		if(gNumberCheck(tempGNumber) == true){
			inputgNumber = tempGNumber;
		}
		if(gNumberCheck(tempGNumber) == false){
			JOptionPane.showMessageDialog(null, "Invalid G#");
		}

	}

	private void nameHelper(){
		String tempName = nameText.getText();
		if(tempName != ""){
			inputName = tempName;
		}
		if(tempName == ""){
			JOptionPane.showMessageDialog(null, "no name??");
		}
	}

	/**
	 * waiver situation
	 */
	private void waiverHelper()
	{
		if(waiverCheck.isSelected()){
			inputWaiver = true;
		}
		else{
			inputWaiver = false;
			JOptionPane.showMessageDialog(null, "Make sure to retrieve before allowing member to climb!");
		}
	}

	/*
	 * experience situation
	 */
	private void experienceHelper()
	{
		if(oneLevel.isSelected()){
			inputExp = 1;
		}
		if(twoLevel.isSelected()){
			inputExp = 2;
		}
		if(threeLevel.isSelected()){
			inputExp = 3;
		}
	}


	/*
	 * calendar sit
	 */
	private boolean dateCheck(String dateEntry){
		if(dateEntry.length() == 10){
			try{		
				int monthEntry = Integer.parseInt(dateEntry.substring(0, 2));
				int dayEntry = Integer.parseInt(dateEntry.substring(3, 5));
				int yearEntry = Integer.parseInt(dateEntry.substring(6));

				if(monthEntry>0 && monthEntry<13){
					if(monthEntry == 1 || monthEntry == 3 || monthEntry == 5 || monthEntry == 7 ||
							monthEntry == 8 || monthEntry == 10 || monthEntry == 12){
						if(dayEntry>0 && dayEntry<32){
							return true;
						}
						return false;
					}
					if(monthEntry == 4 || monthEntry == 6 || monthEntry == 9 || monthEntry == 11){
						if(dayEntry>0 && dayEntry<31){
							return true;
						}
						return false;
					}
					if(monthEntry == 2){
						if(yearEntry%4 ==0 && yearEntry%100 ==0){
							if(dayEntry>0 && dayEntry<30){
								return true;
							}
							return false;
						}
						if(dayEntry>0 && dayEntry<29){
							return true;
						}
						return false;
					}
					return false;
				}
			}
			catch (NumberFormatException e) {
				return false;
			}

		}
		return false;
	}

	private void calendarHelper(){
		if(dateCheck(dateText.getText()) == true){
			String dateEntry = dateText.getText();
			int monthEntry = Integer.parseInt(dateEntry.substring(0, 2));
			int dayEntry = Integer.parseInt(dateEntry.substring(3, 5));
			int yearEntry = Integer.parseInt(dateEntry.substring(6));
			GregorianCalendar tempDateVar = new GregorianCalendar(yearEntry,monthEntry,dayEntry);
			inputDate = tempDateVar;
		}

		if(dateCheck(dateText.getText()) == false){
			JOptionPane.showMessageDialog(null, "Invalid date (check format)");
		}
	}

	private void resetHelper(){
		gNumberText.setText("");
		nameText.setText("");
		waiverCheck.setSelected(false);
		oneLevel.setSelected(true);
		twoLevel.setSelected(false);
		threeLevel.setSelected(false);
		dateText.setText("");	
	}

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == theFinalizer){
				gNumberHelper();
				nameHelper();
				waiverHelper();
				experienceHelper();
				calendarHelper();
				Member member = new Member (inputgNumber, inputName, inputWaiver, inputExp, inputDate);
				RouteArray rA = new RouteArray();
				LinkedMember lm =new LinkedMember();
				lm.insert(member, rA);
				resetHelper();
			}

			if(event.getSource() == resetButton){
				resetHelper();
			}

			if(event.getSource() == cancelButton){
				resetHelper();
				sup.setVisible(true);
			}

		}

	}

}
