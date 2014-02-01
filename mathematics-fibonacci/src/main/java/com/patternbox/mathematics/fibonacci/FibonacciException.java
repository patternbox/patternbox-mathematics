package com.patternbox.mathematics.fibonacci;

/**
 * 
 */
public class FibonacciException extends java.lang.Exception {
   
   /**
    * serialVersionUID
    */
   private static final long serialVersionUID = 1L;

   /**
    * The default constructor.
    */
   public FibonacciException() {
   }

   /**
    * Constructs a new instance of FibonacciException
    * 
    * @param throwable
    *           the parent Throwable
    */
   public FibonacciException(Throwable throwable) {
      super(throwable);
   }

   /**
    * Constructs a new instance of FibonacciException
    * 
    * @param message
    *           the throwable message.
    */
   public FibonacciException(String message) {
      super(message);
   }

   /**
    * Constructs a new instance of FibonacciException
    * 
    * @param message
    *           the throwable message.
    * @param throwable
    *           the parent of this Throwable.
    */
   public FibonacciException(String message, Throwable throwable) {
      super(message, throwable);
   }

}
