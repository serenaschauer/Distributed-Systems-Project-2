// Serena Schauer
// CCSI 344 - Distributed Systems 
// Homework #4

import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TC extends Thread{
	
	   InputStream   input_to_C_from_A;
	   InputStream   input_to_C_from_B;
	   OutputStream  output_from_C_to_A;
	   
	   ObjectOutputStream object_output_from_C_to_A;
	   
	// Constructor
	public TC(InputStream input_to_C_from_A, InputStream input_to_C_from_B, OutputStream output_from_C_to_A, ObjectOutputStream object_output_from_C_to_A ) {
	  //this.name=name;
	  //this.ID=ID;
		this.input_to_C_from_A = input_to_C_from_A;  
		this.input_to_C_from_B = input_to_C_from_B; 
		this.output_from_C_to_A = output_from_C_to_A;
		this.object_output_from_C_to_A = object_output_from_C_to_A;
	}
	
	public void run(){
	     System.out.println("Thread C: is running.");
	      try {
	    	  // Sending
	          Message m = new Message();
	          m.theMessage = "Hey there Thread A! -- From Thread C";
	          String[] s = { "one", "two", "three" };
	          m.someLines = s;
	          m.someNumber= 88;	            
	          object_output_from_C_to_A = new ObjectOutputStream( output_from_C_to_A );
	          object_output_from_C_to_A.writeObject( m );
	          System.out.println("Thread C: wrote to Thread A the Object: " + "\n"  + m.toString()); 
	    	  
	    	  // Receiving 
			  System.out.println("Thread C: received from Thread B primitive data: " + input_to_C_from_B.read());
		   	 
			  System.out.println("Thread C: received from Thread A primitive data: " + input_to_C_from_A.read() );

		      // Thread Ending
		      System.out.println("Thread C: Ended");    	
	      }   
	      catch ( Exception exc ) {
	            System.out.println
	                  ( "Error TC: " + exc );
	      }		
		
		
	}
	
	
}
