package org.ds.rps.interfaces;


/**
* org/ds/rps/interfaces/_GameInterfaceStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

public class _GameInterfaceStub extends org.omg.CORBA.portable.ObjectImpl implements org.ds.rps.interfaces.GameInterface
{


  //Player methods
  public String subscribe (String player_name, org.ds.rps.interfaces.CallBack callback) throws org.ds.rps.interfaces.create_fail
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("subscribe", true);
                $out.write_string (player_name);
                org.ds.rps.interfaces.CallBackHelper.write ($out, callback);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/create_fail:1.0"))
                    throw org.ds.rps.interfaces.create_failHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return subscribe (player_name, callback        );
            } finally {
                _releaseReply ($in);
            }
  } // subscribe

  public boolean unsubscribe (String player_id) throws org.ds.rps.interfaces.unknown_player, org.ds.rps.interfaces.destroy_fail
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unsubscribe", true);
                $out.write_string (player_id);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_player:1.0"))
                    throw org.ds.rps.interfaces.unknown_playerHelper.read ($in);
                else if (_id.equals ("IDL:org/ds/rps/interfaces/destroy_fail:1.0"))
                    throw org.ds.rps.interfaces.destroy_failHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return unsubscribe (player_id        );
            } finally {
                _releaseReply ($in);
            }
  } // unsubscribe

  public String getPlayerNameById (String player_id) throws org.ds.rps.interfaces.unknown_player
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getPlayerNameById", true);
                $out.write_string (player_id);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_player:1.0"))
                    throw org.ds.rps.interfaces.unknown_playerHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getPlayerNameById (player_id        );
            } finally {
                _releaseReply ($in);
            }
  } // getPlayerNameById


  //Game methods
  public boolean hasOpenSlot ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("hasOpenSlot", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return hasOpenSlot (        );
            } finally {
                _releaseReply ($in);
            }
  } // hasOpenSlot

  public boolean isValidPlayer (String player_id) throws org.ds.rps.interfaces.unknown_player
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("isValidPlayer", true);
                $out.write_string (player_id);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_player:1.0"))
                    throw org.ds.rps.interfaces.unknown_playerHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return isValidPlayer (player_id        );
            } finally {
                _releaseReply ($in);
            }
  } // isValidPlayer

  public boolean setPlayerIsReady (String player_id, boolean ready) throws org.ds.rps.interfaces.unknown_player
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setPlayerIsReady", true);
                $out.write_string (player_id);
                $out.write_boolean (ready);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_player:1.0"))
                    throw org.ds.rps.interfaces.unknown_playerHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return setPlayerIsReady (player_id, ready        );
            } finally {
                _releaseReply ($in);
            }
  } // setPlayerIsReady

  public boolean checkIfPlayersAreReadyToStart ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("checkIfPlayersAreReadyToStart", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return checkIfPlayersAreReadyToStart (        );
            } finally {
                _releaseReply ($in);
            }
  } // checkIfPlayersAreReadyToStart

  public boolean setPlayerSelection (String player_id, int choice) throws org.ds.rps.interfaces.unknown_player
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setPlayerSelection", true);
                $out.write_string (player_id);
                $out.write_long (choice);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_player:1.0"))
                    throw org.ds.rps.interfaces.unknown_playerHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return setPlayerSelection (player_id, choice        );
            } finally {
                _releaseReply ($in);
            }
  } // setPlayerSelection

  public boolean checkIfPlayersHaveSelected ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("checkIfPlayersHaveSelected", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return checkIfPlayersHaveSelected (        );
            } finally {
                _releaseReply ($in);
            }
  } // checkIfPlayersHaveSelected

  public boolean calculateResults ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("calculateResults", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return calculateResults (        );
            } finally {
                _releaseReply ($in);
            }
  } // calculateResults

  public boolean endCurrentGame ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("endCurrentGame", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return endCurrentGame (        );
            } finally {
                _releaseReply ($in);
            }
  } // endCurrentGame

  public boolean hasAPlayerLeft ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("hasAPlayerLeft", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return hasAPlayerLeft (        );
            } finally {
                _releaseReply ($in);
            }
  } // hasAPlayerLeft


  //Callback method
  public void event_listener (String player_id, String message, org.ds.rps.interfaces.CallBack callback) throws org.ds.rps.interfaces.unknown_player
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("event_listener", true);
                $out.write_string (player_id);
                $out.write_string (message);
                org.ds.rps.interfaces.CallBackHelper.write ($out, callback);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_player:1.0"))
                    throw org.ds.rps.interfaces.unknown_playerHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                event_listener (player_id, message, callback        );
            } finally {
                _releaseReply ($in);
            }
  } // event_listener


  //File transfer method
  public byte[] getHowTooPlayFile (String file_name) throws org.ds.rps.interfaces.unknown_path
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getHowTooPlayFile", true);
                $out.write_string (file_name);
                $in = _invoke ($out);
                byte $result[] = org.ds.rps.interfaces.DataHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_path:1.0"))
                    throw org.ds.rps.interfaces.unknown_pathHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getHowTooPlayFile (file_name        );
            } finally {
                _releaseReply ($in);
            }
  } // getHowTooPlayFile


  //Any method
  public void currGameDetails (String player_id, org.omg.CORBA.AnyHolder anyGame) throws org.ds.rps.interfaces.unknown_player
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("currGameDetails", true);
                $out.write_string (player_id);
                $in = _invoke ($out);
                anyGame.value = $in.read_any ();
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/ds/rps/interfaces/unknown_player:1.0"))
                    throw org.ds.rps.interfaces.unknown_playerHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                currGameDetails (player_id, anyGame        );
            } finally {
                _releaseReply ($in);
            }
  } // currGameDetails

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/ds/rps/interfaces/GameInterface:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GameInterfaceStub