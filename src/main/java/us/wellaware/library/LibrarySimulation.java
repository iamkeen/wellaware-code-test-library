package us.wellaware.library;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class LibrarySimulation implements Library {
    private final int maxShelfSize;

    public ArrayList<Genre> genres = new ArrayList<Genre>();
    public ArrayList<Long> isbns = new ArrayList<Long>();

    public LibrarySimulation(int shelfSize) 
    {
        maxShelfSize = shelfSize;
    }

    public boolean addBookToShelf(long isbn, String title, String author, String genre, String publisher, int publicationYear, int pageCount) {
        if (isbns.contains(isbn)) {
            System.out.println("ISBN " + isbn + " is already in the library!");
            return false;
        }

        isbns.add(isbn);
        Book book = new Book(isbn, title, author, genre, publisher, publicationYear, pageCount);

        for (Genre currentGenre : genres) {
            //if genre exists is found
            if (currentGenre.name.equals(genre)) {
                    currentGenre.addBook(book, maxShelfSize);
                    return true;
            }
        }


        //create new genre if does not exist in library
        Genre newGenre = new Genre(book.genre);
        newGenre.addBook(book, maxShelfSize);
        genres.add(newGenre);
        return true;
    }

    public String getBookTitle(long isbn) {
        for (Genre genre : genres){
            for (Book book : genre.books){
                if (book.isbn == isbn){
                    return book.title;
                }
            }
        }

        return "";
    }

    public String getBookAuthor(long isbn) {
        for (Genre genre : genres){
            for (Book book : genre.books){
                if (book.isbn == isbn){
                    return book.author;
                }
            }
        }

        return "";
    }

    public List<String> getShelfNames() {
        List<String> shelfNames = new ArrayList<>();

        for (Genre genre : genres) {
            for (Shelf shelf : genre.shelves){
                shelfNames.add(shelf.toString());
            }
        }

        return shelfNames;
    }

    public String findShelfNameForISBN(long isbn) {
        for (Genre genre : genres) {
            for (Book book : genre.books) {
                if (book.isbn == isbn) {
                    return book.shelf.toString();
                }
            }
        }

        return "ISBN not found";
    }

    public List<Long> getISBNsOnShelf(String shelfName) {
        List<Long> isbnsOnShelf = new ArrayList<Long>();

        for (Genre genre : genres) {
            for (Shelf shelf : genre.shelves){
                if (shelf.toString().equals(shelfName)) {
                    for (Book currentBook : shelf.books) {
                        isbnsOnShelf.add(currentBook.isbn);
                    }
                }
            }
        }

        return isbnsOnShelf;
    }

    public List<Long> getISBNsForGenre(String genre, int limit) {
        List<Long> isbnsForGenre = new ArrayList<Long>();
        int limitCount = 0;

        for (Genre currentGenre : genres) {
            if (currentGenre.name.equals(genre)) {
                for (Book currentBook : currentGenre.books) {
                    isbnsForGenre.add(currentBook.isbn);
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsForGenre;
                    }
                }
            }
        }

        return isbnsForGenre;
    }

    public List<Long> getISBNsForAuthor(String author, int limit) {
        List<Long> isbnsForAuthor = new ArrayList<Long>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.books) {
                if (book.author.equals(author)) {
                    isbnsForAuthor.add(book.isbn);
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsForAuthor;
                    }
                }
            }
        }

        return isbnsForAuthor;
    }

    public List<Long> getISBNsForPublisher(String publisher, int limit) {
        List<Long> isbnsForPublisher = new ArrayList<Long>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.books) {
                if (book.publisher.equals(publisher)) {
                    isbnsForPublisher.add(book.isbn);
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsForPublisher;
                    }
                }
            }
        }

        return isbnsForPublisher;
    }

    public List<Long> getISBNsPublishedAfterYear(short publicationYear, int limit) {
        List<Long> isbnsPublishedAfterYear = new ArrayList<Long>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.books) {
                if (book.publicationYear > publicationYear) {
                    isbnsPublishedAfterYear.add(book.isbn);
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsPublishedAfterYear;
                    }
                }
            }
        }

        return isbnsPublishedAfterYear;
    }

    public List<Long> getISBNsWithMinimumPageCount(int minimumPageCount, int limit) {
        List<Long> isbnsWithMinimumPagecount = new ArrayList<Long>();
        int limitCount = 0;

        for (Genre genre : genres) {
            for (Book book : genre.books) {
                if (book.pageCount >= minimumPageCount) {
                    isbnsWithMinimumPagecount.add(book.isbn);
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsWithMinimumPagecount;
                    }
                }
            }
        }

        return isbnsWithMinimumPagecount;
    }
}
