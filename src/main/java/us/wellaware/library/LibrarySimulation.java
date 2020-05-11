package us.wellaware.library;
import java.util.*;

public class LibrarySimulation implements Library {
    private final int maxShelfSize;

    //genre sections
    public ArrayList<Genre> genres = new ArrayList<Genre>();
    public HashMap<String, Book> allBooks = new HashMap<String, Book>();

    public LibrarySimulation(int shelfSize) 
    {
        maxShelfSize = shelfSize;
    }

    public boolean addBookToShelf(String isbn, String title, String author, String genre, String publisher, int publicationYear, int pageCount) {
        //if book already in the library
        if (allBooks.containsKey(isbn)) {
            //System.out.println("ISBN " + isbn + " is already in the library!");
            return false;
        }

        Book book = new Book(isbn, title, author, genre, publisher, publicationYear, pageCount);
        allBooks.put(isbn, book);

        for (Genre currentGenre : genres) {
            //if genre exists
            if (currentGenre.getName().equals(genre)) {
                    currentGenre.addBook(book, maxShelfSize);
                    return true;
            }
        }

        //create new genre if does not exist in library
        Genre newGenre = new Genre(book.getGenre());
        newGenre.addBook(book, maxShelfSize);
        genres.add(newGenre);
        return true;
    }

    public String getBookTitle(String isbn) {
        if (allBooks.containsKey(isbn)){
            return allBooks.get(isbn).getTitle();
        }
        return "Error: ISBN not found in library.";
    }

    public String getBookAuthor(String isbn) {
        if (allBooks.containsKey(isbn)){
            return allBooks.get(isbn).getAuthor();
        }
        return "Error: ISBN not found in library.";
    }

    public String getBookInfo(String isbn){
        if (allBooks.containsKey(isbn)){
            return allBooks.get(isbn).toString();
        }
        return "Error: ISBN not found in library.";
    }

    public List<String> getShelfNames() {
        List<String> shelfNames = new ArrayList<>();
        for (Genre genre : genres) {
            for (Shelf shelf : genre.getShelves()){
                shelfNames.add(shelf.toString());
            }
        }
        return shelfNames;
    }

    public String findShelfNameForISBN(String isbn) {
        if (allBooks.containsKey(isbn)){
            Book book = allBooks.get(isbn);
            String bookGenre = book.getGenre();
            for (Genre genre : genres){
                if (genre.getName().equals(bookGenre)){
                    //only go through shelves of the book's genre
                    for (Shelf shelf : genre.getShelves()){
                        if (shelf.getBooksOnShelf().contains(isbn)) {
                            return shelf.toString();
                        }
                    }
                }
            }
        }

        return "Error: ISBN not found in library.";
    }

    public List<String> getISBNsOnShelf(String shelfName) {
        List<String> isbnsOnShelf = new ArrayList<String>();
        for (Genre genre : genres) {
            for (Shelf shelf : genre.getShelves()){
                if (shelf.toString().equals(shelfName)) {
                    isbnsOnShelf.addAll(shelf.getBooksOnShelf());
                    return isbnsOnShelf;
                }
            }
        }

        return isbnsOnShelf;
    }

    public List<String> getISBNsForGenre(String genre, int limit) {
        if (limit == 0){
            return Collections.emptyList();
        }

        List<String> isbnsForGenre = new ArrayList<String>();
        int limitCount = 0;

        for (Genre currentGenre : genres) {
            if (currentGenre.getName().equals(genre)) {
                for (Book currentBook : currentGenre.getBooks()) {
                    isbnsForGenre.add(currentBook.getISBN());
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsForGenre;
                    }
                }
            }
        }

        return isbnsForGenre;
    }

    public List<String> getISBNsForAuthor(String author, int limit) {
        if (limit == 0){
            return Collections.emptyList();
        }

        List<String> isbnsForAuthor = new ArrayList<String>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.getBooks()) {
                if (book.getAuthor().equals(author)) {
                    isbnsForAuthor.add(book.getISBN());
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsForAuthor;
                    }
                }
            }
        }

        return isbnsForAuthor;
    }

    public List<String> getISBNsForPublisher(String publisher, int limit) {
        if (limit == 0){
            return Collections.emptyList();
        }

        List<String> isbnsForPublisher = new ArrayList<String>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.getBooks()) {
                if (book.getPublisher().equals(publisher)) {
                    isbnsForPublisher.add(book.getISBN());
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsForPublisher;
                    }
                }
            }
        }

        return isbnsForPublisher;
    }

    public List<String> getISBNsPublishedAfterYear(short publicationYear, int limit) {
        if (limit == 0){
            return Collections.emptyList();
        }

        List<String> isbnsPublishedAfterYear = new ArrayList<String>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.getBooks()) {
                if (book.getPublicationYear() > publicationYear) {
                    isbnsPublishedAfterYear.add(book.getISBN());
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsPublishedAfterYear;
                    }
                }
            }
        }

        return isbnsPublishedAfterYear;
    }

    public List<String> getISBNsWithMinimumPageCount(int minimumPageCount, int limit) {
        if (limit == 0){
            return Collections.emptyList();
        }

        List<String> isbnsWithMinimumPageCount = new ArrayList<String>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.getBooks()) {
                if (book.getPageCount() >= minimumPageCount) {
                    isbnsWithMinimumPageCount.add(book.getISBN());
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsWithMinimumPageCount;
                    }
                }
            }
        }

        return isbnsWithMinimumPageCount;
    }
}
