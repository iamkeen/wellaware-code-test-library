package us.wellaware.library;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void testAddBookSuccess()
    {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor","McGraw-Hill", 1979, 180));
        assertTrue(myLibrary.addBookToShelf("609600672", "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229));
        assertFalse(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
    }

}