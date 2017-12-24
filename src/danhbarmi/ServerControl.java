/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhbarmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Nguyen Thanh Nam
 */
public class ServerControl extends UnicastRemoteObject implements ContactInterface{
    private int serverPort = 1999;
    private Registry registry;
    private Connection con;
    private ServerView view;
    private String rmiService = "rmiService";
    
    public ServerControl(ServerView view) throws RemoteException{
        this.view =view;
        getDBConnection("contact", "root", "");
        view.showMessage("Server is running...");
        try {
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind(rmiService, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getDBConnection(String dbname,String username, String password){
        String dbUrl = "jdbc:mysql://localhost:3306/"+dbname;
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con= DriverManager.getConnection(dbUrl,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Person p) throws RemoteException {
        try {
            String query ="INSERT INTO person (name,phonenumber) VALUES ('"+p.getName()+"','"+p.getPhonenumber()+"')";
            Statement stm = con.createStatement();
            stm.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getPhone(String name){
        try {
            String query ="SELECT phonenumber FROM person WHERE name = '"+name+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Person> getAll() throws RemoteException {
        ArrayList<Person> all = new ArrayList();
        try {
            String query ="SELECT * FROM person";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Person p = new Person(rs.getString(1), rs.getInt(2));
                all.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }
}
