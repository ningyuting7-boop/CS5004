public class Rental {
  private Movie movie;
  private int daysLate;

  public Rental(Movie movie, int daysLate){
    // shallow copy, rental just refers to movie
    this.movie = new Movie(movie.getID(), movie.getTitle(), movie.getRating());
    this.daysLate = daysLate;
  }

  public int getDaysLate() {
    return daysLate;
  }

  public double getLateFees(){
    return movie.calcLateFees(getDaysLate());
  }

  public void setDaysLate(int newDaysLate) {
    daysLate = newDaysLate;
  }
}
