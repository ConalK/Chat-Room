import CommunicationSystemApp.*;
import org.omg.CORBA.*;
import java.io.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class CommunicationSystemClient {

    public static void main(String args[]) {

        try {

            // Initialize the ORB
            org.omg.CORBA.ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService");

            // Instantiate the Member implementation
            Member member = new Member_Tie(new MemberImpl());

            // Convert the string object reference to an object
            NamingContext rootCtx=NamingContextHelper.narrow(nameObj);
			NameComponent[] nc = new NameComponent[1];
			nc[0] = new NameComponent("AddressBook", "Object");
			nc[0] = new NameComponent("ChatRoom", "Object");
			org.omg.CORBA.Object obj = rootCtx.resolve(nc);

            // Convert the object to the correct type
            Communication commsystemref = CommunicationHelper.narrow(obj);
            AddressBook newDetails = new AddressBook();

            // Create new holder for Any object
            AnyHolder ah = new AnyHolder();

			BufferedReader userEntry = new BufferedReader(new InputStreamReader(System.in));
			char menuChoice;

            do {

				// Display the menu to the user
	            System.out.println("Welcome to the communication system. Please choose an option below.");
				System.out.println("1 Address book");
				System.out.println("2 Chat room");
				System.out.println("3 Number guessing game");
				System.out.println("4 Quit");
	            menuChoice = (char)(System.in.read());
			    userEntry.readLine();

                    if (menuChoice==(char)'1') {

						System.out.println("Welcome to the address book. Please choose an option below.");
						System.out.println("1 Enter new details to address book");
				        System.out.println("2 Retrieve details from address book");
				        System.out.println("3 Go back");
						menuChoice = (char)(System.in.read());
			            userEntry.readLine();

			                if (menuChoice==(char)'1') {

                                // Allow new user to enter details
			                    System.out.println("Enter a name");
						        newDetails.name=userEntry.readLine();
					        	System.out.println("Enter a home phone number");
					            newDetails.homePhone = userEntry.readLine();
					            System.out.println("Enter a mobile phone number");
					            newDetails.mobilePhone = userEntry.readLine();
						        System.out.println("Enter an address");
						        newDetails.address = userEntry.readLine();
						        System.out.println("Enter an email");
						        newDetails.email = userEntry.readLine();

						        // Add entered details to hash table
			                    commsystemref.newUser(newDetails);

						    }
			                else if (menuChoice==(char)'2') {

								// Query user for the name
								System.out.println("Enter the persons name to see their details");
								String tempName = userEntry.readLine();
							    commsystemref.getUser(tempName, ah);
								AddressBook Details = new AddressBook();
								Details = AddressBookHelper.extract(ah.value);

								// Check if the entered name matches the stored name
								TypeCode tc = ah.value.type();
								if(AddressBookHelper.type().equal(tc)){
							    System.out.println("Name: "+Details.name);
								System.out.println("Home phone number: "+Details.homePhone);
								System.out.println("Mobile phone number: "+Details.mobilePhone);
								System.out.println("Address: "+Details.address);
								System.out.println("email: "+Details.email);
							    }
								// Informs the user if there's no record of the entered name
			                    else System.out.println("No record of that name");
							}
			        }
					else if (menuChoice==(char)'2') {

                        // Allow user to enter the name they want to register with
			            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			            System.out.println("Enter your name to join the chatroom");
						String CustomerName=br.readLine();
						commsystemref.joinRoom(member, CustomerName);

						// Allow user to input messages to send to other users
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String message = "";
						do {
						    message = br1.readLine();
							commsystemref.chatRoom(message, CustomerName);
			            } while (!message.equals("quit"));
					}
					else if (menuChoice==(char)'3') {

						// Starts the number guessing game from the GameClient file
						GameClient game=new GameClient();
			            game.main(null);
					}



            // Quit program
			} while (menuChoice != (char)'4');

        }
        catch (Exception e) {
	        System.err.println("Error E: "+e);
	        e.printStackTrace(System.out);
		}
	}
}
