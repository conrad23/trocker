/**********************************************************************
 * TrockerGUI is the GUI the user will use to view member information,
 * add members, and add routes.
 * 
 * @author Stephanie Cappello
 * @author Conner Toney
 * @author Tony Alberty
 *********************************************************************/
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;

public class TrockerGUI {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu newMenu, findMenu, updateMenu;
	private JMenuItem newMemberItem, addRouteItem, findMemberItem;
	private JMenuItem updateRouteItem;
	private TrockerPanel trockerPanel;
	private ButtonListener buttonListener;

	/******************************************************************
	 * Constructor creates a panel that user can interact with to
	 * deal with members and routes.
	 *****************************************************************/
	public void createGUI() {
		frame = new JFrame("Trocker - The Rock Climbing Club Tracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonListener = new ButtonListener();

		menuBar = new JMenuBar();
		newMenu = new JMenu("New...");
		findMenu = new JMenu("Find...");
		updateMenu = new JMenu("Update...");

		newMemberItem = new JMenuItem("Add New Member...");
		newMemberItem.addActionListener(buttonListener);
		newMenu.add(newMemberItem);
		addRouteItem = new JMenuItem("Add Route...");
		addRouteItem.addActionListener(buttonListener);
		newMenu.add(addRouteItem);

		findMemberItem = new JMenuItem("Find Member...");
		findMemberItem.addActionListener(buttonListener);
		findMenu.add(findMemberItem);

		updateRouteItem = new JMenuItem("Update Route...");
		updateRouteItem.addActionListener(buttonListener);
		updateMenu.add(updateRouteItem);

		menuBar.add(newMenu);
		menuBar.add(findMenu);
		menuBar.add(updateMenu);
		frame.setJMenuBar(menuBar);
		trockerPanel = new TrockerPanel();
		frame.getContentPane().add(trockerPanel);
		frame.pack();
		frame.setVisible(true);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == newMemberItem) {
				TrockerNewMemberPanel newMemberPanel = 
						new TrockerNewMemberPanel();
				int result = JOptionPane.showConfirmDialog(null, 
						newMemberPanel, "New Member!", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String gNumber = newMemberPanel.getGNumber();
						String firstName = 
								newMemberPanel.getFirstName();
						String lastName = newMemberPanel.getLastName();
						boolean waiver = newMemberPanel.getWaiver();
						int experience = newMemberPanel.getExperience();
						trockerPanel.getList().add(new Member(gNumber, 
								firstName, lastName, waiver, 
								experience), new RouteArray());
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, 
								"Incorrect input!");
					}
				}
			}

			if (e.getSource() == findMemberItem) {
				try {
					String memberQuery = 
							JOptionPane.showInputDialog("Enter " + 
									"member's G Number: ");
					Node temp = trockerPanel.getList().find(memberQuery);
					trockerPanel.setMemberLabel("Member: G" + 
							temp.getMemberData().getgNumber());
					trockerPanel.setFirstNameLabel("First Name: " + 
							temp.getMemberData().getFirstName());
					trockerPanel.setLastNameLabel("Last Name: " + 
							temp.getMemberData().getLastName());
					trockerPanel.setWaiverLabel("Waiver: " + 
							temp.getMemberData().getWaiver());
					trockerPanel.setExperienceLabel("Experience: " + 
							temp.getMemberData().getExperienceLevel());
					trockerPanel.setAttemptsLabel("Total Attempts: " + 
							temp.getRouteArrayData().
							getTotalAttempts());
					trockerPanel.setCompletionsLabel("Total " + ""
							+ "Completions: " + 
							temp.getRouteArrayData().
							getTotalCompletions());
					trockerPanel.setTimeLabel("Time Spent at Gym: " + 
							temp.getRouteArrayData().
							timeAtGymToString());
					Date date = temp.getMemberData().getStartDate();
					DateFormat dateFormat = 
							new SimpleDateFormat("MM/dd/yyyy");
					trockerPanel.setStartDateLabel("Start Date: " + 
							dateFormat.format(date));
					trockerPanel.setDisplayArea(temp.
							getRouteArrayData().toString());
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "Incorrect input!");
				} catch (NullPointerException nex) {
					JOptionPane.showMessageDialog(null, "Member not found!");
				}
			}

			if (e.getSource() == addRouteItem) {
				TrockerAddRoutePanel newRoutePanel = 
						new TrockerAddRoutePanel();
				int result = JOptionPane.showConfirmDialog(null, 
						newRoutePanel, "Add Route!", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String gNumber = newRoutePanel.getGNumber();
						String routeName = newRoutePanel.getRouteName();
						int difficulty = newRoutePanel.getDifficulty();
						trockerPanel.getList().find(gNumber).
						getRouteArrayData().
						insertRoute(new Route(routeName, difficulty));
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, 
								"Incorrect input!");
					} catch (NullPointerException nex) {
						JOptionPane.showMessageDialog(null, 
								"Member not found!");
					}
				}
			}

			if (e.getSource() == updateRouteItem) {
				UpdateRoutePanel updateRoutePanel = 
						new UpdateRoutePanel();
				int result = JOptionPane.showConfirmDialog(null,  
						updateRoutePanel, "Update Route!", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String gNumber = updateRoutePanel.getGNumber();
						String routeName = 
								updateRoutePanel.getRouteName();
						int addedAttempts = 
								updateRoutePanel.getAttempts();
						boolean completed = 
								updateRoutePanel.isCompleted();
						long hours = updateRoutePanel.getHours();
						long minutes = updateRoutePanel.getMinutes();
						long seconds = updateRoutePanel.getSeconds();
						trockerPanel.getList().find(gNumber).
						getRouteArrayData().findRoute(routeName).
						addAttempts(addedAttempts);
						trockerPanel.getList().find(gNumber).
						getRouteArrayData().findRoute(routeName).
						setCompleted(completed);
						trockerPanel.getList().find(gNumber).
						getRouteArrayData().findRoute(routeName).
						addTime(hours, minutes, seconds);
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, 
								"Incorrect input!");
					} catch (NullPointerException nex) {
						JOptionPane.showMessageDialog(null, 
								"Member or route not found!");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		TrockerGUI gui = new TrockerGUI();
		gui.createGUI();
	}
}