class Student {
  String firstName;
  String lastName;
  String id;
  String email;

  public Student(String firstName, String lastName, String id, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.email = email;
  }

  public String getStudentID() {return id;}

  public String toFileFormat() {
    return firstName + " " + lastName + " " + id + " " + email;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName + " " + id + " " + email;
  }
}