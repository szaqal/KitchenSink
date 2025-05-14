package szaqal.alg.demo.linkedlist;

//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem?isFullScreen=true
public class ReversePrint {
  public static void reversePrint( SinglyLinkedListNode llist ) {

    if(llist.next != null ) {
      reversePrint(llist.next);
    }
    System.out.println(llist.data);
  }

}
