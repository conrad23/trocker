package cis350.group.trocker;

import java.io.IOException;

import cis350.group.trocker.model.Member;
import cis350.group.trocker.view.MemberEditDialogController;
import javafx.application.Application;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Member> memberList = FXCollections.observableArrayList();

	public MainApp() {

		memberList.add(new Member("John", "Doe", "12345678", "269-555-5555", "Yes", "Intermediate"));
		memberList.add(new Member("Jane", "Doe", "99999999", "555-555-5555", "No", "Expert"));
	}

	public ObservableList<Member> getMemberList() {
		return memberList;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Trocker - the GVSU rock climbing tracker");

		try {
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		showMemberOverview();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void showMemberOverview() {
		try {
			// Load the fxml file and set into the center of the main layout
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/MemberView.fxml"));
			AnchorPane overviewPage = (AnchorPane) loader.load();
			rootLayout.setCenter(overviewPage);

			// Give the controller access to the main app
			MemberController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			// Exception gets thrown if the fxml file could not be loaded
			e.printStackTrace();
		}
	}

	public boolean showMemberEditDialog(Member mem) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MemberEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Member");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MemberEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMember(mem);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
