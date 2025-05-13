package szaqal.alg.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static szaqal.alg.demo.InsertTail.insertNodeAtTail;

public class InsertTailTest {

  @Test
  public void test() {
    InsertTail.SinglyLinkedList llist = new InsertTail.SinglyLinkedList();
    List<Integer> integers = List.of(141, 302, 164, 530, 474);
    for (Integer i : integers) {
      InsertTail.SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, i);
      llist.head = llist_head;
    }

    System.out.println(llist);

  }


}
