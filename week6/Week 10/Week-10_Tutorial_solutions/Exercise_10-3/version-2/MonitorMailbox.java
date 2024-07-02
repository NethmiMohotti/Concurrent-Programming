/** 
    File: MonitorMailbox.java
    Module: 6SENG006W Concurrent Programming
    Author: P. Howells
    Modified: 24/11/22
**/

class MonitorMailbox implements Mailbox 
{

    private int     contents  = -1 ;
    private boolean available = false ;

    public synchronized void put( int value ) 
    {
	while ( available ) 
	{
            // /**  // Exercise 10.2 (d)
	    try {
		    wait( ) ;    
	    } 
	    catch ( InterruptedException e ) { }
            // **/
	}

	contents = value ;

	available = true ;

	notifyAll( ) ;      // Exercise 10.2 (d)

	printState( "put(" + value + ")  " ) ;
    }



    public synchronized int take( ) 
    {
	while ( !available )   
	{
            // /**  // Exercise 10.2 (d)
	    try { 
		   wait() ;     
		} 
	    catch ( InterruptedException e ) { }
            // **/
	}

	available = false ;

       
	notifyAll( ) ;         // Exercise 10.2 (d)

	printState( "take():"+ contents ) ;

	return contents ;
    }



    public synchronized void printState ( String operation )
    {
	System.out.println( "MonitorMailbox." + operation + "  " + this.toString() ) ;
    }


    public synchronized String toString ( )
    {
	return new String ( "[ contents = "   + contents  +
			    " , available = " + available + " ]" ) ;
    }


}

