package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main extends Application {

    // sample player data
    private String playerName = "Player 1";
    private int playerHealth = 100;
    private int playerLevel = 1;
    private int playerXP = 0;

    @Override
    public void start(Stage stage) {
        // create a VBox to hold the player information
//        VBox playerBox = new VBox();
//        playerBox.setSpacing(10);
//
//        // add the player information as Labels to the VBox
//        Label nameLabel = new Label("Name: " + playerName);
//        Label healthLabel = new Label("Health: " + playerHealth);
//        Label levelLabel = new Label("Level: " + playerLevel);
//        Label xpLabel = new Label("XP: " + playerXP);
//        playerBox.getChildren().addAll(nameLabel, healthLabel, levelLabel, xpLabel);
//
//        // create a Scene with the VBox as its root node
//        Scene scene = new Scene(playerBox, 400, 300);
    	VBox layout = new VBox();
		layout.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		HBox WallPaper = new HBox();
		WallPaper.setPrefHeight(300);
		WallPaper.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		HBox field = new HBox();
		field.setPrefHeight(300);
		field.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		HBox actionBar = new HBox();
		actionBar.setPrefHeight(100);
		actionBar.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		
		layout.getChildren().addAll(WallPaper,field,actionBar);
		
		Scene scene = new Scene(layout, 1080,700 );
        // set the Scene on the Stage and show it
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}