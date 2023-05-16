import java.util.Random;

public enum Minerals {
	Iron("Iron", 70), Bronze("Bronze", 20), Silver("Silver", 7), Gold("Gold", 2), Diamond("Diamond", 1);

	private String displayName;
	private int randomRate;

	Minerals(String displayName, int randomRate) {
		this.displayName = displayName;
		this.randomRate = randomRate;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getRandomRate() {
		return randomRate;
	}

	public static Minerals getRandom() {
		Random random = new Random();
		int totalRates = 0;

		for (Minerals rank : values()) {
			totalRates += rank.getRandomRate();
		}

		int randomValue = random.nextInt(totalRates);
		int cumulativeRate = 0;

		for (Minerals rank : values()) {
			cumulativeRate += rank.getRandomRate();
			if (randomValue < cumulativeRate) {
				return rank;
			}
		}

		// In case of unexpected scenarios, return a default rank
		return Iron;
	}
}
