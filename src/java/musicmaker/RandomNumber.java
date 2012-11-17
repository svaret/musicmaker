package musicmaker;

import java.util.Random;

class RandomNumber {

	public static int getRandomNumber(int maxtal) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(maxtal);
	}
}
