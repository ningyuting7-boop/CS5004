public class Question5RandomDrawing {
  public static void main(String[] args){
    System.out.println("Drawing from the box of integers:");
    RandomDrawing<Integer> intBox = new RandomDrawing<>();
    intBox.add(3);
    intBox.add(10);
    intBox.add(75);
    intBox.add(45);
    for (int j = 0; j < 4; j++) {
      System.out.println(intBox.drawItem());
    }
    System.out.println("Drawing from the box of strings:");
    RandomDrawing<String> stringBox = new RandomDrawing<>();
    stringBox.add("Carol");
    stringBox.add("Bob");
    stringBox.add("Ted");
    stringBox.add("Alice");
    for (int j = 0; j < 4; j++) {
      System.out.println(stringBox.drawItem());
    }
  }
}
