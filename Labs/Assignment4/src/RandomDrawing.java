import java.util.ArrayList;
class RandomDrawing<T> {

  private ArrayList<T> box;

  public RandomDrawing() {
    box = new ArrayList<T>();
  }

  public void add(T obj) {
    box.add(obj);
  }

  public boolean isEmpty() {
    return (box.size() == 0);
  }

  public T drawItem() {
    if (isEmpty())
      return null;
    int randIndex = (int) (Math.random() * box.size());
    T item = box.get(randIndex);
    box.remove(item);
    return item;
  }
}
