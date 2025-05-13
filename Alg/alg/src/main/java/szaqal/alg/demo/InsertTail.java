package szaqal.alg.demo;


//https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
public class InsertTail {

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode( int nodeData ) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;

    public SinglyLinkedList() {
      this.head = null;
    }

  }

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
