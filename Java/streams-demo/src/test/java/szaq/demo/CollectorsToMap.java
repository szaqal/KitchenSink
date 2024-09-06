package szaq.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToMap {

  @Test
  public void test() {
    var list = List.of(
        new Product(1, "Shirt", 10),
        new Product(2, "Shirt", 10 ),
        new Product(3, "Laptop", 100));


    var result = list.stream().collect(Collectors.toMap(Product::getId, Product::getName));
    System.out.println(result);

    var grouping = list.stream().collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    System.out.println(grouping);


    var summarizing = list.stream().collect(Collectors.groupingBy(Product::getName, Collectors.summarizingInt(Product::getPrice)));
    System.out.println(summarizing);
  }

  @Getter
  @AllArgsConstructor
  private static class Product {
    private int id;
    private String name;
    private int price;
  }
}
