package szaq.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Reduce {

  @Test
  public void test() {
    List<Integer> input = List.of(10, 11, 23, 23);
    input.stream().reduce(( integer, integer2 ) -> integer * integer2).ifPresent(System.out::println);
  }

  @Test
  public void test2() {
    List<Account> input = List.of(new Account("Adam", 100), new Account("Adam", 200));
    var result = input.stream().reduce(new Account("summed", 0), ( x, y ) -> new Account("summed1", x.getBalance() + y.getBalance()));
    Assertions.assertEquals(result.getBalance(), 300);
  }

  @Getter
  @AllArgsConstructor
  private static class Account {
    private String owner;
    private Integer balance;
  }
}
