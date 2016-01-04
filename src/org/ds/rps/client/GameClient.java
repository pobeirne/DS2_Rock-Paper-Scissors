/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ds.rps.client;

import java.util.Properties;
import org.ds.rps.interfaces.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * @author Paul O’Beirne - x10203800 
 * @author Agnieszka Szczepankiewicz - x11103221
 * @version 1.0  
 */

public class GameClient {

    private static GameInterface gameServerRef;
    private static ORB orb;  
    private Properties properties;

    /**
     *
     * @param args
     */
    public GameClient(String args[]) {
        init(args);
    }
    
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        new GameClient(args);
    }   

    private void init(String[] args) {
        try {            
            properties = System.getProperties();
            properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
            properties.put("org.omg.CORBA.ORBInitialPort", "1050");
            
            orb = ORB.init(args, null);
            org.omg.CORBA.Object nameObj = orb.resolve_initial_references("NameService");
            NamingContext rootCtx = NamingContextHelper.narrow(nameObj);
            NameComponent[] nc = new NameComponent[2];
            nc[0] = new NameComponent("Root", "Context");
            nc[1] = new NameComponent("Game", "Object");
            gameServerRef = GameInterfaceHelper.narrow(rootCtx.resolve(nc));

        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Allows GameClientUI to access the server reference
     * @return
     */
    public GameInterface getServant() {
        return gameServerRef;
    }
    
    /**
     * Allows GameClientUI to access the orb
     * @return
     */
    public ORB getORB() {
        return orb;
    }
}
