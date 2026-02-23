/**
 * this concrete class represents a movie in action genre
 * the class extends movie class and override calculate late fee
 */
class ActionMovie extends Movie {
  // inherent default constructor from movie class
  public ActionMovie() {
    super();
  }
  // inherent constructor with 3 parameters from movie class
  public ActionMovie(int ID, String title, String rating) {
    super(ID, title, rating);
  }
  @Override
  public double calcLateFees(int daysLate) {
    return (3.0 * daysLate);
  }
}