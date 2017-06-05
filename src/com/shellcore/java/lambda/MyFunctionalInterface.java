package com.shellcore.java.lambda;

/**
 * A simple contract to implement behavior
 * Created by Cesar. 05/06/2017.
 */
@FunctionalInterface
public interface MyFunctionalInterface {

    /**
     * The actual functional contract
     * @param txt
     */
    abstract void doSomething(String txt);
}
