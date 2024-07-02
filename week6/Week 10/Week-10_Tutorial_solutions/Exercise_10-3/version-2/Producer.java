/** 
   File: Producer.java    (Version 2)
   Author: P. Howells
   Module: 6SENG006W Concurrent Programming
   Modified: 24/11/22 

   Using: 1) Main terminates the Producer
          2) Producer then puts a "termination" signal/value in the Mailbox
             that when the consumer takes causes it to terminate.
**/

class Producer extends Thread 
{
  private final Mailbox mailbox ; 
  private final int numberOfItems ;   

  private boolean terminateThread = false ;        // Exercise 10.3 
  
  private final int TERMINATE_SIGNAL = -999999 ;   // Exercise 10.3 


  public Producer( Mailbox mailbox, 
                   int Pid, 
                   int numberOfItems ) 
  {
     super( "Producer #" + Pid ) ;  // Thread( thrd_name )

     this.mailbox = mailbox ;

     this.numberOfItems = numberOfItems ;
  }

  // Exercise 10.3 
  public synchronized void terminate() 
  {
      terminateThread = true ;
  }

  // Exercise 10.3 
  private synchronized boolean doNotTerminate() 
  {
      return ( ! terminateThread ) ;
  }

  public void run() 
  {
    int item = 0 ;                // Exercise 10.3 

    while ( doNotTerminate() )    // Exercise 10.3 
    {
       mailbox.put( item ) ;

       item++ ;

       System.out.println( getName() + " put:   " + item ) ;

       int sleepTime = 500 ;           
       // int sleepTime = 1500 ;       

       try {
            sleep( (int)( Math.random() * sleepTime ) ) ;
           } 
       catch (InterruptedException e) { }
    }

    // puts "termination signal" in the Mailbox
    mailbox.put( TERMINATE_SIGNAL ) ;
    System.out.println( getName() + " put - TERMINATE_SIGNAL" ) ;
   
    System.out.println( getName() + " TERMINATING" ) ;

  }

}
