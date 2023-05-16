package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RPGGame extends Application {

    // sample player data
    private String playerName = "Player 1";
    private int playerHealth = 100;
    private int playerLevel = 1;
    private int playerXP = 0;
	private Label healthLabel;

    @Override
    public void start(Stage stage) {
        // create a VBox to hold the player information
    	
        VBox playerBox = new VBox();
        playerBox.setPadding(new Insets(20));
        playerBox.setAlignment(Pos.TOP_CENTER);
        playerBox.setSpacing(20);
        playerBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        playerBox.setPrefSize(150, 450);
        
        Button move1Button = new Button("move 1");
        move1Button.setPrefSize(80,30);
        Button move2Button = new Button("move 2");
        move2Button.setPrefSize(80,30);
        Button move3Button = new Button("move 3");
        move3Button.setPrefSize(80,30);
        Button move4Button = new Button("move 4");
        move1Button.setOnAction(e -> playerTurn(1));
	    move2Button.setOnAction(e -> playerTurn(2));
	    move3Button.setOnAction(e -> playerTurn(3));
	    move4Button.setOnAction(e -> playerTurn(4));
	    
        move4Button.setPrefSize(80,30);
        TilePane skillBar = new TilePane();
        skillBar.setHgap(15);
        skillBar.setVgap(10);
        skillBar.setPadding(new Insets(10));
        skillBar.setPrefSize(200,95);
        skillBar.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        skillBar.getChildren().addAll(move1Button,move2Button,move3Button,move4Button);
        
        HBox skillCast = new HBox();
        skillCast.setPadding(new Insets(10));
        skillCast.setAlignment(Pos.CENTER_RIGHT);
        skillCast.setSpacing(20);
        skillCast.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
	    skillCast.setPrefSize(800, 100);      
	    skillCast.getChildren().add(skillBar);
        
        // add the player information as Labels to the VBox
        Label nameLabel = new Label("Name: " + playerName);
        nameLabel.setFont(new Font(10));
        healthLabel = new Label("Health: " + playerHealth);
        Label levelLabel = new Label("Level: " + playerLevel);
        Label xpLabel = new Label("XP: " + playerXP);
        playerBox.getChildren().addAll(nameLabel, healthLabel, levelLabel, xpLabel);
        
        BorderPane window = new BorderPane();
        window.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    	window.setLeft(playerBox);
    	window.setBottom(skillCast);
    	
        // create a Scene with the VBox as its root node
        Scene scene = new Scene(window, 800, 450);

        // set the Scene on the Stage and show it
    
        stage.setScene(scene);
        stage.show();
    }
    public void playerTurn(int i) {
    	this.playerHealth -= i;
    	healthLabel.setText("" + playerHealth);
    }
    
    public static void main(String[] args) {
        launch();
    }
}
