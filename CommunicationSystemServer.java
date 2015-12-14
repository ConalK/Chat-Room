import CommunicationSystemApp.*;
import org.omg.CORBA.*;
import java.io.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class CommunicationSystemServer {

    public static void main(String args[]) {

	    try {

	    	// Initialize the ORB
	    	org.omg.CORBA.ORB orb = ORB.init(args, null);

	    	// Instantiate the CommunicationSystemServant and GameServant on the server
			Communication ChatRoom = new Communication_Tie(new CommunicationSystemServant());
			Communication AddressBook = new Communication_Tie(new CommunicationSystemServant(orb));
            NumberGuess Game = new NumberGuess_Tie(new GameServant());

			// Connect the CommunicationSystemServant to the ORB
			orb.connect(ChatRoom);
			orb.connect(AddressBook);
			orb.connect(Game);
	   		System.out.println("Orb connected.");

	   		// Locate the naming service
		    org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService");
			System.out.println("Found a NameService.");

			// Convert reference into a NamingContext reference
			NamingContext rootCtx=NamingContextHelper.narrow(nameObj);

			// Create new NameComponents for AddressBook and ChatRoom
			NameComponent[] nc = new NameComponent[1];
			nc[0] = new NameComponent("ChatRoom", "Object");
			rootCtx.rebind(nc, ChatRoom);
			nc[0] = new NameComponent("AddressBook", "Object");
			rootCtx.rebind(nc, AddressBook);
			nc[0] = new NameComponent("Game", "Object");
			rootCtx.rebind(nc, Game);

            // Run the ORB
			System.out.println("The services are now ready for use");
			orb.run();

		}
		catch (Exception e) {
	        System.err.println("ERROR: " + e);
	    	e.printStackTrace(System.out);
		}
    }
}
