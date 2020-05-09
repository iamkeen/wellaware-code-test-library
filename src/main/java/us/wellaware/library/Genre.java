package us.wellaware.library;
import java.util.*;

public class Genre
{
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Shelf> shelves = new ArrayList<Shelf>();
    private String name;
    private int numShelves;

    public Genre(String name)
    {
        this.name = name;
        numShelves = 0;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Shelf> getShelves() {
        return shelves;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book, int maxShelfSize) {
        //add book to genre collection
        books.add(book);
        //sort books in genre
        Collections.sort(books);

        //if no shelves exist
        if (shelves.size() == 0) {
            //create the first shelf
            createShelf(book);
            return;
        }

        //fill all existing shelves with the newly ordered books
        int bookCount = 0;
        Book currentBook;
        for (Shelf shelf : shelves) {
            shelf.getBooksOnShelf().clear(); //clear or create a new shelf?
            for (int j = 0; j < maxShelfSize; j++) {
                currentBook = books.get(bookCount);
                //shelf.books.set(j, currentBook); doesn't work if element doesn't exist at index j
                shelf.getBooksOnShelf().add(currentBook.getISBN());
                bookCount++;
                if (bookCount == books.size()) {
                    return;
                }
            }
        }

        //if there are still unshelved books
        if (bookCount < books.size()){
            //create a new shelf for it
            createShelf(books.get(bookCount));
        }
    }

    private void createShelf(Book book){
        numShelves++;
        Shelf newShelf = new Shelf(book.getGenre(), numShelves);
        newShelf.getBooksOnShelf().add(book.getISBN());
        shelves.add(newShelf);
    }
}
