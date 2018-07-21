
import com.mycompany.onlinebankwebserviceapi.model.Customer;
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
    
//    //creates an account for a customer returns true if completed false if not
//    public boolean createAnAccount(String customerLogin, double initialDeposit){
//        for(Customer c: customers){
//            if(c.getLogin().equals(customerLogin)){
//                c.createNewAccount(initialDeposit);
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    //allows to lodge money to the account returns true if succesfull 
//    //false if not
//    public boolean lodgeMoney(String customerLogin, int accountNumber, 
//            double amount){
//        //loops thorugh all customers in the list
//        for(Customer c: customers){
//            if(c.getLogin().equals(customerLogin)){
//                //loops thorugh all of the account for a given cusomter
//                for(Account a:c.getAccounts()){
//                    if(a.getAccountNumber()==accountNumber){
//                        //gets a current balance
//                        double currentBalance = a.getBalance();
//                        //adds the deposit to a current balance
//                        a.setBalance(currentBalance+amount);
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
////    
////    //method used for money transfer operations, returns true if successful
////    //false if not, customer can transfer money only from one of thier own 
////    //acounts
////    public boolean transferMoney(String cusomterLogin, int accountFrom, 
////            int accountTo, double amount){
////        
////        //loops thourgh all cutomers
////        for(Customer c: customers){
////            //temp variables to store refrences to accounts
////            Account accountFromTemp = null;
////            Account accountToTemp = null;
////            
////                //loops thorough all accounts for a customer and 
////                //checks if the number for account from exist and belongs to
////                //that customer
////                for(Account a:c.getAccounts()){
////                    if((a.getAccountNumber()==accountFrom)&&
////                            (c.getLogin().equals(cusomterLogin))){
////                        
////                        accountFromTemp=a;
////                    }
////                    //checks if accountTo number exist
////                    if(a.getAccountNumber()==accountTo){
////                        accountToTemp=a;
////                    }
////                    //if both numbers are found check if acount from has
////                    //sufficeint funds if so trnasfers money otherwise 
////                    //methods returns false
////                    if((accountFromTemp!=null) && (accountToTemp!=null)){
////                        if(accountFromTemp.getBalance() >= amount ){
////                            accountFromTemp.setBalance(accountFromTemp.getBalance()-amount);
////                            accountToTemp.setBalance(accountToTemp.getBalance()+amount);
////                            return true;
////                        }
////                    }
////                }
////        }
////        return false;
////    }
    
//    //method used to withdraw money, returns true if successfull, false if not
//    public boolean withdraw(String login, int accountNumber, double amount){
//        //temp var to store account pointer
//        Account tempAccountReference = null;
//        for(Customer c:customers){
//            if(c.getLogin().equals(login)){
//                for(Account a:c.getAccounts()){
//                    if(a.getAccountNumber()==accountNumber){
//                        tempAccountReference=a;
//                        break;
//                    }
//                }
//            }
//            //if account is found break out of the loop
//            if(tempAccountReference!=null){
//                break;
//            }
//        }
//        //if account has sufficient fundings withdraw
//        if(tempAccountReference.getBalance()>=amount){
//            tempAccountReference.setBalance(tempAccountReference.getBalance()-amount);
//        }
//        return false;
//    }
//    
//    //returns balance for the account, reutns -1 if account or login not found
//    public double getBalance(String login, int accountNumber){
//        for(Customer c:customers){
//            if(c.getLogin().equals(login)){
//                for(Account a:c.getAccounts()){
//                    if(a.getAccountNumber()==accountNumber){
//                        return a.getBalance();
//                    }
//                }
//            }
//        }
//        return -1.0;
//    }
    
}
