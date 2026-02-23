package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

  private Artist musician;

  @BeforeEach
  void setUp() {
    String[] genres = {"Pop", "Rock"};
    musician = new Musician("Taylor", 30, genres,
        "Universal", "Midnight Album");
  }

  @Test
  void testGetName() {
    assertEquals("Taylor", musician.getName());
  }

  @Test
  void testGetAge() {
    assertEquals(30, musician.getAge());
  }

  @Test
  void testReceiveAward() {
    musician.receiveAward("Grammy");
    assertEquals(1, musician.getAwards().size());
    assertTrue(musician.getAwards().contains("Grammy"));
  }

  @Test
  void testInvalidAgeTooLow() {
    String[] genres = {"Pop"};
    assertThrows(IllegalArgumentException.class, () -> {
      new Musician("Bad", -1, genres, "Company", "Album");
    });
  }

  @Test
  void testInvalidAgeTooHigh() {
    String[] genres = {"Pop"};
    assertThrows(IllegalArgumentException.class, () -> {
      new Musician("Bad", 200, genres, "Company", "Album");
    });
  }
}
