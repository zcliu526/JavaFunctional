import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.*;

public class Main {

    static class Person {
        private final String name;
        private final Gender gender;


        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }


    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Mary", Gender.FEMALE),
                new Person("Mohn", Gender.FEMALE),
                new Person("JoShn", Gender.MALE),
                new Person("JoAAShn", Gender.FEMALE)
        );


        //Imperative arrpoach
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.gender.equals(Gender.FEMALE)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("Declarative approach");
        //Declarative approach
        people.stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                //.collect(Collectors.toList())
                .forEach(System.out::println);

        //Predicate<Person> personPredicate = person -> person.gender.equals(Gender.FEMALE);
        List<Person> female2 = people.stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                .collect(Collectors.toList());
        female2.forEach(System.out::println);



    }
}