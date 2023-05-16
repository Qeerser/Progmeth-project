
public class Pickaxe implements BagItem {
	private int damage;
	private int plus;
	
	
	
	public Pickaxe(int damage, int plus) {
		this.damage = (int) (damage*Math.pow(2, plus));
		this.plus = plus;
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = Math.max(damage, 0);
	}
	public int getPlus() {
		return plus;
	}
	public void setPlus(int plus) {
		this.plus = Math.max(plus, 0);
	}

	@Override
	public Object getType() {
		return this;
	}

	@Override
	public int getAmount() {
		
		return -1;
	}

	@Override
	public void setAmount(int i) {
		
	}
	
	
}
