package org.ds.rps.interfaces;


/**
* org/ds/rps/interfaces/Player.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

public final class Player implements org.omg.CORBA.portable.IDLEntity
{
  public String id = null;
  public String name = null;
  public int score = (int)0;
  public org.ds.rps.interfaces.RPS choice = null;
  public boolean isReady = false;
  public org.ds.rps.interfaces.CallBack callback = null;

  public Player ()
  {
  } // ctor

  public Player (String _id, String _name, int _score, org.ds.rps.interfaces.RPS _choice, boolean _isReady, org.ds.rps.interfaces.CallBack _callback)
  {
    id = _id;
    name = _name;
    score = _score;
    choice = _choice;
    isReady = _isReady;
    callback = _callback;
  } // ctor

} // class Player