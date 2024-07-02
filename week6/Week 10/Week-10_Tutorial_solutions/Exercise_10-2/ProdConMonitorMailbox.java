/** 
    File: ProdConMonitorMailbox.java
    Author: P. Howells
    Module: 6SENG006W Concurrent Programming
    Modified: 24/11/22 
**/

class ProdConMonitorMailbox
{

    public static void main( String args[] ) 
    {
	final int NUMBITEMS = 10 ;

	System.out.println( "Create: MonitorMailbox, Producer & Consumer" ) ;

	Mailbox mmb = new MonitorMailbox( ) ;

	Producer p1 = new Producer( mmb, 1, NUMBITEMS ) ;
	Consumer c1 = new Consumer( mmb, 1, NUMBITEMS ) ;

	System.out.println( "Start Producer & Consumer" ) ;

	p1.start( ) ;
	c1.start( ) ;

	// wait for both threads to terminate
	try {
	        p1.join() ;
		c1.join() ;
	     } 
	catch (InterruptedException e){ }

	System.out.println( "Producer & Consumer have terminated" ) ;
    }
}

