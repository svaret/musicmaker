package musicmaker;

import java.util.Random;

class RandomNumber {

	public static int getRandomNumber(int upperBound) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(upperBound);
	}
}
