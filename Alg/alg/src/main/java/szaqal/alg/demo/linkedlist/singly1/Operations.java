package szaqal.alg.demo.linkedlist.singly1;

//https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
public class Operations {

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

  public static SinglyLinkedListNode insertNodeAtPosition(
      SinglyLinkedListNode head,
      int data,
      int position ) {

    SinglyLinkedListNode current = head;
    for (int i = 0; i < position - 1; i++) {
      current = current.next;
    }
    SinglyLinkedListNode toInsert = new SinglyLinkedListNode(data);
    toInsert.next = current.next;
    current.next = toInsert;
    return head;
  }
}

