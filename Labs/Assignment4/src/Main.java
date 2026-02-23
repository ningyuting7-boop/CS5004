import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Student[] alist = {
        new Student("C", 3),
        new Student("A", 4),
        new Student("B", 1),
        new Student("E", 5),
        new Student("D", 2),
    };
    Arrays.sort(alist);
    for (Student s: alist){
      System.out.println(s);
    }
  }
}
