package problem1;

public class Poet extends Artist {

  private String publishingCompany;
  private String lastPublishedCollection;

  public Poet(String name, int age, String[] genres,
      String publishingCompany, String lastPublishedCollection){
    super(name, age, genres);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }
}
