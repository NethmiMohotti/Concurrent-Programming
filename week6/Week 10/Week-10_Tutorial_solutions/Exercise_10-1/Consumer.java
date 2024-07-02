/** 
    File: Consumer.java
    Module: 6SENG006W Concurrent Programming
    Author: P. Howells
    Modified: 24/11/22
**/

class Consumer extends Thread 
{
  private final Mailbox mailbox ;       // Mailbox "interface"
  private final int     numberOfItems ;
   
  private int[] valuesConsumed ;

  public Consumer( Mailbox mailbox, 
                   int Cid, 
                   int numberOfItems ) 
  {
     super( "Consumer #" + Cid ) ;  // Thread( thrd_name )
     this.mailbox = mailbox ;
     this.numberOfItems = numberOfItems ;

     valuesConsumed = new int[ numberOfItems ] ;

     for (int i = 0; i < numberOfItems; i++) 
     {
       valuesConsumed[i] = -999 ;
     }

  }

  public void run() 
  {

    // int[] valuesConsumed = new int[ numberOfItems + 5 ] ;  // Exercise 10.1 (c).2
    int[] valuesConsumed = new int[ numberOfItems ] ;         // Exercise 10.1 
    int value = 0 ;


    for (int i = 0; i < numberOfItems; i++)   // Exercise 10.1 (a), (b), (c).1, (d)
    // for (int i = 0; i < numberOfItems + 5; i++)   // Exercise 10.1 (c).2
    {
      value = mailbox.take();
      valuesConsumed[i] = value ;      
      System.out.println(getName() + " taken: " + value) ;

      // Added some sleep time
 
      int sleepTime = 500 ;           // Exercise 10.1 (a), (c), (d) 
      // int sleepTime = 1500 ;       // Exercise 10.1 (b) 500 or 1500

      try {
            sleep( (int)( Math.random() * sleepTime ) ) ; 
          } 
      catch (InterruptedException e) { }
 
    }

    // Print out the 10 items that have been consumed
    System.out.print( getName() + " consumed: < " ) ;
    for (int i = 0; i < numberOfItems; i++)              // Exercise 10.1 
    // for (int i = 0; i < numberOfItems+5; i++)         // Exercise 10.1 (c).2 
    {
            System.out.print( valuesConsumed[i] + " " ) ; 
    }
    System.out.println( ">") ;

  }

}


