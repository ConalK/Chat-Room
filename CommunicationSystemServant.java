import java.io.*;
import java.util.*;
import CommunicationSystemApp.*;
import org.omg.CORBA.*;

// Servant inherits the generated code
public class CommunicationSystemServant implements CommunicationOperations {

	// Create ORB object
	public static ORB orb;
	public CommunicationSystemServant (org.omg.CORBA.ORB orb){
		this.orb=orb;
    }

    // Address book code here
	// Create new hashtable
	public static Hashtable ht = new Hashtable();

	// Add new user
	public void newUser(CommunicationSystemApp.AddressBook newDetails) {

		// Add user details to hash table
	    ht.put(newDetails.name, newDetails);
	}

	// Retrieve details from hash table
	public void getUser(String name, AnyHolder newDetails) {
	    Any User = orb.create_any();
		AddressBook Details = (AddressBook)ht.get(name);
		AddressBookHelper.insert(User, Details);
		newDetails.value = User;
	}

    // Chat room code here
    // Attributes
	Member[] users;
	String[] names;
	int members;

	// Methods
	CommunicationSystemServant() {
		users = new Member[10];
		names = new String[10];
		members = 0;
	}

    // Allows a new user to join the chat room
	public void joinRoom(Member member, String name) {
		users[members] = member;
		names[members] = name;

    // Displays that the user has entered the chat room to other members
		members++ ;
		member.callBack("Thank you for registering " + name + "\nYou can now chat to other members \nTo exit the chat room type quit");
		System.out.println(name + " has entered the chatroom");
	}

    // Allows the user to send messages in the chat room
	public void chatRoom(String chat, String name) {
		System.out.println(name + " said: " + chat);
		String messages = name + ": " + chat;
		for (int i=0; i<members; i++) {
			users[i].callBack(messages);
		}
	}
}





