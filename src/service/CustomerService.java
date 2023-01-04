package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private static CustomerService single_instance;

    // private constructor to avoid client applications using the constructor
    private CustomerService() {};

    //Static method for obtaining the instance
    public static CustomerService getInstance() {
        if(single_instance == null) {
            single_instance = new CustomerService();
        }
        return single_instance;
    }
    //Create new hashmap with name 'customers', to store all customers
    public static Map<String, Customer> customers = new HashMap<String, Customer>();

    public static void addCustomer(String email, String firstName, String lastName) {
        Customer newCustomer = new Customer(firstName, lastName, email);
        if(customers.containsKey(email)) {
            throw new IllegalArgumentException("This email already exist");
        } else {
            customers.put(email, newCustomer);
        }
        //customers.put(email, new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String customerEmail) {
        if(customers.containsKey(customerEmail)) {
            return customers.get(customerEmail);
        } else {
           return null;
        }
    }

    public static Collection<Customer> getAllCustomers() {
        return customers.values();
    };
}