package problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a catalog that stores a collection of library items
 * (such as books and music) and provides search functionality.
 */
public class Catalog {

  /** The collection of items in the catalog */
  private List<Item> items;

  /**
   * Constructs an empty catalog.
   */
  public Catalog() {
    items = new ArrayList<>();
  }

  /**
   * Constructs a catalog initialized with the provided collection of items.
   *
   * @param items the initial list of items to include in the catalog
   */
  public Catalog(List<Item> items) {
    this.items = new ArrayList<>(items);
  }

  /**
   * Adds an item to the catalog.
   *
   * @param item the item to be added
   */
  public void addItem(Item item) {
    items.add(item);
  }

  /**
   * Removes an item from the catalog.
   *
   * @param item the item to be removed
   */
  public void removeItem(Item item) {
    items.remove(item);
  }

  /**
   * Searches for items whose titles contain the given keyword.
   * The search is case-insensitive.
   *
   * @param keyword the keyword to search for in item titles
   * @return a list of items whose titles contain the keyword
   */
  public List<Item> search(String keyword) {
    ArrayList<Item> res = new ArrayList<>();
    for (Item each : items) {
      if (each.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        res.add(each);
      }
    }
    return res;
  }

  /**
   * Searches for all books written by the specified author.
   *
   * @param author the author to search for
   * @return a list of books written by the given author
   */
  public List<Item> search(Author author) {
    ArrayList<Item> res = new ArrayList<>();
    for (Item each : items) {
      if (each.getClass() == Book.class && each.getCreator().equals(author)) {
        res.add(each);
      }
    }
    return res;
  }

  /**
   * Searches for all music items created by the specified recording artist.
   * The artist may either be the sole creator of the music or a member of a band
   * that created the music.
   *
   * @param artist the recording artist to search for
   * @return a list of music items associated with the given artist
   */
  public List<Item> search(RecordingArtist artist) {
    ArrayList<Item> res = new ArrayList<>();

    for (Item item : items) {
      if (item instanceof Music) {

        Creator creator = item.getCreator();

        if (creator.equals(artist)) {
          res.add(item);
        }

        if (creator instanceof Band) {
          Band band = (Band) creator;
          if (band.getMembers().contains(artist)) {
            res.add(item);
          }
        }
      }
    }

    return res;
  }
}