package us.wellaware.library;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class LibrarySimulation implements Library 
{
    private final int maxShelfSize;

    public ArrayList<Shelf> shelves = new ArrayList<Shelf>();
    public ArrayList<Long> isbns = new ArrayList<Long>();

    public LibrarySimulation(int shelfSize) 
    {
        maxShelfSize = shelfSize;
    }

    public boolean addBookToShelf(long isbn, String title, String author, String genre, String publisher,
                               int publicationYear, int pageCount) 
    {
        if (isbns.contains(isbn))
        {
            System.out.println("ISBN " + isbn + " is already in the library!");
            return false;
        }
        else
        {
            isbns.add(isbn);
            Book book = new Book(isbn, title, author, genre, publisher, publicationYear, pageCount);
            int lastShelfNumber = 0;

            for (int i = 0; i < shelves.size(); i++)
            {
                Shelf currentShelf = shelves.get(i);

                //if suitable shelf is found
                if (book.genre.equals(currentShelf.genre))
                {
                    if (currentShelf.books.size() < maxShelfSize)
                    {
                        //add book to shelf
                        currentShelf.books.add(book);
                        Collections.sort(currentShelf.books);
                        return true;
                    }
                    else
                    {
                        lastShelfNumber = currentShelf.number;
                    }
                }
            }

            //create new genre shelf
            Shelf newShelf = new Shelf(book.genre, lastShelfNumber + 1);
            newShelf.books.add(book);
            shelves.add(newShelf);
            System.out.println("New shelf created: " + newShelf.genre + " - " + newShelf.number);
            return true;
        }
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

    public ArrayList<Shelf> getShelves()
    {
        return shelves;
    }

    public ArrayList<Long> getISBNs()
    {
        return isbns;
    }
}
