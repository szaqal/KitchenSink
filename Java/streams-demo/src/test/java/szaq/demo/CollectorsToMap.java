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
        new Product(1, "Shirt"),
        new Product(2, "Shirt"),
        new Product(3, "Laptop"));


    var result = list.stream().collect(Collectors.toMap(Product::getId, Product::getName));
    System.out.println(result);

    Map<String, Long> grouping = list.stream().collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    System.out.println(grouping);
  }

  @Getter
  @AllArgsConstructor
  private static class Product {
    private Integer id;
    private String name;
  }
}
