import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BookManager implements BookOperations {
  private List<Book> books;
  private int nextId = 0;

  public BookManager() {

    this.books = new ArrayList<Book>();
  }

  @Override
  public void addBook(String title, String author, String isbn, int year) {
    this.books.add(new Book(this.nextId, title, author, isbn, year));
    this.nextId++;
  }

  @Override
  public void removeBook(int id) {
    int index = this.findIndexById(id);

    if (index != -1) {
      this.books.remove(index);
    }
  }

  @Override
  public void updateBook(int id, String title, String author, String isbn, int year) {
    int index = this.findIndexById(id);

    if (index == -1) {
      return;
    }

    Book book = this.books.get(index);

    book.setTitle(title);
    book.setAuthor(author);
    book.setIsbn(isbn);
    book.setYear(year);
  }

  @Override
  public List<Book> getBooks() {

    return this.books;
  }

  private int findIndexById(int id) {
    return IntStream.range(0, this.books.size())
        .filter(i -> this.books.get(i).getId() == id)
        .findFirst()
        .orElse(-1);
  }
}
