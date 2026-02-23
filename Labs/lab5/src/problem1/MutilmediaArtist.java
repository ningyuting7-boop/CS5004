package problem1;

import java.util.ArrayList;

public abstract class MutilmediaArtist extends Artist{

  private String[] movies;
  private String[] series;
  private String[] otherMultimedia;

  public MutilmediaArtist(String name, int age, String[] genres,
      String[] movies, String[] series, String[] otherMultimedia){
    super(name, age, genres);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }
  public String[] getMovies(){ return movies; }
  public String[] getSeries(){ return series; }
  public String[] getOtherMultimedia(){ return otherMultimedia; }
}
