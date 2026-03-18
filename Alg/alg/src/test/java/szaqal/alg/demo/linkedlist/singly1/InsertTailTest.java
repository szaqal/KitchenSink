package szaqal.alg.demo.linkedlist.singly1;

import org.junit.jupiter.api.Test;
import szaqal.alg.demo.linkedlist.singly1.SinglyLinkedList;
import szaqal.alg.demo.linkedlist.singly1.SinglyLinkedListNode;

import java.util.List;

import static szaqal.alg.demo.linkedlist.singly1.InsertTail.insertNodeAtTail;

public class InsertTailTest {

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


}
