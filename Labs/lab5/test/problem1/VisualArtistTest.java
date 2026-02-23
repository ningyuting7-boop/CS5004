package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VisualArtistTest {

  @Test
  void testPainterConstructor() {
    String[] genres = {"Modern"};
    String[] exhibits = {"NY Gallery"};

    Painter painter = new Painter("Amy", 35, genres, exhibits);

    assertEquals("Amy", painter.getName());
    assertEquals(35, painter.getAge());
    assertArrayEquals(exhibits, painter.getExhibits());
  }
}
