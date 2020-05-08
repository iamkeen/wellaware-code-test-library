package us.wellaware.library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Library myLibrary = new LibrarySimulation(5);

        File bookSampleData = new File("src\\main\\resources\\book_sample_data.csv");
	    BufferedReader br = null;
	    String line = "";
	    String splitOn = ",";

	    try {
            br = new BufferedReader(new FileReader(bookSampleData));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineTokens = line.split(splitOn);
                ArrayList<String> bookData = new ArrayList<String>();

                for (int i = 0; i < lineTokens.length; i++) {
                    if (lineTokens[i].contains("\"")) {
                        int j = i + 1;
                        String temp = lineTokens[i];
                        while (!lineTokens[j].contains("\"")) {
                            temp += ("," + lineTokens[j]);
                            j++;
                        }
                        temp += ("," + lineTokens[j]);
                        bookData.add(temp.replace("\"", ""));
                        i = j;
                    } else {
                        bookData.add(lineTokens[i]);
                    }
                }

                String title = bookData.get(0);
                String author = bookData.get(1);
                Long isbn = Long.parseLong(bookData.get(2).replace("X", ""));
                String publisher = bookData.get(3);
                int pageCount = Integer.parseInt(bookData.get(4));
                int publicationYear = Integer.parseInt(bookData.get(5));
                String genre = bookData.get(6);

                myLibrary.addBookToShelf(isbn, title, author, genre, publisher, publicationYear, pageCount);
            }

            List<String> shelves = myLibrary.getShelfNames();

            for (String shelf : shelves) {
                List<Long> bookIds = myLibrary.getISBNsOnShelf(shelf);

                System.out.println(String.format("Found shelf '%s' with %d books.", shelf, bookIds.size()));
                for (Long id : bookIds) {
                    System.out.println(id + " " + myLibrary.getBookTitle(id));
                }
                System.out.println();
            }
        }
	    catch (Exception e)
        {
            System.out.println(e);
        }

	    /*myLibrary.addBookToShelf(345404475, "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244);
        myLibrary.addBookToShelf(517542095, "The Hitchhiker's Guide to the Galaxy", "Adams, Douglas",
                "Science Fiction", "Harmony Books", 1989, 224);
        myLibrary.addBookToShelf(684818701, "The Joy of Cooking: Seventh Edition", "Rombauer, Irma",
                "Cooking", "Simon and Schuster", 1997, 1136);
        myLibrary.addBookToShelf(70064520, "Aunt Erma's cope book", "Bombeck, Erma", "Humor",
                "McGraw-Hill", 1979, 180);
        myLibrary.addBookToShelf(609600672, "Dave Barry is not taking this sitting down!", "Barry, Dave",
                "Humor", "Crown Publishers", 2000, 229);
        myLibrary.addBookToShelf(345404475, "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                "Science Fiction", "Ballantine Books", 1996, 244);

        List<String> shelves = myLibrary.getShelfNames();

        for (String shelf : shelves) {
            List<Long> bookIds = myLibrary.getISBNsOnShelf(shelf);

            System.out.println(String.format("Found shelf '%s' with %d books.", shelf, bookIds.size()));
            for (Long id : bookIds)
            {
                System.out.println(id + " " + myLibrary.findShelfNameForISBN(id));
            }
            for (Long isbn : bookIds) {
                String title = myLibrary.getBookTitle(isbn);
                System.out.println(String.format("   %s", title));
            }
        }*/
    }
}
