import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Bag {
	private ArrayList<BagItem> allItem = new ArrayList<>();
	private ArrayList<StackPane> itemSlot = new ArrayList<>();
	

	
	
	public void Show() {
		
		HBox layout = new HBox();
		
		VBox PlayerStatus = new VBox();
		PlayerStatus.setPrefWidth(400);
		PlayerStatus.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		GridPane bagSlot = new GridPane();
		bagSlot.setAlignment(Pos.CENTER);
		bagSlot.setVgap(10);
		bagSlot.setHgap(10);
		bagSlot.setPrefWidth(600);
		bagSlot.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		layout.getChildren().addAll(PlayerStatus,bagSlot);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j <8; j++) {
				StackPane show = new StackPane();
				show.setAlignment(Pos.CENTER);
				show.getChildren().add(new Rectangle(50, 50, Color.RED));
				bagSlot.add(show, i, j);
				itemSlot.add(show);
			}
		}
		for (int i = 0; i < allItem.size(); i++) {
			itemSlot.get(i).getChildren().add(new Text("" + allItem.get(i).getClass()));
		}
		
		Scene scene = new Scene(layout, 1000, 700);

		// set the Scene on the Stage and show it

		RockSmasher.getGame().setScene(scene);
	}




	public ArrayList<BagItem> getAllItem() {
		return allItem;
	}




	public void setAllItem(ArrayList<BagItem> allItem) {
		this.allItem = allItem;
	}
	
	public void addItem(BagItem Item) {
		this.allItem.add(Item);
	}
}

	