package szaqal.alg.demo.linkedlist.singly1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static szaqal.alg.demo.linkedlist.singly1.Operations.insertNodeAtPosition;
import static szaqal.alg.demo.linkedlist.singly1.Operations.insertNodeAtTail;

public class OperationsTest {

  @Test
  public void test() {
    SinglyLinkedList llist = new SinglyLinkedList();
    List<Integer> integers = List.of(141, 302, 164, 530, 474);
    for (Integer i : integers) {
      SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, i);
      llist.head = llist_head;
    }

    System.out.println(llist);

  }

  @Test
  public void test2() {
    SinglyLinkedList llist = new SinglyLinkedList();
    List<Integer> integers = List.of(141, 302, 164, 530, 474);
    SinglyLinkedListNode llist_head = null;
    for (Integer i : integers) {
      llist_head = insertNodeAtTail(llist.head, i);
      llist.head = llist_head;
    }
    SinglyLinkedListNode singlyLinkedListNode = insertNodeAtPosition(llist.head, -10, 1);
    System.out.println(singlyLinkedListNode);
  }
}
