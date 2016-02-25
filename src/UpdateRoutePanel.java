import java.awt.Checkbox;
import java.awt.GridLayout;
import javax.swing.*;

public class UpdateRoutePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel gNumberLabel, routeNameLabel, attemptsLabel;
	private JLabel hoursLabel, minutesLabel, secondsLabel;
	private JTextField gNumberTxt, routeNameTxt, attemptsTxt;
	private JTextField hoursTxt, minutesTxt, secondsTxt;
	private Checkbox completed;
	
	public UpdateRoutePanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(6, 2));
		gNumberLabel = new JLabel("Member's G-Number: ");
		gNumberTxt = new JTextField(15);
		routeNameLabel = new JLabel("Route Name: ");
		routeNameTxt = new JTextField(15);
		attemptsLabel = new JLabel("Added Attempts: ");
		attemptsTxt = new JTextField(15);
		hoursLabel = new JLabel("Added Hours: ");
		hoursTxt = new JTextField(15);
		minutesLabel = new JLabel("Added Minutes: ");
		minutesTxt = new JTextField(15);
		secondsLabel = new JLabel("Added Seconds: ");
		secondsTxt = new JTextField(15);
		topPanel.add(gNumberLabel);
		topPanel.add(gNumberTxt);
		topPanel.add(routeNameLabel);
		topPanel.add(routeNameTxt);
		topPanel.add(attemptsLabel);
		topPanel.add(attemptsTxt);
		topPanel.add(hoursLabel);
		topPanel.add(hoursTxt);
		topPanel.add(minutesLabel);
		topPanel.add(minutesTxt);
		topPanel.add(secondsLabel);
		topPanel.add(secondsTxt);
		
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
	
	public long getHours() {
		return Long.parseLong(hoursTxt.getText());
	}
	
	public long getMinutes() {
		return Long.parseLong(minutesTxt.getText());
	}
	
	public long getSeconds() {
		return Long.parseLong(secondsTxt.getText());
	}
}
