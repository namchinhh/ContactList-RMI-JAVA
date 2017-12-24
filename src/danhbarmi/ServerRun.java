/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhbarmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Thanh Nam
 */
public class ServerRun {
    
    public static void main(String[] args) {
        ServerView view = new ServerView();
        try {
            ServerControl control = new ServerControl(view);
          
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
