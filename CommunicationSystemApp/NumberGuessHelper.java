package CommunicationSystemApp;


/**
* CommunicationSystemApp/NumberGuessHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Conal/Documents/Distributed Systems Project/Communication/CommunicationSystem.idl
* Saturday, 12 April 2014 21:10:40 o'clock BST
*/

abstract public class NumberGuessHelper
{
  private static String  _id = "IDL:CommunicationSystemApp/NumberGuess:1.0";

  public static void insert (org.omg.CORBA.Any a, CommunicationSystemApp.NumberGuess that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CommunicationSystemApp.NumberGuess extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CommunicationSystemApp.NumberGuessHelper.id (), "NumberGuess");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CommunicationSystemApp.NumberGuess read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_NumberGuessStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CommunicationSystemApp.NumberGuess value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CommunicationSystemApp.NumberGuess narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CommunicationSystemApp.NumberGuess)
      return (CommunicationSystemApp.NumberGuess)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CommunicationSystemApp._NumberGuessStub stub = new CommunicationSystemApp._NumberGuessStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CommunicationSystemApp.NumberGuess unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CommunicationSystemApp.NumberGuess)
      return (CommunicationSystemApp.NumberGuess)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CommunicationSystemApp._NumberGuessStub stub = new CommunicationSystemApp._NumberGuessStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
