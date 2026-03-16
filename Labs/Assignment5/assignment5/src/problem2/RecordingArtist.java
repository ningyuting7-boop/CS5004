package problem2;

public class RecordingArtist extends Creator{
  private String firstName;
  private String lastName;

  public RecordingArtist(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName(){return firstName;}
  public String getLastName(){return lastName;}

  public boolean equals(Object other){
    if (this == other) return true;
    if (!(other instanceof RecordingArtist)) return false;
    RecordingArtist o = (RecordingArtist) other;
    if (o.getFirstName().equals(firstName) && o.getLastName().equals(lastName)){
      return true;
    }
    return false;
  }
}
