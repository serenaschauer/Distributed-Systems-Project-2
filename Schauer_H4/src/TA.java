// Serena Schauer
// CCSI 344 - Distributed Systems 
// Homework #4

import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class TA extends Thread{
	   
	OutputStream  output_from_A_to_C;
	InputStream   input_to_A_from_C;
	InputStream   input_to_A_from_B;
	   
	ObjectInputStream  object_input_to_A_from_C;
	ObjectInputStream  object_input_to_A_from_B;
	   
	// Constructor
	public TA(InputStream input_to_A_from_B, InputStream input_to_A_from_C, OutputStream output_from_A_to_C, ObjectInputStream object_input_to_A_from_B, ObjectInputStream object_input_to_A_from_C) {
	   this.input_to_A_from_B = input_to_A_from_B;
	   this.input_to_A_from_C = input_to_A_from_C;
	   this.output_from_A_to_C = output_from_A_to_C;
	   this.object_input_to_A_from_B = object_input_to_A_from_B;
	   this.object_input_to_A_from_C = object_input_to_A_from_C;  
	}
	
	
	public void run(){
	     System.out.println("Thread A: is running.");
	     try { 
	    	 // Sending
	    	 output_from_A_to_C.write(8);
	    	 System.out.println("Thread A: wrote to Thread C primitive data: " + 8);
   	 
	    	 // Receiving
	    	 object_input_to_A_from_B = new ObjectInputStream(input_to_A_from_B);
	         System.out.println("Thread A: received Object from Thread B the Object: \n" + object_input_to_A_from_B.readObject().toString());

	    	 object_input_to_A_from_C = new ObjectInputStream(input_to_A_from_C);
	    	 System.out.println("Thread A: received Object from Thread C the Object: \n" + object_input_to_A_from_C.readObject().toString());

	    	 // Thread Ending
	    	 System.out.println("Thread A: Ended");	        
	      }   
	      catch ( Exception exc ) {
	            System.out.println
	                  ( "Error TA: " + exc );
	      }		
		
		
	}
	
}
