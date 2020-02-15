package com.avanzadose.dao;

/**
 *
 * @author Fernando Ambrosio
 */
public interface MyInterface {
    
    default void defaultMethod(){
        privateMethod("Hello from the default method!");
    }
    
    private void privateMethod(final String string){
        System.out.println(string);
    }
    
    void normalMethod();
    
}
