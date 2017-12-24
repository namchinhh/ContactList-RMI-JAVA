/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhbarmi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nguyen Thanh Nam
 */
public class ClientView {
    
    public void menu(){
        ClientControl control = new ClientControl();
        int chon;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("-----Menu-----");
            System.out.println("1. Add Contact");
            System.out.println("2. Get Phone By Name");
            System.out.println("3. Show All Contact");
            System.out.println("---------------------------");
            System.out.println("Please Choose: ");
            chon = Integer.parseInt(in.nextLine());
            switch(chon){
                case 1:
                    System.out.println("Name: ");
                    String name = in.nextLine();
                    System.out.println("Number: ");
                    int numb = Integer.parseInt(in.nextLine());
                    Person p = new Person(name, numb);
                    control.add(p);
                    break;
                case 2:
                    System.out.println("Enter Name: ");
                    String sname = in.nextLine();
                    Integer num = control.getPhone(sname);
                    if(num == 0)
                        System.out.println("This contact doesn't exist.");
                    else
                    System.out.println(num);
                    break;
                case 3:
                    ArrayList<Person> all = control.getAll();
                    if(all.isEmpty()){
                        System.out.println("The list doesn't have any contact.");
                        break;
                    }
                    for (Person person : all) {
                        System.out.println(person.getName()+"-----"+person.getPhonenumber());
                    }
                    break;
              
                default:
                    System.out.println("Wrong input.");
            }
        }
        
    }

    public ClientView() {
    }
}
