package org.ds.rps.interfaces;

/**
* org/ds/rps/interfaces/unknown_playerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

public final class unknown_playerHolder implements org.omg.CORBA.portable.Streamable
{
  public org.ds.rps.interfaces.unknown_player value = null;

  public unknown_playerHolder ()
  {
  }

  public unknown_playerHolder (org.ds.rps.interfaces.unknown_player initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.ds.rps.interfaces.unknown_playerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.ds.rps.interfaces.unknown_playerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.ds.rps.interfaces.unknown_playerHelper.type ();
  }

}