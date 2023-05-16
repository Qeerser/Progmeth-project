
public class Reward implements BagItem {
	private Minerals Type;
	private int amount;

	public Reward(Minerals type, int amount) {
		Type = type;
		this.amount = amount;

	}

	public Minerals getType() {
		return Type;
	}

	public void setType(Minerals type) {
		Type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
