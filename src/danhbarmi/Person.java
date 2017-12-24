/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhbarmi;

import java.io.Serializable;

/**
 *
 * @author Nguyen Thanh Nam
 */
public class Person implements Serializable{
    private String name;
    private int phonenumber;

    public Person(){};

    public Person(String name, int phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
    
}
