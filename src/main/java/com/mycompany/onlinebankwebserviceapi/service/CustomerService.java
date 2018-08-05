package com.mycompany.onlinebankwebserviceapi.service;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.onlinebankwebserviceapi.model.Customer;

public class CustomerService {
    public static List<Customer> list = new ArrayList<>();
    public static boolean init = true;
    

    
    public CustomerService () {
        //for testing
        if (init) {
            Customer u1 = new Customer("bob", "cork", "bob@bob.com", "bob1", "test");
            Customer u2 = new Customer("tom", "dublin", "bob2@bob.com", "bob2", "test");
            Customer u3 = new Customer("scott", "limerick", "bob3@bob.com", "bob3", "test");

            list.add(u1);
            list.add(u2);
            list.add(u3);

            init = false;
        }
    }
    //to be commented out     
    public List<Customer> getAllUsers() {
        return list;
    }

//----------------creates a new customer account--------------------------------
    public String createUser(Customer user){
        
        for (Customer c : getAllUsers()) {
            //checks if the unique username is used
            if (user.getLogin().equalsIgnoreCase(c.getLogin())) {
                return "Login: "+user.getName()+" already exists: ";
            }
        }
       
        list.add(user);
        return "Customer added sucessfully";
    }
//------------------------------------------------------------------------------ 

    
    public Customer getUserByLogin(String login) {
        for (Customer u : getAllUsers()) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }
         
    public Customer deleteUser(int id){
        if (id <= 0) {
            return null;
        }
        Customer u = list.get(id-1);
        list.remove(id-1);
        System.out.println("204 -  user id:" + String.valueOf(id) + " deleted");
        return u;
    }
    
    public String login(String login, String password) {
        for (Customer u : getAllUsers()) {
            if (u.getLogin().equals(login)) {
                if(u.getPassword().equals(password)){
                    return "login successful";
                }
                return "inccorect password";
            }
        }
        return "Inncorect Login";
    }
 
}
