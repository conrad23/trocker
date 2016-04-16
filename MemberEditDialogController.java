package cis350.group.trocker.view;

import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import cis350.group.trocker.model.Member;

/**
 * Dialog to edit details of a person.
 *
 */
public class MemberEditDialogController {

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField gNumField;
	@FXML
	private TextField phoneNumField;
	@FXML
	private TextField waiverField;
	@FXML
	private TextField expField;

	private Stage dialogStage;
	private Member mem;
	private boolean okClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the person to be edited in the dialog.
	 * 
	 * @param person
	 */
	public void setMember(Member mem) {
		this.mem = mem;

		firstNameField.setText(mem.getFirstName());
		lastNameField.setText(mem.getLastName());
		gNumField.setText(mem.getgNumber());
		phoneNumField.setText(mem.getPhoneNumber());
		waiverField.setText(mem.isWaiver());
		expField.setText(mem.getExperience());
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			mem.setFirstName(firstNameField.getText());
			mem.setLastName(lastNameField.getText());
			mem.setgNumber(gNumField.getText());
			mem.setPhoneNumber(phoneNumField.getText());
			mem.setWaiver(waiverField.getText());
			mem.setExperience(expField.getText());

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (gNumField.getText() == null || gNumField.getText().length() == 0) {
			errorMessage += "No g Number!\n";
		}

		if (phoneNumField.getText() == null || phoneNumField.getText().length() == 0) {
			errorMessage += "No valid phone!\n";
		}

		if (waiverField.getText() == null || waiverField.getText().length() == 0) {
			errorMessage += "waiver?\n";
		}

		if (expField.getText() == null || expField.getText().length() == 0) {
			errorMessage += "experience?\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.initOwner(dialogStage);
//			alert.setTitle("Invalid Fields");
//			alert.setHeaderText("Please correct invalid fields");
//			alert.setContentText(errorMessage);
//
//			alert.showAndWait();
//
			return false;
		}
	}
}