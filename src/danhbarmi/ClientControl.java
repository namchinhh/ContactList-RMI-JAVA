/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhbarmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Thanh Nam
 */
class ClientControl {
    private String serverHost = "localhost";
    private int serverPort = 1999;
    private ContactInterface rmiServer;
    private Registry registry;
    private String rmiService = "rmiService";

    public ClientControl() {
        try {
            registry = LocateRegistry.getRegistry(serverHost, serverPort);
            rmiServer = (ContactInterface) (registry.lookup(rmiService));
        }catch(RemoteException re){
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void add(Person p) {
        try {
            rmiServer.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getPhone(String sname) {
        try {
            return rmiServer.getPhone(sname);
        } catch (Exception e) {
            e.printStackTrace();
        }return 0;
    }

    public  ArrayList<Person> getAll() {
        ArrayList<Person> all = new ArrayList();
        try {
            all = rmiServer.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }return all;
    }
    
}
