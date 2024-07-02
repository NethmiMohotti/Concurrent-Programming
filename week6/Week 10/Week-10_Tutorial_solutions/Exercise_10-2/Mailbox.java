/** 
    File: MailBox.java
    Module: 6SENG006W Concurrent Programming
    Author: P. Howells
    Modified: 24/11/22 
**/


interface Mailbox
{
    public int take( ) ;
    
    public void put( int value ) ;
}
