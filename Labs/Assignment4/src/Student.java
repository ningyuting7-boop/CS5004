public class Student implements Comparable<Object>{
  private String lastName;
  private long ID;

  public Student(String lastName, long ID){
    this.lastName = lastName;
    this.ID = ID;
  }

  public String getLastName() {
    return lastName;
  }

  public long getID(){
    return ID;
  }

  public void setLastName(String newLastName){
    lastName = newLastName;
  }

  public void setID(long newID){
    ID = newID;
  }

  // compareTo, object of subclass is allowed
  // equals, object of subclass is not allowed
  @Override
  public int compareTo(Object other) {
    if (other == null) {
      throw new NullPointerException();
    }
    if (!(other instanceof Student)){
      throw new IllegalArgumentException();
    }
    Student otherStudent = (Student)other;
    return lastName.compareTo(otherStudent.getLastName());
  }

  @Override
  public String toString(){
    return lastName + "(" + ID + ")";
  }
}
