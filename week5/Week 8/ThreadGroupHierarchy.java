/** *******************************************************
 **   File:   	ThreadGroupHierarchy.java
 **   Author:	P. Howells
 **   Lecture:	Thread Groups
 **   Modified:	13/11/22
 **
 ******************************************************* **/

class ThreadGroupHierarchy
{

  public static void main(String args[]) 
  {

      final int NUM_GROUPS  = 6 ; 
      final int NUM_THREADS = 7 ;

      final int TwoSeconds = 2000 ;

      ThreadGroup groups[] ;
      Thread      threads[] ;

      groups  = new ThreadGroup[NUM_GROUPS] ;
      threads = new Thread[NUM_THREADS] ;

      // get ``main'' system group
      groups[0] = Thread.currentThread().getThreadGroup() ;

      // create the thread group hierarchy
      groups[1] = new ThreadGroup(groups[0], "Thread Group A");
      groups[2] = new ThreadGroup(groups[0], "Thread Group B");
      groups[3] = new ThreadGroup(groups[0], "Thread Group C");
      
      groups[4] = new ThreadGroup(groups[2], "Thread Group B1");
      groups[5] = new ThreadGroup(groups[2], "Thread Group B2");


      // create the threads & place them in the hierarchy
      threads[0] = new TGHthread( groups[0], "Thread 1" ) ;
      
      threads[1] = new TGHthread( groups[1], "Thread 2" ) ;
      threads[2] = new TGHthread( groups[1], "Thread 3" ) ;
      
      threads[3] = new TGHthread( groups[3], "Thread 4" ) ;
      
      threads[4] = new TGHthread( groups[4], "Thread 5" ) ;
      threads[5] = new TGHthread( groups[4], "Thread 6" ) ;

      threads[6] = new TGHthread( groups[5], "Thread 7" ) ;
      

      System.out.println() ;
      System.out.println( "TG Hierarchy before starting threads" ) ;   
      listCurrentThreadGroups( ) ;
      System.out.println() ;
      listCurrentThreads( ) ;

      // start the threads

      for ( int i = 0; i < NUM_THREADS; i++ )
	  {
	      threads[i].start() ;
	  }

      System.out.println() ;
      System.out.println( "TG Hierarchy after starting threads" ) ;     
      listCurrentThreadGroups( ) ;
      System.out.println() ;
      listCurrentThreads( ) ;
      System.out.println() ;

  }


  static void listCurrentThreads( ) 
  {

    ThreadGroup currentGroup = Thread.currentThread().getThreadGroup() ;

    // Count threads 
    int ac_count ;
    int e_count ;
    Thread listOfThreads[] ;

    ac_count = currentGroup.activeCount() ;

    listOfThreads = new Thread[ac_count] ;

    e_count = currentGroup.enumerate( listOfThreads ) ;

    System.out.println( "TG Hierarchy Threads: ac_count = " + ac_count + 
                                              ", e_count = " + e_count ) ; 

    for (int i = 0; i < e_count; i++) 
    {
      System.out.println( "Thread #" + i + " = " + 
			  listOfThreads[i].getName() ) ;
    }

  }



  static void listCurrentThreadGroups( ) 
  {

    ThreadGroup currentGroup = Thread.currentThread().getThreadGroup() ;

   // count thread groups

    int ac_tgcount ;
    int e_tgcount ;
    ThreadGroup listOfThreadGroups[] ;
   

    ac_tgcount = currentGroup.activeGroupCount​() ;

    listOfThreadGroups = new ThreadGroup[ac_tgcount] ;

    e_tgcount = currentGroup.enumerate( listOfThreadGroups ) ;

    System.out.println( "TG Hierarchy: ac_tgcount = " + ac_tgcount + ", e_tgcount = " + e_tgcount ) ; 

    for (int i = 0; i < e_tgcount; i++) 
    {
      System.out.println( "ThreadGroup #" + i + " = " + 
			  listOfThreadGroups[i].getName() ) ;
    }

  }



}
