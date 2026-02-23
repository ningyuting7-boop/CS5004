package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultimediaArtistTest {

  @Test
  void testActorConstructor() {
    String[] genres = {"Drama"};
    String[] movies = {"Movie1"};
    String[] series = {"Series1"};
    String[] other = {"Commercial"};

    Actor actor = new Actor("Tom", 40, genres, movies, series, other);

    assertEquals("Tom", actor.getName());
    assertEquals(40, actor.getAge());
    assertArrayEquals(movies, actor.getMovies());
    assertArrayEquals(series, actor.getSeries());
    assertArrayEquals(other, actor.getOtherMultimedia());
  }
}
