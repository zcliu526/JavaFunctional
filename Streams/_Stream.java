package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Mary", Gender.FEMALE),
                new Person("Mohn", Gender.FEMALE),
                new Person("JoShn", Gender.MALE),
                new Person("JoAAShn", Gender.FEMALE)
        );

        people.stream()
                .map(person -> (person.gender))
                .collect(Collectors.toSet())
                        .forEach(System.out::println);

        //next
        people.stream()
                .map(person -> (person.name))
                .mapToInt(String::length)
                .forEach(System.out::println);


        //Set<Gender> genders = people.stream().....blabla
        //System.out.println(genders);
    }

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
}
