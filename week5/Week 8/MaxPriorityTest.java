/** *******************************************************
 **   File:   	MaxPriorityTest.java
 **   Author:	P. Howells
 **   Lecture:	Thread Groups
 **   Modified:	13/11/22
 **
 ******************************************************* **/


class MaxPriorityTest {

  public static void main(String args[]) 
  {

    ThreadGroup groupNORM  = new ThreadGroup("Normal Priority Group");

    Thread priorityMAX = new Thread( groupNORM, "Maximum Priority Thread" ) ;

    // set Thread's priority to max (10)
    priorityMAX.setPriority( Thread.MAX_PRIORITY ) ;

    // set ThreadGroup's max priority to normal (5)
    groupNORM.setMaxPriority( Thread.NORM_PRIORITY ) ;

    System.out.println( "Group's maximum priority = " +
                        groupNORM.getMaxPriority() ) ;

    System.out.println( "Thread's priority = " +
                        priorityMAX.getPriority() ) ;
    }
}
