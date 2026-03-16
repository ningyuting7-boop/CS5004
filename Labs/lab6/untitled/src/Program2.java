public class Program2 {
  public static void printArray(Integer [] aList){
    for(Integer e: aList){
      System.out.print(e + ", ");
    }
    System.out.println();
  }

  public static void printArray(Character [] aList){
    for(Character e: aList){
      System.out.print(e + ", ");
    }
    System.out.println();
  }

  public static void printArray(Double [] aList){
    for(Double e: aList){
      System.out.print(e + ", ");
    }
    System.out.println();
  }

  public static void printArray(String [] aList){
    for(String e: aList){
      System.out.print(e + ", ");
    }
    System.out.println();
  }

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
