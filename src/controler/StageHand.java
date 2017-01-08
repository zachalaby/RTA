package controler;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Screen;

import java.util.HashMap;
import java.util.Map;

public class StageHand {

	private Map<Screen, Scene> scenes = new HashMap<>();
	private Scene currentScene;
	private Stage mainStage;

	public StageHand(Stage mainStage) {
		this.loadScenesFromScreenFxmls();
		this.setupStage(mainStage);
		this.setCurrentSceneToStartScreen();
		this.setStageWithScene(this.currentScene);
		this.showStage();
	}

	private void setScene(Scene scene) {
		this.currentScene = scene;
	}

	private void loadScenesFromScreenFxmls() {
		for(Screen screen : Screen.values()) {
			scenes.put(screen, new Scene(screen.getFxml()));
		}
	}

	public void setCurrentSceneToStartScreen() {
		this.setScene(scenes.get(Screen.START));
		this.setStageWithScene(this.currentScene);
	}

	public void setCurrentSceneToMainScreen() {
		this.setScene(scenes.get(Screen.MAIN));
		this.setStageWithScene(this.currentScene);
	}

	private void setupStage(Stage mainStage) {
		this.mainStage = mainStage;
		this.mainStage.setTitle("plugin name");
	}

	private void showStage() {
		this.mainStage.show();
	}

	private void setStageWithScene(Scene scene) {
		this.mainStage.setScene(scene);
	}

}