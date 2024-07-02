/** 
    File: ProdConSimpleMailbox.java
    Module: 6SENG006W Concurrent Programming
    Author: P. Howells
    Modified: 24/11/22
**/

class ProdConSimpleMailbox
{

    public static void main( String args[] ) 
    {
	final int NUMBITEMS = 10 ;

	System.out.println( "Create: SimpleMailbox, Producer & Consumer" ) ;

	Mailbox smb = new SimpleMailbox( ) ;

	Producer p1 = new Producer( smb, 1, NUMBITEMS ) ;

	Consumer c1 = new Consumer( smb, 1, NUMBITEMS ) ;

        // Exercise 10.1 (d)
	Producer p2 = new Producer( smb, 2, NUMBITEMS ) ;

	Consumer c2 = new Consumer( smb, 2, NUMBITEMS ) ;


	System.out.println( "Start Producer & Consumer" ) ;

	p1.start( ) ;
	c1.start( ) ;

        // Exercise 10.1 (d)
	p2.start( ) ;
	c2.start( ) ;


	// wait for all threads to terminate
	try {
	        p1.join() ;
		c1.join() ;

               // Exercise 10.1 (d)
	       p2.join() ;
	       c2.join() ;

	    } 
	catch (InterruptedException e){ }

	System.out.println( "Producer & Consumer have terminated" ) ;
    }
}

