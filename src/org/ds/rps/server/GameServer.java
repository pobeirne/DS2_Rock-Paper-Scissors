/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ds.rps.server;

import java.util.Properties;
import org.ds.rps.interfaces.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * @author Paul O’Beirne - x10203800
 * @author Agnieszka Szczepankiewicz - x11103221
 * @version 1.0
 */
public class GameServer {

    public static void main(String[] args) {        
        try {
            
            Properties properties = System.getProperties();
            properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
            properties.put("org.omg.CORBA.ORBInitialPort", "1050");

            org.omg.CORBA.ORB orb = ORB.init(args, null);            
            //Instantiating the Servant 
            GameInterface servant = new GameInterface_Tie(new GameServerImpl(orb));
            orb.connect(servant);
            //Getting the object reference to the Name Service held in the ORB 
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            //Narrowing the object reference to point to the root of the name service 
            NameComponent nc[] = new NameComponent[1];
            NamingContext rootCtx = NamingContextHelper.narrow(objRef);
            //Creating a new name component that contains the object reference to the instantiated servant 
            nc[0] = new NameComponent("Root", "Context");
            NamingContext GameCtx = rootCtx.bind_new_context(nc);
            nc[0] = new NameComponent("Game", "Object");
            //Binding the name to an object that is stored in the Name Service 
            GameCtx.rebind(nc, servant);

            System.out.println("Server running....");
            System.out.println("Waiting for invocations from clients....");
            // wait for invocations from clients  
            java.lang.Object sync = new java.lang.Object();
            synchronized (sync) {
                sync.wait();
            }

        } catch (InvalidName | NotFound | AlreadyBound | CannotProceed | InterruptedException | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            Thread.currentThread().interrupt();
            System.err.println("\n Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}
