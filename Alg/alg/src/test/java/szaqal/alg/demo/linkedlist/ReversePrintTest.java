package szaqal.alg.demo.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static szaqal.alg.demo.linkedlist.InsertTail.insertNodeAtTail;

public class ReversePrintTest {

  @Test
  public void test() {
    SinglyLinkedList llist = new SinglyLinkedList();
    List<Integer> integers = List.of(141, 302, 164, 530, 474);
    for (Integer i : integers) {
      SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, i);
      llist.head = llist_head;
    }
    ReversePrint.reversePrint(llist.head);
  }
}
