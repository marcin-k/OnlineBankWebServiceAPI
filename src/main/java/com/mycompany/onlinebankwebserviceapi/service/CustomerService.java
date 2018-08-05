package com.mycompany.onlinebankwebserviceapi.service;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.onlinebankwebserviceapi.model.Customer;

//This class is used to accomodate requestes made in CustomerResource class
//Class creates a three customers
/**
 *
 * @authors 
 *          Marcin Krzeminski – X17158851
 *          Carlos Neia – X12116394
 *          Kevin Shannon - X17160324
 *          Joseph McDonnell - X17164761 
 */
public class CustomerService {
    //stores all customers in the system
    public static List<Customer> list = new ArrayList<>();
    //used to initialize the constructor to load few example records into
    //the system
    public static boolean init = true;
    
//---------Initialisation Constructor-------------------------------------------    
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
//--------Returns all customers in the system-----------------------------------
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
//----Returns a customer records for a customer with provided login-------------
    public Customer getUserByLogin(String login) {
        for (Customer u : getAllUsers()) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }
       
//----Validates a username and password-----------------------------------------    
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
