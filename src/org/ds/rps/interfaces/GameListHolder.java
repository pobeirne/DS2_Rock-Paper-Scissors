package org.ds.rps.interfaces;


/**
* org/ds/rps/interfaces/GameListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/


//Array of games
public final class GameListHolder implements org.omg.CORBA.portable.Streamable
{
  public org.ds.rps.interfaces.Game value[] = null;

  public GameListHolder ()
  {
  }

  public GameListHolder (org.ds.rps.interfaces.Game[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.ds.rps.interfaces.GameListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.ds.rps.interfaces.GameListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.ds.rps.interfaces.GameListHelper.type ();
  }

}
