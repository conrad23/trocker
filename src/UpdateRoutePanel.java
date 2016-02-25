import java.awt.Checkbox;
import java.awt.GridLayout;
import javax.swing.*;

public class UpdateRoutePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel gNumberLabel, routeNameLabel, attemptsLabel;
	private JTextField gNumberTxt, routeNameTxt, attemptsTxt;
	private Checkbox completed;
	
	public UpdateRoutePanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(3, 2));
		gNumberLabel = new JLabel("Member's G-Number: ");
		gNumberTxt = new JTextField(15);
		routeNameLabel = new JLabel("Route Name: ");
		routeNameTxt = new JTextField(15);
		attemptsLabel = new JLabel("Added Attempts: ");
		attemptsTxt = new JTextField(15);
		topPanel.add(gNumberLabel);
		topPanel.add(gNumberTxt);
		topPanel.add(routeNameLabel);
		topPanel.add(routeNameTxt);
		topPanel.add(attemptsLabel);
		topPanel.add(attemptsTxt);
		
		JPanel bottomPanel = new JPanel();
		completed = new Checkbox("Completed?");
		bottomPanel.add(completed);
		
		this.add(topPanel);
		this.add(bottomPanel);
	}
	
	public String getGNumber() {
		return gNumberTxt.getText();
	}
	
	public String getRouteName() {
		return routeNameTxt.getText();
	}
	
	public boolean isCompleted() {
		return completed.getState();
	}
	
	public int getAttempts() {
		return Integer.parseInt(attemptsTxt.getText());
	}
}
