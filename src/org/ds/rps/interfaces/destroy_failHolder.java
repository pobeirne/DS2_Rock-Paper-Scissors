package org.ds.rps.interfaces;

/**
* org/ds/rps/interfaces/destroy_failHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

public final class destroy_failHolder implements org.omg.CORBA.portable.Streamable
{
  public org.ds.rps.interfaces.destroy_fail value = null;

  public destroy_failHolder ()
  {
  }

  public destroy_failHolder (org.ds.rps.interfaces.destroy_fail initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.ds.rps.interfaces.destroy_failHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.ds.rps.interfaces.destroy_failHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.ds.rps.interfaces.destroy_failHelper.type ();
  }

}
