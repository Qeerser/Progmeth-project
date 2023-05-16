import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Stages {
	private int number;
	private ArrayList<Stone> Stones = new ArrayList<>();
	private ArrayList<VBox> Enemys = new ArrayList<>();
	private ArrayList<Reward> items = new ArrayList<>();
	private int kill;
	

	public Stages(int number) {

		this.number = number;
		for (int i = 0; i < ((((number % 10) - 1) / 3) + 1) * 3; i++) {
			Stones.add(new Stone((number / 10) + 1));
		}
	}

	public void Show(Stage primaryStage) {
		VBox layout = new VBox();
		layout.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		HBox WallPaper = new HBox();
		WallPaper.setPrefHeight(275);
		WallPaper.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

		BorderPane field = new BorderPane();
		field.setPrefHeight(300);
		field.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		field.setPadding(new Insets(50, 60, 30, 150));

		HBox actionBar = new HBox();
		actionBar.setPrefHeight(125);
		actionBar.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		HBox rewardList = new HBox();
		rewardList.setPrefWidth(400);
		rewardList.setAlignment(Pos.CENTER_LEFT);
		rewardList.getChildren().add(new Text("All Reward"));
		rewardList.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
		actionBar.getChildren().add(rewardList);
		Rectangle greenBox = new Rectangle(100, 200, Color.GREEN);
		GridPane monster = new GridPane();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				VBox enemy = new VBox();
				enemy.setAlignment(Pos.BOTTOM_CENTER);
				enemy.getChildren().add(new Rectangle(50, 40, Color.RED));
				monster.add(enemy, i, j);
				Enemys.add(enemy);
			}
		}

		for (int i = 0; i < Math.min(Stones.size(), 9); i++) {
			int a = i;
			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Stones.get(a).Damage();
					((Text) Enemys.get(a).getChildren().get(1))
							.setText(Stones.get(a).getHp() + " / " + Stones.get(a).getMaxHp());
					if (Stones.get(a).getHp() == 0) {
						Enemys.get(a).setVisible(false);

						boolean has_i = false;
						for (Reward i : items) {
							if (Stones.get(a).getItem().getType().equals(i.getType())) {
								i.setAmount(i.getAmount() + Stones.get(a).getItem().getAmount());
								has_i = true;
							}
						}
						if (!has_i)
							items.add(Stones.get(a).getItem());
						ArrayList<BagItem> C = RockSmasher.getPlayer().getBag().getAllItem();
						has_i = false;
						for (BagItem i : RockSmasher.getPlayer().getBag().getAllItem()) {
							if (Stones.get(a).getItem().getType().equals(i.getType())) {
								i.setAmount(i.getAmount() + Stones.get(a).getItem().getAmount());
								has_i = true;
							}
						}
						if (!has_i)
							C.add(Stones.get(a).getItem());
						System.out.println(items);
						rewardList.getChildren().clear();
						rewardList.getChildren().add(new Text("All Reward"));
						for (Reward i : items) {
							VBox item = new VBox();
							item.setAlignment(Pos.CENTER);
							item.getChildren().add(new Rectangle(50, 40, Color.RED));
							item.getChildren().add(new Text(i.getType() + ""));
							item.getChildren().add(new Text(i.getAmount() + ""));
							rewardList.getChildren().add(item);
						}
						kill++;
						if (kill == Stones.size())
							clear(primaryStage);
					}

				}
			};
			Enemys.get(i).getChildren().get(0).addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			Enemys.get(i).getChildren().addAll(new Text(Stones.get(i).getHp() + " / " + Stones.get(i).getMaxHp()));
		}

		monster.setHgap(10);
		monster.setVgap(10);
		field.setLeft(greenBox);
		field.setRight(monster);

		layout.getChildren().addAll(WallPaper, field, actionBar);

		Scene scene = new Scene(layout, 1080, 700);

		// set the Scene on the Stage and show it

		primaryStage.setScene(scene);
	}

	private void clear(Stage primaryStage) {

		VBox layout = new VBox();
		HBox name = new HBox(new Text("Victory"));
		name.setAlignment(Pos.CENTER);
		Button home = new Button("Home");
		home.setOnAction(arg0 -> {
			RockSmasher.homeScene(primaryStage);
		});
		HBox action = new HBox(home, new Button("Next Stage"));
		action.setAlignment(Pos.CENTER);
		name.setPrefHeight(200);
		HBox rewardList = new HBox();
		rewardList.setPrefHeight(300);
		rewardList.setAlignment(Pos.CENTER);
		rewardList.getChildren().add(new Text("All Reward"));
		rewardList.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
		layout.getChildren().addAll(name, rewardList, action);

		for (Reward i : items) {
			VBox item = new VBox();
			item.setAlignment(Pos.CENTER);
			item.getChildren().add(new Rectangle(50, 40, Color.RED));
			item.getChildren().add(new Text(i.getType() + ""));
			item.getChildren().add(new Text(i.getAmount() + ""));
			rewardList.getChildren().add(item);
		}
		// set the Scene on the Stage and show it
		primaryStage.setScene(new Scene(layout, 1080, 700));

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<VBox> getEnemys() {
		return Enemys;
	}

	public void setEnemys(ArrayList<VBox> enemys) {
		Enemys = enemys;
	}

	public ArrayList<Reward> getItems() {
		return items;
	}

	public int getKill() {
		return kill;
	}

	public void setKill(int kill) {
		this.kill = kill;
	}


}
