import java.awt.Checkbox;
import java.awt.GridLayout;
import javax.swing.*;

public class TrockerAddRoutePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel gNumberLabel, routeNameLabel;
	private JTextField gNumberTxt, routeNameTxt;
	private Checkbox difficulty1, difficulty2, difficulty3;
	
	public TrockerAddRoutePanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(2, 2));
		gNumberLabel = new JLabel("Member's G-Number: ");
		gNumberTxt = new JTextField(15);
		routeNameLabel = new JLabel("Route Name: ");
		routeNameTxt = new JTextField(15);
		topPanel.add(gNumberLabel);
		topPanel.add(gNumberTxt);
		topPanel.add(routeNameLabel);
		topPanel.add(routeNameTxt);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));
		difficulty1 = new Checkbox("Beginner");
		difficulty2 = new Checkbox("Intermediate");
		difficulty3 = new Checkbox("Expert");
		bottomPanel.add(difficulty1);
		bottomPanel.add(difficulty2);
		bottomPanel.add(difficulty3);
		
		add(topPanel);
		add(bottomPanel);
	}
	
	public String getGNumber() {
		return gNumberTxt.getText();
	}
	
	public String getRouteName() {
		return routeNameTxt.getText();
	}
	
	public int getDifficulty() {
		if (difficulty1.getState() && !difficulty2.getState() && !difficulty3.getState())
			return 1;
		if (!difficulty1.getState() && difficulty2.getState() && !difficulty3.getState())
			return 2;
		if (!difficulty1.getState() && !difficulty2.getState() && difficulty3.getState())
			return 3;
		return 1;
	}

}
