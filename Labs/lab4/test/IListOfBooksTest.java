import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {
  private Book book1;
  private Book book2;
  private Book book3;
  private IListOfBooks empty;
  private IListOfBooks list1;
  private IListOfBooks list2;

  @BeforeEach
  public void setUp() {
    book1 = new Book("Java Basics", "Author A", 2010, 50.0f);
    book2 = new Book("Advanced Java", "Author B", 2022, 75.0f);
    book3 = new Book("AI History", "Author C", 1999, 30.0f);

    empty = new EmptyNode();
    // list1 structure: book1 -> book2 -> empty
    list1 = new ElementNode(book1, new ElementNode(book2, empty));
    // list2 structure: book3 -> empty
    list2 = new ElementNode(book3, empty);
  }

  @Test
  public void testCount() {
    assertEquals(0, empty.count(), "Empty list count should be 0");
    assertEquals(2, list1.count(), "List1 count should be 2");
    assertEquals(1, list2.count(), "List2 count should be 1");
  }

  @Test
  public void testTotalPrice() {
    assertEquals(0.0f, empty.totalPrice(), 0.01, "Empty list price should be 0");
    assertEquals(125.0f, list1.totalPrice(), 0.01, "List1 price should be 50 + 75");
    assertEquals(30.0f, list2.totalPrice(), 0.01, "List2 price should be 30");
  }

  @Test
  public void testToString() {
    assertEquals("", empty.toString(), "Empty string representation should be empty");
    String expected = "(" + book1.toString() + ")(" + book2.toString() + ")";
    assertEquals(expected, list1.toString());
  }

  @Test
  public void testAllBefore() {
    assertEquals("", empty.allBefore(2025).toString(), "Filtering empty list should return empty string");

    IListOfBooks filtered = list1.allBefore(2015);
    String expectedFiltered = "(" + book1.toString() + ")";
    assertEquals(expectedFiltered, filtered.toString(), "Should only contain book1 (2010)");

    assertEquals("", list1.allBefore(2000).toString(), "Should be empty if no books match criteria");
  }

  @Test
  public void testAddAtEnd() {
    IListOfBooks newList = empty.addAtEnd(book1);
    assertEquals("(" + book1.toString() + ")", newList.toString(), "Adding to empty should return a list with one book");

    IListOfBooks longerList = list1.addAtEnd(book3);
    String expectedSequence = "(" + book1.toString() + ")" + "(" + book2.toString() + ")" + "(" + book3.toString() + ")";
    assertEquals(expectedSequence, longerList.toString(), "New book should be at the very end and order preserved");

    assertEquals("(" + book1.toString() + ")(" + book2.toString() + ")", list1.toString());
  }
}
