/** *******************************************************
 **   File:   	RaceTest.java
 **   Author:	P. Howells
 **   Lecture:	Thread Scheduling
 **   Modified:	13/11/22
 **
 ******************************************************* **/

class RaceTest 
{

    final static int NumRunners = 2;

    public static void main(String args[]) 
    {

	SelfishRunner runners[] = new SelfishRunner[NumRunners];

	for (int i = 0; i < NumRunners; i++) 
	    {
		runners[i] = new SelfishRunner(i);

		runners[i].setPriority(2);
	    }

		// runners[0].setPriority(10);
		// runners[1].setPriority(1);

	for (int i = 0; i < NumRunners; i++) 
	    {
		runners[i].start();
	    }
	
    }

}
