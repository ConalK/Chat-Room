package CommunicationSystemApp;


/**
* CommunicationSystemApp/AddressBook.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Conal/Documents/Distributed Systems Project/Communication/CommunicationSystem.idl
* Saturday, 12 April 2014 21:10:40 o'clock BST
*/

public final class AddressBook implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public String homePhone = null;
  public String mobilePhone = null;
  public String address = null;
  public String email = null;

  public AddressBook ()
  {
  } // ctor

  public AddressBook (String _name, String _homePhone, String _mobilePhone, String _address, String _email)
  {
    name = _name;
    homePhone = _homePhone;
    mobilePhone = _mobilePhone;
    address = _address;
    email = _email;
  } // ctor

} // class AddressBook