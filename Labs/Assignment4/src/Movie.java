/**
 * a concrete class
 * the movie class represents a movie with a specific movieID, title, rating
 */
class Movie {
  // private: can access in this class, only access the field by public getters.
  /** MovieID : ID of the movie **/
  private int MovieID;
  /** title : title of the movie **/
  private String title;
  /** rating : rating of the movie **/
  private String rating;

  /**
   * default constructs a movie with ID(0), title("") and rating("")
   */
  public Movie()
  {
    MovieID = 0;
    title = "";
    rating = "";
  }

  /**
   * constructs a movie with an ID, a title and a rating
   * @param ID: the ID of the movie
   * @param title: the title of the movie
   * @param rating： the rating of the movie
   */
  public Movie(int ID, String title, String rating)
  {
    this.MovieID = ID;
    this.title = title;
    this.rating = rating;
  }

  /**
   *
   * @return the ID of this movie
   */
  public int getID()
  {
    return MovieID;
  }
  /**
   * sets the movie's ID
   * @param ID: the new ID of this movie
   */
  public void setID(int ID)
  {
    this.MovieID = ID;
  }
  /**
   *
   * @return the title of this movie
   */
  public String getTitle()
  {
    return title;
  }
  /**
   * sets the movie's title
   * @param name: the new title of this movie
   */
  public void setTitle(String name)
  {
    this.title = name;
  }
  /**
   *
   * @return the rating of this movie
   */
  public String getRating()
  {
    return rating;
  }
  /**
   * sets the movie's rating
   * @param rating: the new rating of this movie
   */
  public void setRating(String rating)
  {
    this.rating = rating;
  }

  /**
   * check if this movie equals to other
   *
   * @param other  the reference object with which to compare.
   * @return true if they are of the same class and have the same ID, otherwise return false
   */
  @Override
  public boolean equals(Object other)
  {
    if (other == null)
      return false;
    else if (getClass() != other.getClass())
      return false;
    else
    {
      Movie otherMovie = (Movie) other;
      if (otherMovie.getID() == this.getID()) return true;
    }
    return false;
  }

  /**
   * calculate the latefee: 2 times days
   * @param daysLate: the late days
   * @return the latefees
   */
  public double calcLateFees(int daysLate)
  {
    return (2.0 * daysLate);
  }
}
