 package cis350.group.trocker;

import cis350.group.trocker.model.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberController {

	@FXML
	private TableView<Member> memberTable;

	@FXML
	private TableColumn<Member, String> firstNameColumn;

	@FXML
	private TableColumn<Member, String> lastNameColumn;

	@FXML
	private TableColumn<Member, String> gNumberColumn;

	@FXML
	private Label firstNameLabel;

	@FXML
	private Label lastNameLabel;

	@FXML
	private Label gNumberLabel;

	@FXML
	private Label phoneNumberLabel;

	@FXML
	private Label waiverLabel;

	@FXML
	private Label experienceLabel;

	private MainApp mainApp;

	public MemberController() {
	}

	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("lastName"));
		gNumberColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("gNumber"));

		memberTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		showMemberDetails(null);

		memberTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Member>() {

			@Override
			public void changed(ObservableValue<? extends Member> observable, Member oldValue, Member newValue) {
				showMemberDetails(newValue);
			}
		});

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		memberTable.setItems(mainApp.getMemberList());
	}

	private void showMemberDetails(Member member) {
		if (member != null) {
			firstNameLabel.setText(member.getFirstName());
			lastNameLabel.setText(member.getLastName());
			gNumberLabel.setText(member.getgNumber());
			phoneNumberLabel.setText(member.getPhoneNumber());
			waiverLabel.setText(member.isWaiver());
			experienceLabel.setText(member.getExperience());
		} else {
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			gNumberLabel.setText("");
			phoneNumberLabel.setText("");
			waiverLabel.setText("");
			experienceLabel.setText(" ");
		}
	}

	@FXML
	private void handleDeleteMember() {
		int selectedIndex = memberTable.getSelectionModel().getSelectedIndex();
		memberTable.getItems().remove(selectedIndex);
		// TODO: handle errors
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewMember() {
		Member tempMem = new Member();
		boolean okClicked = mainApp.showMemberEditDialog(tempMem);
		if (okClicked) {
			mainApp.getMemberList().add(tempMem);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditMember() {
		Member selectedMem = memberTable.getSelectionModel().getSelectedItem();
		if (selectedMem != null) {
			boolean okClicked = mainApp.showMemberEditDialog(selectedMem);
			if (okClicked) {
				showMemberDetails(selectedMem);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Member Selected");
			alert.setContentText("Please select a Member in the table.");

			alert.showAndWait();
		}
	}
}
