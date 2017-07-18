// Serena Schauer
// CCSI 344 - Distributed Systems 
// Homework #4

import java.io.Serializable;
import java.net.*;

public class Message implements Serializable {

 // parts of the message
 public String   theMessage;  // a string
 public String[] someLines;   // an array
 public int      someNumber;  // a primitive

 public int number;
 public int id;
 
// Constructor
// public Message(int number, int id) { 
//	 this.number = number; 
//	 this.id = id;
// }
 
 // So clients can say System.out.println( msg )
 public String toString() {
     String s = "          Message: " + theMessage +
                "\n          with an array: ";
     for ( int i = 0 ; i < someLines.length ; i++ ) {
         s += someLines[i] + " ";
     } // end FOR(i)

     s += "\n          and a magic #: " + someNumber ;

     return s;
} // end METHOD toString

} // end CLASS Message