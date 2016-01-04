package org.ds.rps.interfaces;

/**
* org/ds/rps/interfaces/CallBackHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameInterfaces.idl
* 29 March 2015 22:08:29 o'clock IST
*/


//Callback
public final class CallBackHolder implements org.omg.CORBA.portable.Streamable
{
  public org.ds.rps.interfaces.CallBack value = null;

  public CallBackHolder ()
  {
  }

  public CallBackHolder (org.ds.rps.interfaces.CallBack initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.ds.rps.interfaces.CallBackHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.ds.rps.interfaces.CallBackHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.ds.rps.interfaces.CallBackHelper.type ();
  }

}