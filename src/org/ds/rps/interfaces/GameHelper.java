package org.ds.rps.interfaces;


/**
* org/ds/rps/interfaces/GameHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/

abstract public class GameHelper
{
  private static String  _id = "IDL:org/ds/rps/interfaces/Game:1.0";

  public static void insert (org.omg.CORBA.Any a, org.ds.rps.interfaces.Game that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.ds.rps.interfaces.Game extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [7];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "date",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "winner_id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "winner_name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "message",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[5] = new org.omg.CORBA.StructMember (
            "isActive",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.ds.rps.interfaces.PlayerHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (org.ds.rps.interfaces.PlayerListHelper.id (), "PlayerList", _tcOf_members0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "players",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (org.ds.rps.interfaces.GameHelper.id (), "Game", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.ds.rps.interfaces.Game read (org.omg.CORBA.portable.InputStream istream)
  {
    org.ds.rps.interfaces.Game value = new org.ds.rps.interfaces.Game ();
    value.id = istream.read_string ();
    value.date = istream.read_string ();
    value.winner_id = istream.read_string ();
    value.winner_name = istream.read_string ();
    value.message = istream.read_string ();
    value.isActive = istream.read_boolean ();
    value.players = org.ds.rps.interfaces.PlayerListHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.ds.rps.interfaces.Game value)
  {
    ostream.write_string (value.id);
    ostream.write_string (value.date);
    ostream.write_string (value.winner_id);
    ostream.write_string (value.winner_name);
    ostream.write_string (value.message);
    ostream.write_boolean (value.isActive);
    org.ds.rps.interfaces.PlayerListHelper.write (ostream, value.players);
  }

}