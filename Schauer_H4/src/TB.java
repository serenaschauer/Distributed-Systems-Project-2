
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
//Serena Schauer
//CCSI 344 - Distributed Systems 
//Homework #4

import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TB extends Thread{

	OutputStream  output_from_B_to_C;
	OutputStream  output_from_B_to_A;
	
	ObjectOutputStream object_output_from_B_to_A;
	
	// Constructor
	public TB(OutputStream output_from_B_to_A, OutputStream output_from_B_to_C, ObjectOutputStream object_output_from_B_to_A){
		   this.output_from_B_to_A = output_from_B_to_A;
		   this.output_from_B_to_C = output_from_B_to_C;
		   this.object_output_from_B_to_A = object_output_from_B_to_A;		
		
	}
	
	public void run(){
	     System.out.println("Thread B: is running.");
	      try {
	    	  // Sending
	    	  output_from_B_to_C.write(44);
	    	  System.out.println("Thread B: sends to Thread C primitive data: " + 44); 

		      Message m = new Message();
		      m.theMessage = "Hey there Thread A! -- From Thread B";
		      String[] s = { "uno", "dos", "tres" };
		      m.someLines = s;
		      m.someNumber= 64;      
		      object_output_from_B_to_A = new ObjectOutputStream( output_from_B_to_A );
		      object_output_from_B_to_A.writeObject( m );           
			  System.out.println("Thread B: sends to Thread A the Object: \n" + m.toString());   	 
			    	
			  // Thread Ending
			  System.out.println("Thread B: Ended");
	      }   
	      catch ( Exception exc ) {
	            System.out.println
	                  ( "Error TB: " + exc );
	      }		
		
	}
	
}
