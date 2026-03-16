public class Program1 {

  /**
   * print a list of object, each element is separated by a comma and a white space
   * @param aList, a list of object
   */
  public static void printArray(Object [] aList){
    for(Object o: aList){
      System.out.print(o.toString() + ", ");
    }
    System.out.println();
  }

  /**
   * test printArray(), when object is int, double, char or String in main
   */
  public static void main(String[] arg){
    Integer[] intArry = {1, 2, 3, 4, 5};
    Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
    Character[] charArry = {'H', 'E', 'L', 'L', 'O'};
    String[] strArry = {"once", "upon", "a", "time"};
    printArray(intArry);
    printArray(doubArry);
    printArray(charArry);
    printArray(strArry);
  }
}
