package org.ds.rps.interfaces;

/**
* org/ds/rps/interfaces/create_failHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

public final class create_failHolder implements org.omg.CORBA.portable.Streamable
{
  public org.ds.rps.interfaces.create_fail value = null;

  public create_failHolder ()
  {
  }

  public create_failHolder (org.ds.rps.interfaces.create_fail initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.ds.rps.interfaces.create_failHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.ds.rps.interfaces.create_failHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.ds.rps.interfaces.create_failHelper.type ();
  }

}