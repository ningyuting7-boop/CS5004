package problem1;

public abstract class VisualArtist extends Artist{
  private String[] exhibits;

  public VisualArtist(String name, int age, String[] genres, String[] exhibits){
    super(name, age, genres);
    this.exhibits = exhibits;
  }
  public String[] getExhibits(){
    return exhibits;
  }
}
