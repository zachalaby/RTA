package services;

import javafx.stage.Stage;
import controler.StageHand;
import model.AudioInput;

public class TheWizard {

	private static TheWizard instance = null;
	private static StageHand stageHand;
	private static AudioInput channel;


	public TheWizard() {}

	public static TheWizard getInstance() {
		if(instance == null) {
			instance = new TheWizard();
		}
		return instance;
	}

	public void start(Stage mainStage) {
		stageHand = new StageHand(mainStage);
	}

	public void stop() {

	}

	public void init() {
		channel = new AudioInput();
	}

	public void load() {}

	public void save() {}

	public StageHand getStageHand() {
		return stageHand;
	}

}
