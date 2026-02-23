package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PoetTest {

  @Test
  void testPoetConstructor() {
    String[] genres = {"Romantic"};

    Poet poet = new Poet("Emily", 45, genres,
        "Penguin", "Love Poems");

    assertEquals("Emily", poet.getName());
    assertEquals(45, poet.getAge());
  }
}
