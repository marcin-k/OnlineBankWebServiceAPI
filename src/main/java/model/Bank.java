package model;

import java.util.ArrayList;

/**
 *
 * @author marcin
 */
public class Bank {
    //stores all of the cusotmers
    private ArrayList<Customer> customers;
    //stores the last account number created so any new account gets an
    //incremented value of that account
    protected static int LAST_ACCOUNT_CREATED = 100000000;
    //stores branch code
    protected static int BRANCH_CODE = 770777;

    //Constructor initialize the array list 
    public Bank() {
        customers = new ArrayList<Customer>();
    }
    
    //creates a new cusomter object and adds it to cusotmers array list
    public void createNewCusomter(String name, String address, String email, String login, String password){
        //TODO : check if the login is unique
        Customer customer = new Customer(name, address, email, login, password);
        this.customers.add(customer);
    }
    
    //login method returns true if correct login, false if not
    public boolean login(String login, String password){
        for(Customer c : customers){
            if((c.getLogin().equals(login))&&(c.getPassword().equals(password))){
                return true;
            }
        }
        return false;
    }
    
    //creates an account for a customer returns true if completed false if not
    public boolean createAnAccount(String customerLogin, double initialDeposit){
        for(Customer c: customers){
            if(c.getLogin().equals(customerLogin)){
                c.createNewAccount(initialDeposit);
                return true;
            }
        }
        return false;
    }
    
    //allows to lodge money to the account returns true if succesfull 
    //false if not
    public boolean lodgeMoney(String customerLogin, int accountNumber, 
            double amount){
        //loops thorugh all customers in the list
        for(Customer c: customers){
            if(c.getLogin().equals(customerLogin)){
                //loops thorugh all of the account for a given cusomter
                for(Account a:c.getAccounts()){
                    if(a.getAccountNumber()==accountNumber){
                        //gets a current balance
                        double currentBalance = a.getBalance();
                        //adds the deposit to a current balance
                        a.setBalance(currentBalance+amount);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    
    
    
}
