package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


public class StartController implements Initializable {

	@FXML
	private Button firstButton;

	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert firstButton != null : "fx:id=\"firstButton\" was not injected: check your FXML file 'simple.fxml'.";

		// initialize your logic here: all @FXML variables will have been injected

	}


	@FXML
	private void doAFunction(ActionEvent e) {

		services.TheWizard.getInstance().getStageHand().setCurrentSceneToMainScreen();

	}


}




