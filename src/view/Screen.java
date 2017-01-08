package view;

import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public enum Screen {
	MAIN ("Main.fxml"),
	START ("Start.fxml");


	private final String filePath;
	private final String rootDirectory = "Screens/";
	private Parent fxml = null;


	Screen(String fileName) {
		this.filePath = this.rootDirectory + fileName;
		try {
			this.fxml = FXMLLoader.load(getClass().getResource(this.filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public Parent getFxml() {
		return this.fxml;
	}

	public String getFilePath() {
		return this.filePath;
	}
}
