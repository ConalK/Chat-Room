package CommunicationSystemApp;

/**
* CommunicationSystemApp/MemberHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Conal/Documents/Distributed Systems Project/Communication/CommunicationSystem.idl
* Saturday, 12 April 2014 21:10:40 o'clock BST
*/


// Declare the interfaces
public final class MemberHolder implements org.omg.CORBA.portable.Streamable
{
  public CommunicationSystemApp.Member value = null;

  public MemberHolder ()
  {
  }

  public MemberHolder (CommunicationSystemApp.Member initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CommunicationSystemApp.MemberHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CommunicationSystemApp.MemberHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CommunicationSystemApp.MemberHelper.type ();
  }

}
