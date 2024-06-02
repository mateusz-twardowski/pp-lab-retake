public class Book {
  private int id;
  private String title;
  private String author;
  private String isbn;
  private int year;

  public Book(int id, String title, String author, String isbn, int year) {

    this.id = id;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.year = year;
  }

  public int getId() {

    return this.id;
  }

  public String getTitle() {

    return this.title;
  }

  public String getAuthor() {

    return this.author;
  }

  public String getIsbn() {

    return this.isbn;
  }

  public int getYear() {

    return this.year;
  }

  public void setTitle(String title) {

    this.title = title;
  }

  public void setAuthor(String author) {

    this.author = author;
  }

  public void setIsbn(String isbn) {

    this.isbn = isbn;
  }

  public void setYear(int year) {

    this.year = year;
  }

  public boolean equals(Object o) {

    if (!(o instanceof Book)) {
      return false;
    }

    return ((Book) o).getIsbn() == this.isbn;
  }

  @Override
  public final int hashCode() {

    return this.isbn.hashCode();
  }
}
