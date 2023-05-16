import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RockSmasher extends Application {
	private static Player player = new Player();
	private static Stage game ;
	@Override
	public void start(Stage primaryStage) {
		// Create buttons
		setGame(primaryStage);
		homeScene(primaryStage);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static void homeScene(Stage primaryStage){
		Button bagButton = new Button("Bag");
		bagButton.setPrefSize(100, 70);
		Button enchantButton = new Button("Enchant");
		enchantButton.setPrefSize(100, 70);
		Button shopButton = new Button("Shop");
		shopButton.setPrefSize(100, 70);
		Button settingButton = new Button("Setting");
		settingButton.setPrefSize(100, 70);
		Button playButton = new Button("Play");
		playButton.setPrefSize(150, 100);
		bagButton.setOnAction(arg0 -> {
			player.getBag().Show();
		});
		playButton.setOnAction(arg0 -> {
			play(primaryStage);
		});

		// Create button containers
		HBox topContainer = new HBox(bagButton, enchantButton);
		topContainer.setPrefHeight(200);
		topContainer.setAlignment(Pos.BOTTOM_CENTER);
		topContainer.setSpacing(200);
		HBox bottomContainer = new HBox(shopButton, settingButton);
		bottomContainer.setPrefHeight(200);
		bottomContainer.setAlignment(Pos.CENTER);
		bottomContainer.setSpacing(200);
		VBox centerContainer = new VBox(playButton);
		centerContainer.setAlignment(Pos.CENTER);

		// Create layout
		BorderPane layout = new BorderPane();
		layout.setTop(topContainer);
		layout.setBottom(bottomContainer);
		layout.setCenter(centerContainer);

		// Create scene
		Scene scene = new Scene(layout, 1000, 700);

		// Set stage title
		primaryStage.setTitle("RockSmasher");

		// Set scene and show stage
		primaryStage.setScene(scene);
	}

	public static void play(Stage primaryStage) {
		Stages a = new Stages(1);
		a.Show(primaryStage);

	}

	public static Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static Stage getGame() {
		return game;
	}

	public void setGame(Stage game) {
		this.game = game;
	}

}
