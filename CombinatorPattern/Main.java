package CombinatorPattern;

import java.time.LocalDate;

import static CombinatorPattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alicegmail.com",
                "+099213123",
                LocalDate.of(2000,1,1)
        );

        CustomerValidatorService validatorService = new CustomerValidatorService();
        //validatorService.isValid(customer);
        System.out.println(validatorService.isValid(customer));

        //another way
        //System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid, we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                                    .and(isPhoneNumberValid())
                                    .and(isAnAdult())
                                    .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
