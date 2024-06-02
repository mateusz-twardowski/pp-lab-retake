import java.util.List;

public interface BookOperations {

  public void addBook(String title, String author, String isbn, int year);

  public void removeBook(int id);

  public void updateBook(int id, String title, String author, String isbn, int year);

  public List<Book> getBooks();
}
