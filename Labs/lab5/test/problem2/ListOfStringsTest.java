package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListOfStringsTest {

  private ListOfStrings empty;
  private ListOfStrings listABC;
  private ListOfStrings listWithDup;
  private ListOfStrings listAB;

  @BeforeEach
  void setUp() {
    empty = new EmptyList();

    listABC =
        new NonEmptyList("A",
            new NonEmptyList("BB",
                new NonEmptyList("CCC",
                    new EmptyList())));

    listWithDup =
        new NonEmptyList("A",
            new NonEmptyList("BB",
                new NonEmptyList("A",
                    new EmptyList())));

    listAB =
        new NonEmptyList("A",
            new NonEmptyList("BB",
                new EmptyList()));
  }

  // ------------------ isEmpty ------------------

  @Test
  void testIsEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(listABC.isEmpty());
  }

  // ------------------ size ------------------

  @Test
  void testSize() {
    assertEquals(0, empty.size());
    assertEquals(3, listABC.size());
  }

  // ------------------ contains ------------------

  @Test
  void testContains() {
    assertTrue(listABC.contains("A"));
    assertTrue(listABC.contains("BB"));
    assertFalse(listABC.contains("XYZ"));
  }

  // ------------------ containsAll ------------------

  @Test
  void testContainsAll() {
    assertTrue(listABC.containsAll(listAB));
    assertFalse(listAB.containsAll(listABC));
    assertTrue(listABC.containsAll(empty));
  }

  // ------------------ filterLargerThan ------------------

  @Test
  void testFilterLargerThan() {
    ListOfStrings filtered = listABC.filterLargerThan(2);

    assertTrue(filtered.contains("A"));
    assertTrue(filtered.contains("BB"));
    assertFalse(filtered.contains("CCC"));
    assertEquals(2, filtered.size());
  }

  // ------------------ hasDuplicates ------------------

  @Test
  void testHasDuplicates() {
    assertFalse(listABC.hasDuplicates());
    assertTrue(listWithDup.hasDuplicates());
  }

  // ------------------ removeDuplicates ------------------

  @Test
  void testRemoveDuplicates() {
    ListOfStrings noDup = listWithDup.removeDuplicates();

    assertFalse(noDup.hasDuplicates());
    assertEquals(2, noDup.size());
    assertTrue(noDup.contains("A"));
    assertTrue(noDup.contains("BB"));
  }
}
