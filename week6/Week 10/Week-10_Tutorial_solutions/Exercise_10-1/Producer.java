/** 
    File: Producer.java
    Module: 6SENG006W Concurrent Programming
    Author: P. Howells
    Modified: 24/11/22
**/

class Producer extends Thread 
{
  private final Mailbox mailbox ; // Mailbox "interface"
  private final int numberOfItems ;   

  public Producer( Mailbox mailbox, 
                   int Pid, 
                   int numberOfItems ) 
  {
     super( "Producer #" + Pid ) ;  // Thread( thrd_name )

     this.mailbox = mailbox ;

     this.numberOfItems = numberOfItems ;
  }


  public void run() 
  {
    for (int i = 0; i < numberOfItems; i++)     // Exercise 10.1 (a), (b), (c).2, (d)  
    // for (int i = 0; i < numberOfItems + 5 ; i++)   // Exercise 10.1 (c).1 
    {
       mailbox.put(i) ;

       System.out.println(getName() + " put:   " + i) ;

      int sleepTime = 500 ;           // Exercise 10.1 (a), (c), (d) 
      // int sleepTime = 1500 ;       // Exercise 10.1 (b) 500 or 1500

       try {
            sleep( (int)( Math.random() * sleepTime ) ) ;
           } 
       catch (InterruptedException e) { }
    }

  }

}
