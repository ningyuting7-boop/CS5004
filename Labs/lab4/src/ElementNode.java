/**
 * This represents a non-empty node of the list. It contains a piece of data
 * along with the rest of the list
 */
public class ElementNode implements IListOfBooks {
  private Book book;
  private IListOfBooks rest;

  public ElementNode(Book book, IListOfBooks rest){
    this.book = book;
    this.rest = rest;
  }

  @Override
  public int count() { return 1 + rest.count(); }

  @Override
  public String toString(){
    return "(" + book.toString() + ")" + rest.toString();
  }

  @Override
  public float totalPrice(){
    return book.getPrice() + rest.totalPrice();
  }

  @Override
  public IListOfBooks allBefore(int year){
    if (book.before(year)) {
      return new ElementNode(this.book, this.rest.allBefore(year));
    } else {
      return rest.allBefore(year);
    }
  }
/*
  public IListOfBooks insertAt(int index, Book book){
    if (index > this.count() || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      return new ElementNode(book, this);
    }
    return new ElementNode(this.book, this.rest.insertAt(index - 1, book));
  }
 */

  @Override
  public IListOfBooks addAtEnd(Book newBook){
    return new ElementNode(book, rest.addAtEnd(newBook));
  }
}


