package problem2;

/**
 * Represents an item in the library catalog.
 * An item has a creator, a title, and the year it was released or published.
 * This class serves as the base class for specific item types such as
 * books and music.
 */
public class Item {

  /** The creator of the item (e.g., author, recording artist, or band). */
  protected Creator creator;

  /** The title of the item. */
  protected String title;

  /** The year the item was released or published. */
  protected int year;

  /**
   * Constructs an Item with the given creator, title, and year.
   *
   * @param creator the creator of the item
   * @param title the title of the item
   * @param year the year the item was released or published
   */
  public Item(Creator creator, String title, int year){
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  /**
   * Returns the creator of this item.
   *
   * @return the creator
   */
  public Creator getCreator() {
    return creator;
  }

  /**
   * Returns the title of this item.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the year the item was released or published.
   *
   * @return the year
   */
  public int getYear() {
    return year;
  }
}
