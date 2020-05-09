package us.wellaware.library;

import java.util.List;

public interface Library {
    boolean addBookToShelf(String isbn, String title, String author, String genre, String publisher,
                        int publicationYear, int pageCount);

    String getBookTitle(String isbn);

    String getBookAuthor(String isbn);

    String getBookInfo(String isbn);

    List<String> getShelfNames();

    String findShelfNameForISBN(String isbn);

    List<String> getISBNsOnShelf(String shelfName);

    List<String> getISBNsForGenre(String genre, int limit);

    List<String> getISBNsForAuthor(String author, int limit);

    List<String> getISBNsForPublisher(String publisher, int limit);

    List<String> getISBNsPublishedAfterYear(short publicationYear, int limit);

    List<String> getISBNsWithMinimumPageCount(int minimumPageCount, int limit);
}
