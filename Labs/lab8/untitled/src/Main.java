import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static final String FILE_NAME = "students.txt";
  private static ArrayList<Student> studentList = new ArrayList<>();

  public static void main(String[] args) {
    loadFromFile();
    printAllStudents();
    Scanner console = new Scanner(System.in);
    boolean running = true;
    while (running) {
      displayMenu();
      int choice = getIntInput(console);
      console.nextLine();
      switch (choice) {
        case 1:
          addStudent(console);
          printAllStudents();
          break;
        case 2:
          removeStudent(console);
          printAllStudents();
          break;
        case 3:
          searchStudent(console);
          break;
        case 4:
          running = false;
          System.out.println("Program finished.");
          break;
        default:
          System.out.println("Invalid choice, please try again.");
      }
    }
  }


  private static void loadFromFile() {
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.trim().isEmpty()) continue;
        String[] data = line.split(" ");
        if (data.length == 4) {
          studentList.add(new Student(data[0], data[1], data[2], data[3]));
        }
      }
    } catch (IOException e) {
      System.out.println("Error: Could not read students.txt. Starting with empty list.");
    }
  }

  private static void saveToFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
      for (Student s : studentList) {
        bw.write(s.toFileFormat());
        bw.newLine();
      }
    } catch (IOException e) {
      System.out.println("Error: Could not update the file.");
    }
  }

  // print student list
  private static void printAllStudents() {
    System.out.println("\n--- Current Student List ---");
    for (int i = 0; i < studentList.size(); i++) {
      System.out.println("Line " + (i + 1) + ": " + studentList.get(i));
    }
  }

  // menu1: add student
  private static void addStudent(Scanner console) {
    System.out.println("\nAdding a new student...");
    System.out.print("Enter First Name: ");
    String fn = console.next();
    System.out.print("Enter Last Name: ");
    String ln = console.next();
    System.out.print("Enter Student ID: ");
    String id = console.next();
    System.out.print("Enter Email: ");
    String email = console.next();

    // create a new student
    studentList.add(new Student(fn, ln, id, email));
    // update students.txt
    saveToFile();
    System.out.println("Student added and file updated.");
  }

  // menu 2: remove student
  private static void removeStudent(Scanner console) {
    System.out.print("\nEnter Student ID to remove: ");
    String targetID = console.next();

    boolean found = studentList.removeIf(s -> s.getStudentID().equals(targetID));

    if (found) {
      saveToFile();
      System.out.println("Student with ID " + targetID + " removed and file updated.");
    } else {
      System.out.println("Error: Student with ID " + targetID + " does not exist.");
    }
  }

  // menu 3: search a student
  private static void searchStudent(Scanner console) {
    System.out.print("\nEnter Student ID to search: ");
    String targetID = console.next();

    for (Student s : studentList) {
      if (s.getStudentID().equals(targetID)) {
        System.out.println("Student Found: " + s);
        return;
      }
    }
    System.out.println("Error: Student with ID " + targetID + " does not exist.");
  }

  private static void displayMenu() {
    System.out.println("\n********** Menu **********");
    System.out.println("1. Add a student");
    System.out.println("2. Remove a student by ID");
    System.out.println("3. Search for a student by ID");
    System.out.println("4. Exit");
    System.out.print("Please enter your choice: ");
  }

  private static int getIntInput(Scanner console) {
    while (!console.hasNextInt()) {
      System.out.println("Invalid input. Please enter a number.");
      console.next();
    }
    return console.nextInt();
  }
}
