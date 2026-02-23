/**
 * This represents an empty node in the list
 */
public class EmptyNode implements IListOfBooks {
  @Override
  public int count() { return 0;}

  @Override
  //the base case
  public String toString() { return "";}

  @Override
  public float totalPrice() { return 0.0f;}

  //base case
  @Override
  public IListOfBooks allBefore(int year) { return new EmptyNode(); }



  @Override
  public IListOfBooks addAtEnd(Book newBook){
    return new ElementNode(newBook, this);
  }
}

