package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Test;
import szaqal.alg.demo.misc.Dummy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTest {

  @Test
  public void testCharDups() {
    List<Character> characters = Dummy.characterDups("AAABBC");
    assertEquals('A', characters.get(0));
    assertEquals('B', characters.get(1));
  }

  @Test
  public void testAnagram() {
    assertTrue(Dummy.isAnagram("word", "wrdo"));
    assertTrue(Dummy.isAnagram("mary", "army"));
    assertTrue(Dummy.isAnagram("stop", "tops"));
    assertTrue(Dummy.isAnagram("boat", "btoa"));
    assertFalse(Dummy.isAnagram("pure", "in"));
    assertFalse(Dummy.isAnagram("fill", "fil"));
    assertFalse(Dummy.isAnagram("b", "bbb"));
    assertFalse(Dummy.isAnagram("ccc", "ccccccc"));
    assertTrue(Dummy.isAnagram("a", "a"));
    assertFalse(Dummy.isAnagram("sleep", "slep"));
  }

  @Test
  public void testVovels() {
    assertEquals(1, Dummy.vovelsCount("Hi"));
  }
}
