package org.ds.rps.interfaces;

/**
* org/ds/rps/interfaces/RPSHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:28 o'clock IST
*/


//RPS values
public final class RPSHolder implements org.omg.CORBA.portable.Streamable
{
  public org.ds.rps.interfaces.RPS value = null;

  public RPSHolder ()
  {
  }

  public RPSHolder (org.ds.rps.interfaces.RPS initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.ds.rps.interfaces.RPSHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.ds.rps.interfaces.RPSHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.ds.rps.interfaces.RPSHelper.type ();
  }

}
