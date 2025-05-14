package szaqal.alg.demo.linkedlist;


//https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
public class InsertTail {




  static SinglyLinkedListNode insertNodeAtTail(
      SinglyLinkedListNode head,
      int data ) {

    if (head == null) {
      return new SinglyLinkedListNode(data);
    } else if (head.next != null) {
      insertNodeAtTail(head.next, data);
    } else {
      head.next = new SinglyLinkedListNode(data);
    }
    return head;
  }
}
