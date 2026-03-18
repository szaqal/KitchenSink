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
    assertFalse(Dummy.isAnagram("aab", "abb"));

    assertTrue(Dummy.isAnagram2("word", "wrdo"));
    assertTrue(Dummy.isAnagram2("mary", "army"));
    assertTrue(Dummy.isAnagram2("stop", "tops"));
    assertTrue(Dummy.isAnagram2("boat", "btoa"));
    assertFalse(Dummy.isAnagram2("pure", "in"));
    assertFalse(Dummy.isAnagram2("fill", "fil"));
    assertFalse(Dummy.isAnagram2("b", "bbb"));
    assertFalse(Dummy.isAnagram2("ccc", "ccccccc"));
    assertTrue(Dummy.isAnagram2("a", "a"));
    assertFalse(Dummy.isAnagram2("sleep", "slep"));
    assertFalse(Dummy.isAnagram2("aab", "abb"));
  }

  @Test
  public void testVovels() {
    assertEquals(1, Dummy.vovelsCount("Hi"));
  }
}
