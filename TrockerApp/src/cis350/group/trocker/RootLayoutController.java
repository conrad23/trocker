package cis350.group.trocker;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.stage.FileChooser;

public class RootLayoutController {

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML Files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			mainApp.loadMemberDataFromFile(file);
		}
	}

	@FXML
	private void handleSave() {
		File memberFile = mainApp.getMemberFilePath();
		if (memberFile != null) {
			mainApp.saveMemberDataToFile(memberFile);
		} else {
			handleSaveAs();
		}
	}

	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.saveMemberDataToFile(file);
		}
	}

	@FXML
	private void handleShowWaiverStatistics() {
		mainApp.showWaiverStatistics();
	}
}
