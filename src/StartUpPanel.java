import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;


import javax.swing.*;
public class StartUpPanel extends JPanel{
	public JButton newMemberButton, currentMemberButton, exitButton;
	private JLabel intro1, intro2;
	private StartUpPanel sup;
	private MembershipPanel mp;
	public StartUpPanel(){

		intro1 = new JLabel ("Are you creating a new member");
		intro2 = new JLabel ("or recalling a current member?");
		newMemberButton = new JButton("New Member");
		newMemberButton.addActionListener(new ButtonListener());
		currentMemberButton = new JButton("Current Member");
		currentMemberButton.addActionListener(new ButtonListener());
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ButtonListener());
		//adding objects and setting up layout
		setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
		add(intro1);
		intro1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(intro2);
		intro2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension (0,10)));
		add(Box.createVerticalGlue());
		add(newMemberButton);
		newMemberButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(currentMemberButton);
		currentMemberButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(exitButton);
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

	}


	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == newMemberButton){


			}

			//grays out buttons in panel so user cannot open other frames from start menu
			//				sup.setVisible(false);
			//				mp.setVisible(true);



			if(event.getSource() == currentMemberButton){
				//grays out buttons in panel so user cannot open other frames from start menu
				newMemberButton.setEnabled(false);
				currentMemberButton.setEnabled(false);
				exitButton.setEnabled(false);
				//opens input box for gNumber for primary key retrieval


			}

			if(event.getSource() == exitButton){
				System.exit(0);
			}
		}
	}
}
