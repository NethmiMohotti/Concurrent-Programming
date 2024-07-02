/** 
    File: ProdConMonitorMailbox.java
    Module: 6SENG006W Concurrent Programming
    Author: P. Howells
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

	System.out.println( "Go to Sleep" ) ;
        
        int sleepTime = 1000 ;           

        try {
               Thread.currentThread().sleep( (int)( sleepTime ) ) ; 
          } 
        catch (InterruptedException e) { }
       
	System.out.println( "Terminate Producer & Consumer" ) ;

	p1.terminate() ;
	c1.terminate() ;

        
	// wait for both threads to terminate
	try {
	        p1.join() ;
		c1.join() ;
	     } 
	catch (InterruptedException e){ }

	System.out.println( "Producer & Consumer have terminated" ) ;
    }
}

