package Optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
       Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        System.out.println(value);

        Object value2 = Optional.ofNullable("Hello")
                .orElseThrow(() -> new IllegalStateException("exception"));//this is a Supplier
        System.out.println(value2);

        Optional.ofNullable("cole@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> {
                            System.out.println("Cannot send email");//This is a Consumer
                        }
                );
    }
}
