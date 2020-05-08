package us.wellaware.library;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/*
    - Book ISBN numbers are unique. There cannot be two books with the same ISBN number, so an attempt to add a book to a shelf when that ISBN number already exists in the library should fail.
    - Books are only put on the same shelf as other books of the same genre.
    - Each shelf can only hold a maximum number of books, specified by the library class member variable.
    - When a shelf is full, a new shelf must be created to accommodate another book for that genre.
    - Each shelf will have an associated genre and shelf number within the genre. The name of the shelf should be formatted as "Genre - Number". For example, “Science Fiction – 1”, “Science Fiction – 2”, “Science Fiction – 3”, “Cooking - 1”, “Cooking – 2”, “Travel – 1”.
    - Books are ordered alphabetically first by author, then title. The first books in the order are placed on that genre’s shelf #1, when that shelf is full the next books in order go on that genre’s shelf #2, etc. When adding a book to a shelf that’s already full, books will get displaced to the next numbered shelf to maintain sort order.
    - Only create the number of shelves necessary for all the books. There should not be any empty shelves in the library
*/

public class LibrarySimulation implements Library 
{
    private final int maxShelfSize;

    public LibrarySimulation(int shelfSize) 
    {
        maxShelfSize = shelfSize;
    }

    public boolean addBookToShelf(long isbn, String title, String author, String genre, String publisher,
                               int publicationYear, int pageCount) 
    {
        throw new UnsupportedOperationException();
    }

    public String getBookTitle(long isbn) 
    {
        throw new UnsupportedOperationException();
    }

    public List<String> getShelfNames() 
    {
        throw new UnsupportedOperationException();
    }

    public String findShelfNameForISBN(long isbn) 
    {
        throw new UnsupportedOperationException();
    }

    public List<Long> getISBNsOnShelf(String shelfName) 
    {
        throw new UnsupportedOperationException();
    }

    public List<Long> getISBNsForGenre(String genre, int limit) 
    {
        throw new UnsupportedOperationException();
    }

    public List<Long> getISBNsForAuthor(String author, int limit) 
    {
        throw new UnsupportedOperationException();
    }

    public List<Long> getISBNsForPublisher(String publisher, int limit) 
    {
        throw new UnsupportedOperationException();
    }

    public List<Long> getISBNsPublishedAfterYear(short publicationYear, int limit) 
    {
        throw new UnsupportedOperationException();
    }

    public List<Long> getISBNsWithMinimumPageCount(int minimumPageCount, int limit) 
    {
        throw new UnsupportedOperationException();
    }
}
