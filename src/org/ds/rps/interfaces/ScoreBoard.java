package org.ds.rps.interfaces;


/**
* org/ds/rps/interfaces/ScoreBoard.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

public final class ScoreBoard implements org.omg.CORBA.portable.IDLEntity
{
  public org.ds.rps.interfaces.Player players[] = null;
  public org.ds.rps.interfaces.Game games[] = null;

  public ScoreBoard ()
  {
  } // ctor

  public ScoreBoard (org.ds.rps.interfaces.Player[] _players, org.ds.rps.interfaces.Game[] _games)
  {
    players = _players;
    games = _games;
  } // ctor

} // class ScoreBoard
