import CommunicationSystemApp.*;
import org.omg.CORBA.*;
import java.io.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import java.util.Random;
import java.util.Scanner;

public class GameClient {

    public static void main(String[] args) {

		try {

    		// Initialize the ORB
			org.omg.CORBA.ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService");

			// Convert the string object reference to an object
			NamingContext rootCtx=NamingContextHelper.narrow(nameObj);
			NameComponent[] nc = new NameComponent[1];
			nc[0] = new NameComponent("Game", "Object");
			org.omg.CORBA.Object obj = rootCtx.resolve(nc);

			// Convert the object to the correct type
			NumberGuess gameref = NumberGuessHelper.narrow(obj);

                // Generates a random number which the user has to guess
			    Random random = new Random();
				int number = random.nextInt(100);
				int guess;
				int tries = 0;
				boolean win = false;

                // Allows the player to input a number between 1 and 100
                System.out.println("Guess a number between 1 and 100!");
				while(win == false) {
					Scanner input = new Scanner(System.in);
					guess = input.nextInt();
					// Counts the number of tries
					tries++;

                    // Tells the player if the guess was too low or too high
					if (guess == number)
					{
						win = true;
					}
					else if (guess < number)
					{
						System.out.println("Your guess is too low");
						System.out.println("Try again");
					}
					else if (guess > number)
					{
						System.out.println("Your guess is too high");
						System.out.println("Try again");
					}
				}
				// Informs the user when they guess the correct number and tells them how many tries it took
				System.out.println("Congratulations, you have won!");
				System.out.println("The secret number was " + number);
				System.out.println("It took you " + tries + " tries to guess the secret number");
			}

		catch (Exception e) {
		    System.err.println("Error E: "+e);
			e.printStackTrace(System.out);
		}
	}
}
