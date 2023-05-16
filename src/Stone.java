import java.util.ArrayList;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Stone {
	private int MaxHp;
	private int Hp;
	private int lvl;
	private StackPane R;
	private Reward item;

	public Stone(int lvl) {
		super();
		item = new Reward(Minerals.getRandom(), 1);
		Hp = (int) (10 * Math.pow(5, lvl) * (1 + Math.random()));
		MaxHp = Hp;
//		Hp = 10*(2^lvl) ;
		this.lvl = lvl;

		StackPane n = new StackPane();
		n.getChildren().addAll(new Rectangle(50, 60, Color.RED));
		setR(n);
	}

	public void Damage() {
		this.setHp(Hp - RockSmasher.getPlayer().getWeapon().getDamage());
	}

	public int getHp() {
		return Hp;
	}

	public void setHp(int hp) {
		Hp = Math.max(hp, 0);
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public StackPane getR() {
		return R;
	}

	public void setR(StackPane r) {
		R = r;
	}

	public int getMaxHp() {
		return MaxHp;
	}

	public Reward getItem() {
		return item;
	}

}
