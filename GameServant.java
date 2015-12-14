import CommunicationSystemApp.*;
import java.util.Random;
import java.util.Scanner;

public class GameServant implements NumberGuessOperations {

	// Attributes
	int number;
	int tries = 0;
	int guess;

	// Methods
	// Generates a random number which the user has to guess
	public int getNumber() {
		Random random = new Random();
		int number = random.nextInt(100);
		return number;
	}

    // Allows the user to input numbers and tells them if it's too low or too high
    public double guess(double num) {
        if (guess == number) {
	    }
		else if (guess < number)
	    {
		    System.out.println("Your guess is too low");
	    }
		else if (guess > number)
	    {
		    System.out.println("Your guess is too high");
        }
        return guess;
	}
}
