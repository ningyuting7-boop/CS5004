package problem2;

public class NonEmptyList implements ListOfStrings{

  private String first;
  private ListOfStrings rest;

  public NonEmptyList(String first, ListOfStrings rest){
    this.first = first;
    this.rest = rest;
  }
  public String getFirst() {return first;}
  @Override
  public boolean isEmpty() {return false;}
  @Override
  public int size(){return 1 + rest.size();}
  @Override
  public boolean contains(String s){
    return first.equals(s) || rest.contains(s);
  }

  @Override
  public boolean containsAll(ListOfStrings other){
    if(other.isEmpty()){
      return true;
    }
    NonEmptyList otherList = (NonEmptyList) other;
    return this.contains(otherList.getFirst()) && this.containsAll(otherList.rest);
  }

  @Override
  public ListOfStrings filterLargerThan(int maxLength){
    if (first.length() > maxLength) {
      return rest.filterLargerThan(maxLength);
    }
    return new NonEmptyList(first, rest.filterLargerThan(maxLength));
  }

  @Override
  public boolean hasDuplicates() {
    return rest.contains(first) || rest.hasDuplicates();
  }

  @Override
  public ListOfStrings removeDuplicates(){
    // first dedup
    ListOfStrings dedupedList = rest.removeDuplicates();
    if (dedupedList.contains(first)){
      return dedupedList;
    }
    return new NonEmptyList(first, dedupedList);
  }
}
