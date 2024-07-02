/** *******************************************************
 **   File:   	SelfishRunner.java
 **   Author:	P. Howells
 **   Lecture:	Java Scheduling
 **   Created:	11/3/04
 **   Modified:	18/11/21
 **
 ******************************************************* **/

class SelfishRunner extends Thread 
{

   public int tick = 1 ;


   SelfishRunner( int id ) 
   { 
       super( "SelfishRunner-" + id ) ;
   }


   public void run() 
   {
      while (tick < 400000) 
      {
	  tick++ ;

           // yield() ;
		
	  if ( ( tick % 50000 ) == 0 ) 
	  {
	      System.out.println( getName() + ": tick = " + tick ) ;
         
             // yield() ;
	  }    
      }
   }

}
