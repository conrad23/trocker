package cis350.group.trocker.view;



import java.io.File;

import cis350.group.trocker.MainApp;
import javafx.fxml.FXML;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.stage.FileChooser;
import javafx.stage.Stage;

	/**
	 * The controller for the root layout. The root layout provides the basic
	 * application layout containing a menu bar and space where other JavaFX
	 * elements can be placed.
	 * 
	 */
	public class RootLayoutController {

	    // Reference to the main application
	    private MainApp mainApp;
	    private Stage s;
	    /**
	     * Is called by the main application to give a reference back to itself.
	     * 
	     * @param mainApp
	     */
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;
	    }

	    /**
	     * Creates an empty.
	     */
	    @FXML
	    private void handleNew() {
	        mainApp.clearMemberList();
	        mainApp.setMemberFilePath(null);
	    }

	    /**
	     * Opens a FileChooser to let the user select to load.
	     */
	    @FXML
	    private void handleOpen() {
	        FileChooser fileChooser = new FileChooser();
	        
	        // Set extension filter
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                "XML files (*.xml)", "*.xml");
	        fileChooser.getExtensionFilters().add(extFilter);

	        // Show save file dialog
	        File file = fileChooser.showOpenDialog(s);
	        
	        if (file != null) {
	            mainApp.loadMemberListFromFile(file);
	        }
	    }

	    /**
	     * Saves the file to the person file that is currently open. If there is no
	     * open file, the "save as" dialog is shown.
	     */
	    @FXML
	    private void handleSave() {
	        File memFile = mainApp.getMemberFilePath();
	        if (memFile != null) {
	            mainApp.saveMemberDataToFile(memFile);
	        } else {
	            handleSaveAs();
	        }
	    }

	    /**
	     * Opens a FileChooser to let the user select a file to save to.
	     */
	    @FXML
	    private void handleSaveAs() {
	        FileChooser fileChooser = new FileChooser();

	        // Set extension filter
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                "XML files (*.xml)", "*.xml");
	        fileChooser.getExtensionFilters().add(extFilter);

	        // Show save file dialog
	        File file = fileChooser.showSaveDialog(s);

	        if (file != null) {
	            // Make sure it has the correct extension
	            if (!file.getPath().endsWith(".xml")) {
	                file = new File(file.getPath() + ".xml");
	            }
	            mainApp.saveMemberDataToFile(file);
	        }
	    }

	    /**
	     * Opens an about dialog.
	     */
	    @FXML
	    private void handleAbout() {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Trocker");
	        alert.setHeaderText("About");
	        alert.setContentText("Author: These guys 8-)");

	        alert.showAndWait();
	    }

	    /**
	     * Closes the application.
	     */
	    @FXML
	    private void handleExit() {
	        System.exit(0);
	    }
	}

