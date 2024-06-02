import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    private GridPane root;
    private Stage stage;

    public static BookManager bookManager;

    public static void main(String[] args) {

        App.bookManager = new BookManager();

        App.bookManager.addBook("Harry Potter 1", "JKRowling", "12-123-123", 2005);
        App.bookManager.addBook("Harry Potter 2", "JKRowling", "12-123-121", 2006);
        App.bookManager.addBook("Harry Potter 3", "JKRowling", "12-123-122", 2008);
        App.bookManager.addBook("Harry Potter 4", "JKRowling", "12-125-123", 2010);
        App.bookManager.addBook("Harry Potter 5", "JKRowling", "12-123-1213", 2012);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        this.stage.setTitle("Library");

        this.root = new GridPane();
        this.createMenu(new ActionEvent());
        this.stage.setScene(new Scene(root, 800, 600));
        this.stage.show();
    }

    public void createMenu(ActionEvent e) {
        this.root.getChildren().clear();

        Button btn = new Button();
        btn.setText("Add book");
        GridPane.setRowIndex(btn, 0);
        GridPane.setColumnIndex(btn, 1);
        btn.setOnAction(this::addBookForm);

        Button btn1 = new Button();
        btn1.setText("Remove book");
        GridPane.setRowIndex(btn1, 1);
        GridPane.setColumnIndex(btn1, 1);
        btn1.setOnAction(this::removeBookForm);

        Button btn2 = new Button();
        btn2.setText("Update book");
        GridPane.setRowIndex(btn2, 2);
        GridPane.setColumnIndex(btn2, 1);
        btn2.setOnAction(this::updateBookForm);

        Button btn3 = new Button();
        btn3.setText("List books");
        GridPane.setRowIndex(btn3, 3);
        GridPane.setColumnIndex(btn3, 1);
        btn3.setOnAction(this::showBooks);

        Button btn4 = new Button();
        btn4.setText("Exit");
        GridPane.setRowIndex(btn4, 4);
        GridPane.setColumnIndex(btn4, 1);
        btn4.setOnAction(this::closeApp);

        this.root.getChildren().addAll(btn, btn1, btn2, btn3, btn4);
    }

    public void closeApp(ActionEvent e) {
        this.stage.close();
    }

    public void addBookForm(ActionEvent e) {
        this.root.getChildren().clear();

        Label title = new Label("Title:");
        this.root.add(title, 0, 1);

        TextField titleField = new TextField();
        this.root.add(titleField, 1, 1);

        Label author = new Label("Author:");
        this.root.add(author, 0, 2);

        TextField authorField = new TextField();
        this.root.add(authorField, 1, 2);

        Label isbn = new Label("ISBN:");
        this.root.add(isbn, 0, 3);

        TextField isbnField = new TextField();
        this.root.add(isbnField, 1, 3);

        Label year = new Label("Year:");
        this.root.add(year, 0, 4);

        TextField yearField = new TextField();
        this.root.add(yearField, 1, 4);

        Button saveBtn = new Button();
        saveBtn.setText("Save");
        saveBtn.setOnAction(ev -> {
            App.bookManager.addBook(titleField.getText(), authorField.getText(), isbnField.getText(),
                    Integer.parseInt(yearField.getText()));
            this.createMenu(ev);
        });
        this.root.add(saveBtn, 0, 5);

        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setOnAction(this::createMenu);
        this.root.add(backBtn, 1, 5);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void showBooks(ActionEvent e) {
        this.root.getChildren().clear();

        TableView table = new TableView();

        table.setEditable(true);

        TableColumn<Book, String> idColumn = new TableColumn("Id.");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Book, String> titleColumn = new TableColumn("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book, String> authorColumn = new TableColumn("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn<Book, String> isbnColumn = new TableColumn("ISBN");
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        TableColumn<Book, String> yearColumn = new TableColumn("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        table.getColumns().addAll(idColumn, titleColumn, authorColumn, isbnColumn, yearColumn);

        table.getItems().addAll(App.bookManager.getBooks());

        this.root.add(table, 0, 0);

        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setOnAction(this::createMenu);
        this.root.add(backBtn, 0, 1);
    }

    public void removeBookForm(ActionEvent e) {
        this.root.getChildren().clear();

        Label id = new Label("Id:");
        this.root.add(id, 0, 1);

        TextField idField = new TextField();
        this.root.add(idField, 1, 1);

        Button removeBtn = new Button();
        removeBtn.setText("Remove");
        removeBtn.setOnAction(ev -> {
            App.bookManager.removeBook(Integer.parseInt(idField.getText()));
            this.createMenu(ev);
        });
        this.root.add(removeBtn, 0, 2);

        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setOnAction(this::createMenu);
        this.root.add(backBtn, 1, 2);
    }

    public void updateBookForm(ActionEvent e) {
        this.root.getChildren().clear();

        Label id = new Label("Id:");
        this.root.add(id, 0, 1);

        TextField idField = new TextField();
        this.root.add(idField, 1, 1);

        Label title = new Label("Title:");
        this.root.add(title, 0, 2);

        TextField titleField = new TextField();
        this.root.add(titleField, 1, 2);

        Label author = new Label("Author:");
        this.root.add(author, 0, 3);

        TextField authorField = new TextField();
        this.root.add(authorField, 1, 3);

        Label isbn = new Label("ISBN:");
        this.root.add(isbn, 0, 4);

        TextField isbnField = new TextField();
        this.root.add(isbnField, 1, 4);

        Label year = new Label("Year:");
        this.root.add(year, 0, 5);

        TextField yearField = new TextField();
        this.root.add(yearField, 1, 5);

        Button updateBtn = new Button();
        updateBtn.setText("Update");
        updateBtn.setOnAction(ev -> {
            App.bookManager.updateBook(Integer.parseInt(idField.getText()), titleField.getText(), authorField.getText(),
                    isbnField.getText(),
                    Integer.parseInt(yearField.getText()));
            this.createMenu(ev);
        });
        this.root.add(updateBtn, 0, 6);

        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setOnAction(this::createMenu);
        this.root.add(backBtn, 1, 6);
    }
}
