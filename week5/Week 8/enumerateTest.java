/** *******************************************************
 **   File:   	enumerateTest.java
 **   Author:	P. Howells
 **   Lecture:	Thread Groups
 **   Modified:	13/11/22
 **
 ******************************************************* **/

class enumerateTest 
{

  static void listCurrentThreads( ) 
  {

    ThreadGroup currentGroup = Thread.currentThread().getThreadGroup() ;

    int ac_count ;
    int e_count ;
    Thread listOfThreads[] ;

    ac_count = currentGroup.activeCount() ;

    listOfThreads = new Thread[ac_count] ;

    e_count = currentGroup.enumerate( listOfThreads ) ;

    for (int i = 0; i < e_count; i++) 
    {
      System.out.println( "Thread #" + i + " = " + 
			  listOfThreads[i].getName() ) ;
    }

  }

}
