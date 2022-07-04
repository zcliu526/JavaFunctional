package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);

        Function<Integer, Integer> incrementByOne =
                number -> number ++;
        int a = incrementByOne.apply(1);
        System.out.println(a);

        int multiply = multipleBy10.apply(a);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1Then10 = incrementByOne.andThen(multipleBy10);
        System.out.println(addBy1Then10.apply(1));

        //BiFunction
        int bifunction = byOneTimes10.apply(1,10);
        System.out.println(bifunction);

    }
    //static Function<Integer, Integer> incrementByOne =
     //       number -> number ++;

    static Function<Integer, Integer> multipleBy10 = number -> number * 10;

    static int increment(int number){

        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> byOneTimes10 =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }

}
