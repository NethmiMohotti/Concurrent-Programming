/** 
    File: Consumer.java
    Module: 6SENG006W Concurrent Programming
    Author: P. Howells
    Modified: 24/11/22
**/

class Consumer extends Thread 
{
  private final Mailbox mailbox ;     // Mailbox "interface"
  private final int numberOfItems ;
   
  private int[] valuesConsumed ;

  private boolean terminateThread = false ;   // Exercise 10.3 

  public Consumer( Mailbox mailbox, 
                   int Cid, 
                   int numberOfItems ) 
  {
     super( "Consumer #" + Cid ) ;  // Thread( thrd_name )
     this.mailbox = mailbox ;
     this.numberOfItems = 50 ;     // Exercise 10.3  // numberOfItems ;

     valuesConsumed = new int[  this.numberOfItems ] ;

     for (int i = 0; i <  this.numberOfItems; i++) 
     {
       valuesConsumed[i] = -1 ;
     }

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

    int value = 0 ;                // Exercise 10.3 
    int i     = 0 ;                //  

    while ( doNotTerminate() )    // Exercise 10.3 
    {
      value = mailbox.take();
      valuesConsumed[i] = value ; 
      i++ ;
     
      System.out.println(getName() + " taken: " + value) ;

      // Added some sleep time
 
      // int sleepTime = 500 ;    // Exercise 10.3      
      int sleepTime = 1500 ;      // 

      try {
            sleep( sleepTime ) ;  // Exercise 10.3  
          } 
      catch (InterruptedException e) { }
 
    }

    // Print out the 10 items that have been consumed
    System.out.print( getName() + " consumed: < " ) ;

    // for (int j = 0; j < numberOfItems+5; j++)         
    for (int j = 0; j < numberOfItems; j++)              
    {
            System.out.print( valuesConsumed[j] + " " ) ; 
    }
    System.out.println( ">") ;

    System.out.println( getName() + " TERMINATING" ) ;
    

  }

}


