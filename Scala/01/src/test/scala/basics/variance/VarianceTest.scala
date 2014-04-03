package basics.variance

import org.scalatest.FunSuite

class VarianceTest extends FunSuite {
  
  test("VarianceTest") {
    val item = new ItemHolder(new Item("GGG"))
    //item.getItem returns Item()
    assert(item.getItem(new SubItem("item")).msg == "item")
  }
  
  
  test("VarianceTest2") {
	 assert(new ItemHolderCovariant[SubItem]().getItem(new SubItem("Item")).message == "Item");
	 //new ItemHolderCovariant[SubItem]().getItem(new Item("Item")).message == "Item" <--Won't compile as expected
  }
}