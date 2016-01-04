package org.ds.rps.interfaces;


/**
* org/ds/rps/interfaces/GameInterface_Tie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

public class GameInterface_Tie extends _GameInterfaceImplBase
{

  // Constructors
  public GameInterface_Tie ()
  {
  }

  public GameInterface_Tie (org.ds.rps.interfaces.GameInterfaceOperations impl)
  {
    super ();
    _impl = impl;
  }


  //Player methods
  public String subscribe (String player_name, org.ds.rps.interfaces.CallBack callback) throws org.ds.rps.interfaces.create_fail
  {
    return _impl.subscribe(player_name, callback);
  } // subscribe

  public boolean unsubscribe (String player_id) throws org.ds.rps.interfaces.unknown_player, org.ds.rps.interfaces.destroy_fail
  {
    return _impl.unsubscribe(player_id);
  } // unsubscribe

  public String getPlayerNameById (String player_id) throws org.ds.rps.interfaces.unknown_player
  {
    return _impl.getPlayerNameById(player_id);
  } // getPlayerNameById


  //Game methods
  public boolean hasOpenSlot ()
  {
    return _impl.hasOpenSlot();
  } // hasOpenSlot

  public boolean isValidPlayer (String player_id) throws org.ds.rps.interfaces.unknown_player
  {
    return _impl.isValidPlayer(player_id);
  } // isValidPlayer

  public boolean setPlayerIsReady (String player_id, boolean ready) throws org.ds.rps.interfaces.unknown_player
  {
    return _impl.setPlayerIsReady(player_id, ready);
  } // setPlayerIsReady

  public boolean checkIfPlayersAreReadyToStart ()
  {
    return _impl.checkIfPlayersAreReadyToStart();
  } // checkIfPlayersAreReadyToStart

  public boolean setPlayerSelection (String player_id, int choice) throws org.ds.rps.interfaces.unknown_player
  {
    return _impl.setPlayerSelection(player_id, choice);
  } // setPlayerSelection

  public boolean checkIfPlayersHaveSelected ()
  {
    return _impl.checkIfPlayersHaveSelected();
  } // checkIfPlayersHaveSelected

  public boolean calculateResults ()
  {
    return _impl.calculateResults();
  } // calculateResults

  public boolean endCurrentGame ()
  {
    return _impl.endCurrentGame();
  } // endCurrentGame

  public boolean hasAPlayerLeft ()
  {
    return _impl.hasAPlayerLeft();
  } // hasAPlayerLeft


  //Callback method
  public void event_listener (String player_id, String message, org.ds.rps.interfaces.CallBack callback) throws org.ds.rps.interfaces.unknown_player
  {
    _impl.event_listener(player_id, message, callback);
  } // event_listener


  //File transfer method
  public byte[] getHowTooPlayFile (String file_name) throws org.ds.rps.interfaces.unknown_path
  {
    return _impl.getHowTooPlayFile(file_name);
  } // getHowTooPlayFile


  //Any method
  public void currGameDetails (String player_id, org.omg.CORBA.AnyHolder anyGame) throws org.ds.rps.interfaces.unknown_player
  {
    _impl.currGameDetails(player_id, anyGame);
  } // currGameDetails

  private org.ds.rps.interfaces.GameInterfaceOperations _impl;

} // class GameInterface_Tie