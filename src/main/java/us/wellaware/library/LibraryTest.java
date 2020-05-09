package us.wellaware.library;
import java.util.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
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
        assertFalse(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertFalse(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertFalse(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor","McGraw-Hill", 1979, 180));
        assertFalse(myLibrary.addBookToShelf("609600672", "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229));
    }

    @Test
    public void testGetBookTitle() {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertEquals(myLibrary.getBookTitle("345404475"), "Do Androids Dream of Electric Sheep?");
        assertEquals(myLibrary.getBookTitle("517542095"), "The Hitchhiker's Guide to the Galaxy");
        assertEquals(myLibrary.getBookTitle("517542090"), "Error: ISBN not found in library.");
    }

    @Test
    public void testGetBookAuthor() {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertEquals(myLibrary.getBookAuthor("345404475"), "Dick, Philip");
        assertEquals(myLibrary.getBookAuthor("517542095"), "Adams, Douglas");
        assertEquals(myLibrary.getBookAuthor("517542090"), "Error: ISBN not found in library.");
    }

    @Test
    public void testGetShelfNames() {
        Library myLibrary = new LibrarySimulation(1);
        assertEquals(myLibrary.getShelfNames(), Collections.emptyList());
        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor","McGraw-Hill", 1979, 180));
        assertEquals(myLibrary.getShelfNames(), Arrays.asList("Science Fiction - 1", "Science Fiction - 2", "Cooking - 1", "Humor - 1"));
    }

    @Test
    public void testFindShelfNameForISBN() {
        Library myLibrary = new LibrarySimulation(1);

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
        assertEquals(myLibrary.findShelfNameForISBN("345404475"), "Science Fiction - 2");
        assertEquals(myLibrary.findShelfNameForISBN("517542095"), "Science Fiction - 1");
        assertEquals(myLibrary.findShelfNameForISBN("684818701"), "Cooking - 1");
        assertEquals(myLibrary.findShelfNameForISBN("70064520"), "Humor - 2");
        assertEquals(myLibrary.findShelfNameForISBN("609600672"), "Humor - 1");
        assertEquals(myLibrary.findShelfNameForISBN("609600670"), "Error: ISBN not found in library.");
    }

    @Test
    public void testFindShelfNameForISBN2() {
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
        assertEquals(myLibrary.findShelfNameForISBN("345404475"), "Science Fiction - 1");
        assertEquals(myLibrary.findShelfNameForISBN("517542095"), "Science Fiction - 1");
        assertEquals(myLibrary.findShelfNameForISBN("684818701"), "Cooking - 1");
        assertEquals(myLibrary.findShelfNameForISBN("70064520"), "Humor - 1");
        assertEquals(myLibrary.findShelfNameForISBN("609600672"), "Humor - 1");
        assertEquals(myLibrary.findShelfNameForISBN("609600670"), "Error: ISBN not found in library.");
    }

    @Test
    public void testGetISBNsOnShelf() {
        Library myLibrary = new LibrarySimulation(1);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor","McGraw-Hill", 1979, 180));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 2"), Arrays.asList("345404475"));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 1"), Arrays.asList("517542095"));
        assertEquals(myLibrary.getISBNsOnShelf("Cooking - 1"), Arrays.asList("684818701"));
        assertEquals(myLibrary.getISBNsOnShelf("Humor - 1"), Arrays.asList("70064520"));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 3"), Collections.emptyList());
    }

    @Test
    public void testGetISBNsOnShelf2() {
        Library myLibrary = new LibrarySimulation(2);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("517542096", "The Hitchhiker's Guide to the Galaxy", "Badams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor","McGraw-Hill", 1979, 180));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 1"), Arrays.asList("517542095","517542096"));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 2"), Arrays.asList("345404475"));
        assertEquals(myLibrary.getISBNsOnShelf("Cooking - 1"), Arrays.asList("684818701"));
        assertEquals(myLibrary.getISBNsOnShelf("Humor - 1"), Arrays.asList("70064520"));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 3"), Collections.emptyList());
    }

    @Test
    public void testGetISBNsOnShelf3() {
        Library myLibrary = new LibrarySimulation(2);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("517542096", "The Hitchhiker's Guide to the Galaxy 2", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("517542090", "The Bad Hitchhiker's Guide to the Galaxy", "Badams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor","McGraw-Hill", 1979, 180));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 1"), Arrays.asList("517542095","517542096"));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 2"), Arrays.asList("517542090", "345404475"));
        assertEquals(myLibrary.getISBNsOnShelf("Cooking - 1"), Arrays.asList("684818701"));
        assertEquals(myLibrary.getISBNsOnShelf("Humor - 1"), Arrays.asList("70064520"));
        assertEquals(myLibrary.getISBNsOnShelf("Science Fiction - 3"), Collections.emptyList());
    }

    @Test
    public void testGetISBNsForGenre() {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor", "McGraw-Hill", 1979, 180));
        assertTrue(myLibrary.addBookToShelf("609600672", "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229));
        assertEquals(myLibrary.getISBNsForGenre("Science Fiction", 0), Collections.emptyList());
        assertEquals(myLibrary.getISBNsForGenre("Nonfiction", 10), Collections.emptyList());
        assertEquals(myLibrary.getISBNsForGenre("Science Fiction", 5), Arrays.asList("517542095", "345404475"));
        assertEquals(myLibrary.getISBNsForGenre("Science Fiction", 1), Arrays.asList("517542095"));
        assertEquals(myLibrary.getISBNsForGenre("Cooking", 1), Arrays.asList("684818701"));
        assertEquals(myLibrary.getISBNsForGenre("Humor", 5), Arrays.asList("609600672", "70064520"));
        assertEquals(myLibrary.getISBNsForGenre("Humor", 1), Arrays.asList("609600672"));
    }

    @Test
    public void testGetISBNsForAuthor() {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("517542096", "The Hitchhiker's Guide to the Galaxy 2", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor", "McGraw-Hill", 1979, 180));
        assertTrue(myLibrary.addBookToShelf("609600672", "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229));
        assertEquals(myLibrary.getISBNsForAuthor("Adams, Douglas", 0), Collections.emptyList());
        assertEquals(myLibrary.getISBNsForAuthor("Icarangal, Keenan", 10), Collections.emptyList());
        assertEquals(myLibrary.getISBNsForAuthor("Adams, Douglas", 5), Arrays.asList("517542095", "517542096"));
        assertEquals(myLibrary.getISBNsForAuthor("Dick, Philip", 1), Arrays.asList("345404475"));
        assertEquals(myLibrary.getISBNsForAuthor("Rombauer, Irma", 1), Arrays.asList("684818701"));
        assertEquals(myLibrary.getISBNsForAuthor("Bombeck, Erma", 5), Arrays.asList("70064520"));
        assertEquals(myLibrary.getISBNsForAuthor("Barry, Dave", 1), Arrays.asList("609600672"));
    }

    @Test
    public void testGetISBNsForPublisher() {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("517542096", "The Hitchhiker's Guide to the Galaxy 2", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor", "McGraw-Hill", 1979, 180));
        assertTrue(myLibrary.addBookToShelf("609600672", "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229));
        assertEquals(myLibrary.getISBNsForPublisher("Harmony Books", 0), Collections.emptyList());
        assertEquals(myLibrary.getISBNsForPublisher("Penguin", 10), Collections.emptyList());
        assertEquals(myLibrary.getISBNsForPublisher("Harmony Books", 5), Arrays.asList("517542095", "517542096"));
        assertEquals(myLibrary.getISBNsForPublisher("Ballantine Books", 1), Arrays.asList("345404475"));
        assertEquals(myLibrary.getISBNsForPublisher("Simon and Schuster", 1), Arrays.asList("684818701"));
        assertEquals(myLibrary.getISBNsForPublisher("McGraw-Hill", 5), Arrays.asList("70064520"));
        assertEquals(myLibrary.getISBNsForPublisher("Crown Publishers", 1), Arrays.asList("609600672"));
    }

    @Test
    public void testGetISBNsPublishedAfterYear() {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor", "McGraw-Hill", 1979, 180));
        assertTrue(myLibrary.addBookToShelf("609600672", "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229));
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)1900, 0), Collections.emptyList());
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)2010, 10), Collections.emptyList());
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)1900, 10), Arrays.asList("517542095", "345404475", "684818701", "609600672", "70064520"));
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)1900, 1), Arrays.asList("517542095"));
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)1990, 10), Arrays.asList("345404475", "684818701", "609600672"));
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)1990, 2), Arrays.asList("345404475", "684818701"));
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)1999, 10), Arrays.asList("609600672"));
        assertEquals(myLibrary.getISBNsPublishedAfterYear((short)1999, 1), Arrays.asList("609600672"));
    }

    @Test
    public void testGetISBNsWithMinimumPageCount() {
        Library myLibrary = new LibrarySimulation(5);

        assertTrue(myLibrary.addBookToShelf("345404475", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244));
        assertTrue(myLibrary.addBookToShelf("517542095", "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224));
        assertTrue(myLibrary.addBookToShelf("684818701", "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136));
        assertTrue(myLibrary.addBookToShelf("70064520", "Aunt Erma's cope book", "Bombeck, Erma",
                "Humor", "McGraw-Hill", 1979, 180));
        assertTrue(myLibrary.addBookToShelf("609600672", "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229));
        assertEquals(myLibrary.getISBNsWithMinimumPageCount(200, 0), Collections.emptyList());
        assertEquals(myLibrary.getISBNsWithMinimumPageCount(2000, 10), Collections.emptyList());
        assertEquals(myLibrary.getISBNsWithMinimumPageCount(100, 10), Arrays.asList("517542095", "345404475", "684818701", "609600672", "70064520"));
        assertEquals(myLibrary.getISBNsWithMinimumPageCount(100, 3), Arrays.asList("517542095", "345404475", "684818701"));
        assertEquals(myLibrary.getISBNsWithMinimumPageCount(200, 10), Arrays.asList("517542095", "345404475", "684818701", "609600672"));
        assertEquals(myLibrary.getISBNsWithMinimumPageCount(1000, 10), Arrays.asList("684818701"));
    }
}