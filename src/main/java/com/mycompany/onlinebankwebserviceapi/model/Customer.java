package com.mycompany.onlinebankwebserviceapi.model;

//Class used to represent Customer blueprint
/**
 *
 * @authors 
 *          Marcin Krzeminski – X17158851
 *          Carlos Neia – X12116394
 *          Kevin Shannon - X17160324
 *          Joseph McDonnell - X17164761 
 */
public class Customer {
   
    //stores customer's name
    private String name;
    //stores customer's address
    private String address;
    //stores customer's email address
    private String email;
    //stores customer's login
    private String login;
    //stores customer's password
    private String password;


    //constructor, setting up all fields except the accounts
    public Customer(String name, String address, String email, String login, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public Customer() {
    }

    
 
    
//------------------------------Getters-----------------------------------------
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

   
//------------------------------Setters-----------------------------------------    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
