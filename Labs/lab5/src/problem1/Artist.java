package problem1;
import java.util.ArrayList;

/**
 * the class represents an artist with a name, an age, a list of genres and a list of awards
 * the class import ArrayList
 */
public abstract class Artist {
  // field
  private String name;
  private int age;
  private String[] genres;
  private ArrayList<String> awards;
  // constructor

  /**
   * constructs an artist with a name, an age, a list of genres and a list of awards
   * @param name: name of this artist
   * @param age: age of this artist
   * @param genres: a list of genres
   */
  public Artist(String name, int age, String[] genres){
    this.name = name;
    if (age < 0 || age > 128){
      throw new IllegalArgumentException();
    }
    this.age = age;
    this.genres = genres;
    this.awards = new ArrayList<>();
  }

  protected Artist() {
  }

  public String getName() { return name;}
  public int getAge() { return age;}
  public String[] getGenres() { return genres;}
  public ArrayList<String> getAwards() { return awards;}

  public void setName(String newName){
    name = newName;
  }

  public void setAge(int newAge){
    if (newAge < 0 || newAge > 128){
      throw new IllegalArgumentException();
    }
    this.age = newAge;
  }

  /**
   * append a new award to the list of awards
   * @param award: the new award that this artist received
   */
  public void receiveAward(String award){
    awards.add(award);
  }
}
