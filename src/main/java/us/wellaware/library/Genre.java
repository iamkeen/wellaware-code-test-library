package us.wellaware.library;

import java.util.*;

public class Genre
{
    public ArrayList<Book> books = new ArrayList<Book>();
    public String name;
    public ArrayList<Shelf> shelves = new ArrayList<Shelf>();
    public int numShelves;

    public Genre(String name)
    {
        this.name = name;
        numShelves = 0;
    }

    public void addBook(Book book, int maxShelfSize) {
        //add book to genre
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
            shelf.booksOnShelf.clear();
            for (int j = 0; j < maxShelfSize; j++) {
                currentBook = books.get(bookCount);
                //shelf.books.set(j, currentBook); doesn't work if element doesn't exist at index j
                shelf.booksOnShelf.add(currentBook.isbn);
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
        Shelf newShelf = new Shelf(book.genre, numShelves);
        newShelf.booksOnShelf.add(book.isbn);
        shelves.add(newShelf);
    }
}
