import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
  private Book book1;
  private Book book2;
  private Book book3;

  @BeforeEach
  void setUp() {
    this.book1 = new Book("Effective Java", "Joshua Bloch", 123);
    this.book2 = new Book("Python Crash Course, 3rd Edition", "Eric Matthes", 680);
    this.book3 = new Book("Fluent Python", "Luciano Ramalho", 577);
  }

  @Test
  void testTitle(){
    Assertions.assertEquals("Effective Java", book1.getTitle());
    Assertions.assertEquals("Fluent Python", book3.getTitle());
  }

  @Test
  void testAuthor(){
    Assertions.assertEquals("Eric Matthes", book2.getAuthor());
    Assertions.assertEquals("Luciano Ramalho", book3.getAuthor());
  }

  @Test
  void testPages(){
    Assertions.assertEquals(123, book1.getPages());
    Assertions.assertEquals(577, book3.getPages());
  }

}
