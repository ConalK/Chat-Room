package CommunicationSystemApp;

/**
* CommunicationSystemApp/NumberGuessHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Conal/Documents/Distributed Systems Project/Communication/CommunicationSystem.idl
* Saturday, 12 April 2014 21:10:40 o'clock BST
*/

public final class NumberGuessHolder implements org.omg.CORBA.portable.Streamable
{
  public CommunicationSystemApp.NumberGuess value = null;

  public NumberGuessHolder ()
  {
  }

  public NumberGuessHolder (CommunicationSystemApp.NumberGuess initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CommunicationSystemApp.NumberGuessHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CommunicationSystemApp.NumberGuessHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CommunicationSystemApp.NumberGuessHelper.type ();
  }

}
