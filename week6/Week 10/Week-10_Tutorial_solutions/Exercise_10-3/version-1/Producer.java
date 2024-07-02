/** 
    File: Producer.java
    Module: 6SENG006W Concurrent Programming, see Week 07 Lecture
    Author: P. Howells
    Modified: 24/11/22 
**/

class Producer extends Thread 
{
  private final Mailbox mailbox ; // Mailbox "interface"
  private final int numberOfItems ;   

  private boolean terminateThread = false ;   // Exercise 10.3 

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

    System.out.println( getName() + " TERMINATING" ) ;

  }

}
