package szaqal.alg.demo.linkedlist;

//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem?isFullScreen=true
public class LinkedListPrint {
  public static void reversePrint( SinglyLinkedListNode llist ) {
    if (llist.next != null) {
      reversePrint(llist.next);
    }
    System.out.println(llist.data);
  }

  public static void printLinkedList( SinglyLinkedListNode head ) {
    System.out.println(head.data);
    if (head.next != null) {
      printLinkedList(head.next);
    }
  }
}
