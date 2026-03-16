package problem2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogTest {

  @Test
  public void testSearchByKeyword_case1() {
    Author author1 = new Author("George", "Orwell");
    Book book1 = new Book(author1, "1984", 1949);

    RecordingArtist artist1 = new RecordingArtist("Freddie", "Mercury");
    Music music1 = new Music(artist1, "Bohemian Rhapsody", 1975);

    Catalog catalog = new Catalog();
    catalog.addItem(book1);
    catalog.addItem(music1);

    List<Item> results = catalog.search("1984");
    assertEquals(1, results.size());
    assertEquals("1984", results.get(0).getTitle());
  }

  @Test
  public void testSearchByKeyword_case2() {
    Author author2 = new Author("J.K.", "Rowling");
    Book book2 = new Book(author2, "Harry Potter and the Chamber of Secrets", 1998);

    RecordingArtist artist2 = new RecordingArtist("Adele", "Adkins");
    Music music2 = new Music(artist2, "Hello", 2015);

    Catalog catalog = new Catalog();
    catalog.addItem(book2);
    catalog.addItem(music2);

    List<Item> results = catalog.search("harry");
    assertEquals(1, results.size());
    assertEquals("Harry Potter and the Chamber of Secrets", results.get(0).getTitle());
  }

  @Test
  public void testSearchByAuthor_case1() {
    Author author = new Author("George", "Orwell");
    Book book1 = new Book(author, "1984", 1949);
    Book book2 = new Book(author, "Animal Farm", 1945);

    Catalog catalog = new Catalog();
    catalog.addItem(book1);
    catalog.addItem(book2);

    List<Item> results = catalog.search(author);
    assertEquals(2, results.size());
  }

  @Test
  public void testSearchByAuthor_case2() {
    Author author1 = new Author("J.R.R.", "Tolkien");
    Author author2 = new Author("C.S.", "Lewis");
    Book book1 = new Book(author1, "The Hobbit", 1937);
    Book book2 = new Book(author2, "The Chronicles of Narnia", 1950);

    Catalog catalog = new Catalog();
    catalog.addItem(book1);
    catalog.addItem(book2);

    List<Item> results = catalog.search(author2);
    assertEquals(1, results.size());
    assertEquals("The Chronicles of Narnia", results.get(0).getTitle());
  }

  @Test
  public void testSearchByRecordingArtist_case1() {
    RecordingArtist artist = new RecordingArtist("Freddie", "Mercury");
    Music music1 = new Music(artist, "Bohemian Rhapsody", 1975);
    Music music2 = new Music(artist, "Somebody to Love", 1976);

    Catalog catalog = new Catalog();
    catalog.addItem(music1);
    catalog.addItem(music2);

    List<Item> results = catalog.search(artist);
    assertEquals(2, results.size());
  }

  @Test
  public void testSearchByRecordingArtist_case2() {
    RecordingArtist artist1 = new RecordingArtist("Adele", "Adkins");
    RecordingArtist artist2 = new RecordingArtist("Ed", "Sheeran");

    Music music1 = new Music(artist1, "Hello", 2015);
    Music music2 = new Music(artist2, "Shape of You", 2017);

    Catalog catalog = new Catalog();
    catalog.addItem(music1);
    catalog.addItem(music2);

    List<Item> results = catalog.search(artist2);
    assertEquals(1, results.size());
    assertEquals("Shape of You", results.get(0).getTitle());
  }
}
