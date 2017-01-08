package controler;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.AudioInput;

import javax.sound.sampled.Mixer;

public class MainController implements Initializable {

	@FXML
	private Menu sourceOneInput, sourceTwoInput, sourceSelection;

	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert sourceOneInput != null : "fx:id=\"sourceOneInput\" was not injected: check your FXML file 'simple.fxml'.";
		assert sourceTwoInput != null : "fx:id=\"sourceTwoInput\" was not injected: check your FXML file 'simple.fxml'.";
		assert sourceSelection != null : "fx:id=\"sourceSelection\" was not injected: check your FXML file 'simple.fxml'.";
		// initialize your logic here: all @FXML variables will have been injected


	}

	@FXML
	private void populateMenu() {
		Map<Mixer.Info, Integer> map =  AudioInput.getAvailableDevicesForMenuSelection();
		sourceOneInput.getItems().remove(0, sourceOneInput.getItems().size());
		sourceTwoInput.getItems().remove(0, sourceTwoInput.getItems().size());
		for(Mixer.Info info : map.keySet()) {

			String temp = info.getName().replace("Port ", "");
			sourceOneInput.getItems().add(new MenuItem(temp));
			sourceTwoInput.getItems().add(new MenuItem(temp));
		}
	}

}
