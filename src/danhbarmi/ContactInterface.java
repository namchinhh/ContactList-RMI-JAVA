/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhbarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Thanh Nam
 */
public interface ContactInterface extends Remote{
    public void add(Person p) throws RemoteException;
    public Integer getPhone(String name) throws RemoteException;
    public ArrayList<Person> getAll() throws RemoteException;
}
