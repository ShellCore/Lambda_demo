package com.shellcore.java.lambda;

/**
 * Created by Cesar. 05/06/2017.
 */
public class Main {

    public static void main(String[] args) {
        Main mainInstance = new Main();

        // Calling the old implementation
        mainInstance.doInTheOldWay();

        // Calling the new implementation
        mainInstance.doItWithLambdas();

        MyFunctionalInterface otherBehavior = System.out::println;
        mainInstance.doSomethingHighOrder(otherBehavior);

        MyFunctionalInterface anotherBehavior = x -> {
            x = "Do something ".concat(x);
            System.out.println(x);
            System.out.println("Making java great again");
        };

        mainInstance.doSomethingHighOrder(anotherBehavior);

    }

    /**
     * Java old days demonstration
     */
    public void doInTheOldWay() {

        // The actual implementation of the contract
        MyFunctionalInterface implementation = new MyFunctionalInterface() {
            @Override
            public void doSomething(String txt) {
                System.out.println(txt);
            }
        };

        implementation.doSomething("Hello in the old way");
    }

    /**
     * Java 8 demonstration
     */
    public void doItWithLambdas() {
        // Behavior(Implementation) definition
        MyFunctionalInterface implementation = (String x) -> System.out.println(x);

        // Invoking the definition
        implementation.doSomething("Hello from lambda fashion");


        implementation = x -> System.out.println(x);
        implementation.doSomething("Hello from shorter syntax");

        implementation = x -> {
            System.out.println("Hello from complex syntax");
            System.out.println(x);
            System.out.println("Bye from complex syntax");
        };
        implementation.doSomething("Regular code in complex syntax");

        // Reusing the third behavior
        doSomethingHighOrder(implementation);
    }

    /**
     * Function that receives behavior as parameter (High order)
     * @param behavior
     */
    public void doSomethingHighOrder(MyFunctionalInterface behavior) {
        behavior.doSomething("in high order way");
    }
}
