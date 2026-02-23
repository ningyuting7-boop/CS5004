package problem1;

public class Musician extends Artist {

  private String recordingCompany;
  private String lastRecordAlbum;

  public Musician(String name, int age, String[] genres,
      String recordingCompany, String lastRecordAlbum){
    super(name, age, genres);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }
}
