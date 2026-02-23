package problem2;

public class EmptyList implements ListOfStrings{
  @Override
  public boolean isEmpty() {return true;}
  @Override
  public int size(){return 0;}
  @Override
  public boolean contains(String s){return false;}
  @Override
  public boolean containsAll(ListOfStrings other){ return true;}
  @Override
  public ListOfStrings filterLargerThan(int maxLength){
    return this;
  }
  @Override
  public boolean hasDuplicates() {return false;}
  @Override
  public ListOfStrings removeDuplicates(){
    return this;
  }
}
