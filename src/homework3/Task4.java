package homework3;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.insertBook("Horror", "The Shining");
        bookStore.insertBook("Horror", "Dracula");
        bookStore.insertBook("Crime", "Empire of Pain");
        bookStore.insertBook("Crime", "Bad Blood");
        bookStore.insertBook("Crime", "Last Call");
        bookStore.insertBook("Romance", "Jane Eyre");
        bookStore.insertBook("Fantasy", "A Game of Thrones");
        bookStore.insertBook("Classic", "Crime and Punishment");
        bookStore.showAllBooks();
    }
}
class BookStore {
    private final List<List<String>> allBooks;

    public BookStore() {
        allBooks = new ArrayList<>();
        allBooks.add(new ArrayList<>(List.of("Horror")));
        allBooks.add(new ArrayList<>(List.of("Crime")));
        allBooks.add(new ArrayList<>(List.of("Romance")));
        allBooks.add(new ArrayList<>(List.of("Fantasy")));
        allBooks.add(new ArrayList<>(List.of("Classic")));
    }
    public void showAllBooks(){
        for (List genre: allBooks){
            System.out.printf("Genre %s \t Books: ", genre.get(0));
            System.out.println(genre.subList(1, genre.size()));
        }
    }
    public void insertBook(String bookGenre, String name){
        for (List<String> allBook : allBooks) {
            if (allBook.get(0) == bookGenre) {
                allBook.add(name);
            }
        }
    }
}
