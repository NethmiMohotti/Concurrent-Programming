/** 
    File: ProdConMonitorMailbox.java  (Version 2)
    Author: P. Howells
    Module: 6SENG006W Concurrent Programming
    Modified: 24/11/22

   Using: 1) Main terminates all Producers, ie. p1 & p2
          2) Each Producer then puts a "termination" signal/value in the 
             Mailbox that when each consumer takes the signal it to terminate.
          3) This works provided number of producers >= number of consumer 
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

	Producer p2 = new Producer( mmb, 2, NUMBITEMS ) ;
	Consumer c2 = new Consumer( mmb, 2, NUMBITEMS ) ;

	System.out.println( "Start Producer & Consumer" ) ;

	p1.start( ) ;
	c1.start( ) ;

	p2.start( ) ;
	c2.start( ) ;


	System.out.println( "Go to Sleep" ) ;
        
        int sleepTime = 20000 ;    // 10 secs       

        try {
               Thread.currentThread().sleep( (int)( sleepTime ) ) ; 
          } 
        catch (InterruptedException e) { }
       
	System.out.println( "Terminate Producer & Consumer" ) ;

	p1.terminate() ;     // terminate both producers
	p2.terminate() ;
	// c1.terminate() ;  // version 1
	// c2.terminate() ;  // version 1

        
	// wait for both threads to terminate
	try {
	        p1.join() ;
		c1.join() ;

	        p2.join() ;
		c2.join() ;
	     } 
	catch (InterruptedException e){ }

	System.out.println( "Producer & Consumer have terminated" ) ;
    }
}

