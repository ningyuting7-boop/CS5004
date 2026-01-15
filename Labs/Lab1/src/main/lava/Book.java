/**
 * Represent a book with these details-title, author, pages
 * @author Yuting Ning
 */
public class Book {
  private String title;
  private String author;
  private long pages;
  /**
   Create a new book given title, author and pages as Strings
   * @param title the book's title
   * @param author the book's author
   * @param pages the book's pages
   */
  public Book(String title, String author, long pages){
    this.title = title;
    this.author = author;
    this.pages = pages;
  }
  /**
   * @return the title
   */
  public String getTitle(){ return this.title; }
  /**
   * @return the author
   */
  public String getAuthor(){ return this.author; }
  /**
   * @return the pages
   */
  public long getPages(){ return this.pages; }
}
