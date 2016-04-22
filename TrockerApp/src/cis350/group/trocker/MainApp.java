package cis350.group.trocker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import com.thoughtworks.xstream.XStream;

import cis350.group.trocker.model.Member;
import cis350.group.trocker.util.FileUtil;
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
			
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		showMemberOverview();
		
		File file = getMemberFilePath();
		if (file != null) {
			loadMemberDataFromFile(file);
		}
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

	public void showWaiverStatistics() {
		try {
			// Load the fxml file and create a new stage for the popup
			FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/WaiverStatistics.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Waiver Statistics");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the persons into the controller
			WaiverStatisticsController controller = loader.getController();
			controller.setMemberData(memberList);

			dialogStage.show();

		} catch (IOException e) {
			// Exception gets thrown if the fxml file could not be loaded
			e.printStackTrace();
		}
	}

	public File getMemberFilePath() {
		Preferences pref = Preferences.userNodeForPackage(MainApp.class);
		String filePath = pref.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	public void setMemberFilePath(File file) {
		Preferences pref = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			pref.put("filePath", file.getPath());

			primaryStage.setTitle("Trocker App - " + file.getName());
		} else {
			pref.remove("filePath");
			primaryStage.setTitle("Trocker App");
		}
	}

	public void loadMemberDataFromFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("member", Member.class);

		try {
			String xml = FileUtil.readFile(file);

			ArrayList<Member> mList = (ArrayList<Member>) xstream.fromXML(xml);

			memberList.clear();
			memberList.addAll(mList);

			setMemberFilePath(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveMemberDataToFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("member", Member.class);
		
		ArrayList<Member> mList = new ArrayList<>(memberList);
		
		String xml = xstream.toXML(mList);
		try {
			FileUtil.saveFile(xml, file);
			setMemberFilePath(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
