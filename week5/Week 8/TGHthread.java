/** 
 *******************************************************
 **   File:   	TGHthread.java
 **   Author:	P. Howells
 **   Lecture:	7 Thread Groups - Thread for group hierarchy 
 **   Modified:	13/11/22
 **
 ******************************************************* 
**/


class TGHthread extends Thread 
{

   final int OneSecond = 1000 ;

   public TGHthread( ThreadGroup tg, String name ) 
   {
      super( tg, name ) ;           
   }                           


   public void run()           
   {
      System.out.println( getName() + ": RUNNING" ) ;

//      for (int i = 0; i < 10; i++) 
//      {
//        System.out.println( getName() + "[TG = " + getThreadGroup() + "]: " + i ) ;

        System.out.println( getName() + "[TG = " + getThreadGroup().getName() + "]" ) ;
         try {
                sleep( (int) ( /* Math.random() */ 2 * OneSecond) ) ;
             } 
         catch (InterruptedException e) {}

//      }

      System.out.println( getName() + ": TERMINATING" ) ;

   }

} // TGHthread
