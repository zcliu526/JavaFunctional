package FunctionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static FunctionalInterface._Consumer.Customer.greetCustomer;
import static FunctionalInterface._Consumer.Customer.greetCustomerV2;

public class _Consumer {

    public static void main(String[] args) {
        Customer Maria = new Customer("Maria", "99999");

        // Functional interface
        greetCustomerConsumer.accept(Maria);
        greetCustomerV2(Maria, false);

        greetCustomerConsumerV2.accept(Maria, false);


    }//end main

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*******"));


    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName);


   static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        static void greetCustomer(Customer customer){
            System.out.println("Hello " + customer.customerName);
        }

        static void greetCustomerV2(Customer customer, boolean showPhoneNumber){
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*******"));
        }


       @Override
       public String toString() {
           return "Customer{" +
                   "customerName='" + customerName + '\'' +
                   ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                   '}';
       }
   }


}//end clss
