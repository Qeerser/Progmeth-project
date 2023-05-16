import java.util.ArrayList;

public class Player {
	private Pickaxe weapon;
	private Bag bag = new Bag();
	
	public Player() {
		super();
		this.weapon = new Pickaxe(10, 9);
		bag.addItem(weapon);
	}
	public Pickaxe getWeapon() {
		return weapon;
	}
	public void setWeapon(Pickaxe weapon) {
		this.weapon = weapon;
	}
	
	public Bag getBag() {
		return bag;
	}
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	
	
	
	
	
}
