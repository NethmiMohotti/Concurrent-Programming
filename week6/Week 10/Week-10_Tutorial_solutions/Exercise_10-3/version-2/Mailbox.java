/** 
   File: MailBox.java
   Author: P. Howells
   Module: 6SENG006W Concurrent Programming
   Modified: 24/11/22 
**/


interface Mailbox
{
    public int take( ) ;
    
    public void put( int value ) ;
}
