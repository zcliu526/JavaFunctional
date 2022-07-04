package FunctionalInterface;

import java.util.function.Function;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));

        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(validNumberFunction.apply("07000000000"));

        //can use .or() here too for true result
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000300"));


    }//end main

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    static Function<String, Boolean> validNumberFunction = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

}//end class
