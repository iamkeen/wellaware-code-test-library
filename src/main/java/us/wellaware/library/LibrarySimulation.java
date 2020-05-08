package us.wellaware.library;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class LibrarySimulation implements Library {
    private final int maxShelfSize;

    public ArrayList<Shelf> shelves = new ArrayList<Shelf>();
    public ArrayList<Long> isbns = new ArrayList<Long>();

    public LibrarySimulation(int shelfSize) 
    {
        maxShelfSize = shelfSize;
    }

    public boolean addBookToShelf(long isbn, String title, String author, String genre, String publisher,
                               int publicationYear, int pageCount) {
        if (isbns.contains(isbn)) {
            System.out.println("ISBN " + isbn + " is already in the library!");
            return false;
        }
        else {
            isbns.add(isbn);
            Book book = new Book(isbn, title, author, genre, publisher, publicationYear, pageCount);
            int lastShelfNumber = 0;

            for (Shelf currentShelf : shelves) {
                //if suitable shelf is found
                if (book.genre.equals(currentShelf.genre)) {
                    if (currentShelf.books.size() < maxShelfSize) {
                        //add book to shelf
                        currentShelf.books.add(book);
                        Collections.sort(currentShelf.books);
                        return true;
                    } else {
                        //keep track of last shelf number of genre
                        lastShelfNumber = currentShelf.number;
                    }
                }
            }

            //create new genre shelf
            Shelf newShelf = new Shelf(book.genre, lastShelfNumber + 1);
            newShelf.books.add(book);
            shelves.add(newShelf);
            return true;
        }
    }

    public String getBookTitle(long isbn) 
    {
        throw new UnsupportedOperationException();
    }

    public List<String> getShelfNames() {
        List<String> shelfNames = new ArrayList<String>();

        for (Shelf shelf : shelves) {
            shelfNames.add(shelf.toString());
        }

        return shelfNames;
    }

    public String findShelfNameForISBN(long isbn) 
    {
        for (Shelf currentShelf : shelves) {
            for (int j = 0; j < currentShelf.books.size(); j++) {
                if (currentShelf.books.get(j).isbn == isbn) {
                    return currentShelf.toString();
                }
            }
        }

        return "ISBN not found";
    }

    public List<Long> getISBNsOnShelf(String shelfName) {
        List<Long> isbnsOnShelf = new ArrayList<Long>();

        for (Shelf currentShelf : shelves) {
            if (currentShelf.toString().equals(shelfName)) {
                for (Book currentBook : currentShelf.books) {
                    isbnsOnShelf.add(currentBook.isbn);
                }
            }
        }

        return isbnsOnShelf;
    }

    public List<Long> getISBNsForGenre(String genre, int limit) {
        List<Long> isbnsForGenre = new ArrayList<Long>();
        int limitCount = 0;

        for (Shelf currentShelf : shelves) {
            if (currentShelf.genre.equals(genre)) {
                for (Book currentBook : currentShelf.books) {
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

        for (Shelf currentShelf : shelves) {
            for (Book currentBook : currentShelf.books) {
                if (currentBook.author.equals(author)) {
                    isbnsForAuthor.add(currentBook.isbn);
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

        for (Shelf currentShelf : shelves) {
            for (Book currentBook : currentShelf.books) {
                if (currentBook.publisher.equals(publisher)) {
                    isbnsForPublisher.add(currentBook.isbn);
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

        for (Shelf currentShelf : shelves) {
            for (Book currentBook : currentShelf.books) {
                if (currentBook.publicationYear > publicationYear) {
                    isbnsPublishedAfterYear.add(currentBook.isbn);
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

        for (Shelf currentShelf : shelves) {
            for (Book currentBook : currentShelf.books) {
                if (currentBook.pageCount >= minimumPageCount) {
                    isbnsWithMinimumPagecount.add(currentBook.isbn);
                    limitCount++;

                    if (limitCount == limit) {
                        return isbnsWithMinimumPagecount;
                    }
                }
            }
        }

        return isbnsWithMinimumPagecount;
    }

    public List<Shelf> getShelves()
    {
        return shelves;
    }
}
