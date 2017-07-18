// Serena Schauer
// CCSI 344 - Distributed Systems 
// Homework #4

import java.io.*;

public class ConnectionManager {

   static private PipedInputStream   input_to_C_from_A;
   static private PipedOutputStream  output_from_A_to_C;

   static private PipedInputStream   input_to_C_from_B;
   static private PipedOutputStream  output_from_B_to_C;
  
   static private PipedInputStream   input_to_A_from_C;
   static private PipedOutputStream  output_from_C_to_A;

   static private PipedInputStream   input_to_A_from_B;
   static private PipedOutputStream  output_from_B_to_A;
   
   static private ObjectOutputStream object_output_from_B_to_A;
   static private ObjectOutputStream object_output_from_C_to_A;
   static private ObjectInputStream  object_input_to_A_from_C;
   static private ObjectInputStream  object_input_to_A_from_B;


   public static void main ( String argv[] ) {
      try {

      // set up pipes  
      System.out.println("Connection Manager: Pipe setup");
      
      output_from_A_to_C = new PipedOutputStream( );      
      input_to_C_from_A = new PipedInputStream ( output_from_A_to_C );  

      output_from_B_to_C = new PipedOutputStream( );
      input_to_C_from_B = new PipedInputStream ( output_from_B_to_C );
      
      output_from_C_to_A = new PipedOutputStream( );
      input_to_A_from_C = new PipedInputStream ( output_from_C_to_A );
    
      output_from_B_to_A = new PipedOutputStream( );
      input_to_A_from_B = new PipedInputStream ( output_from_B_to_A );
      
      // Create Threads TA, TB, and TC
      System.out.println("Connection Manager: Object creation");
      TA threadA = new TA(input_to_A_from_B, input_to_A_from_C, output_from_A_to_C, object_input_to_A_from_B, object_input_to_A_from_C);
      TB threadB = new TB(output_from_B_to_A, output_from_B_to_C, object_output_from_B_to_A);
      TC threadC = new TC(input_to_C_from_A, input_to_C_from_B, output_from_C_to_A, object_output_from_C_to_A);
      
      // Start Threads
      System.out.println("Connection Manager: Thread execution");
      System.out.println();
      threadA.start(); 
      threadB.start();
      threadC.start();
            
      } // end TRY
      catch ( Exception exc ) {
            System.out.println( exc );
      } // end CATCH
   }

} // end CLASS ConnectionManager