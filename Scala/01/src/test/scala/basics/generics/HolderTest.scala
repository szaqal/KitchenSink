package basics.generics

import org.scalatest.FunSuite
import basics.variance.Item
import basics.variance.ItemHolder

class HolderTest extends FunSuite {
  test("HolderTest") {
    assert(new Holder(10).item == 10);
  }

  test("HolderTest1") {
    assert(HolderContainer(new Holder(10)).item.item == 10);
  }

  test("HolderTest2") {
    assert(HolderContainer(new SubHolder(10)).item.item == 10);
  }

  test("ItemHolderTest1") {
    val item = new ItemHolder(new Item("GGG"))
    assert(item.getItem(new Item("item")).msg == "item")
  }

}