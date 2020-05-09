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
	        ArrayList<String> isbns = new ArrayList<String>();
            ArrayList<String> genres = new ArrayList<String>();
            ArrayList<String> authors = new ArrayList<String>();
            ArrayList<String> publishers = new ArrayList<String>();

            br = new BufferedReader(new FileReader(bookSampleData));
            br.readLine();
            int totalBooks = 0;
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
                String isbn = bookData.get(2);
                String publisher = bookData.get(3);
                int pageCount = Integer.parseInt(bookData.get(4));
                int publicationYear = Integer.parseInt(bookData.get(5));
                String genre = bookData.get(6);

                if (myLibrary.addBookToShelf(isbn, title, author, genre, publisher, publicationYear, pageCount)) {
                    totalBooks++;
                    isbns.add(isbn);
                    if (!genres.contains(genre)) {
                        genres.add(genre);
                    }
                    if (!authors.contains(author)) {
                        authors.add(author);
                    }
                    if (!publishers.contains(publisher)) {
                        publishers.add(publisher);
                    }
                }
            }

            //TEST for duplicate additions
            myLibrary.addBookToShelf("440238153", "Do Androids Dream of Electric Sheep?", "Dick, Philip",
                    "Science Fiction", "Ballantine Books", 1996, 244);
            System.out.println();

            //TESTS for Library's get functions
            displayLibrary(myLibrary);

            for (String currentISBN : isbns){
                System.out.println(myLibrary.getBookTitle(currentISBN) + " found in " + myLibrary.findShelfNameForISBN(currentISBN));
            }
            System.out.println();

            for (String currentGenre : genres){
                System.out.println("All books in " + currentGenre);
                for (String currentISBN : myLibrary.getISBNsForGenre(currentGenre, totalBooks)){
                    System.out.println(myLibrary.getBookInfo(currentISBN));
                }
                System.out.println();
            }
            System.out.println();
            for (String currentGenre : genres){
                System.out.println("First 3 books in " + currentGenre);
                for (String currentISBN : myLibrary.getISBNsForGenre(currentGenre, 3)){
                    System.out.println(myLibrary.getBookInfo(currentISBN));
                }
                System.out.println();
            }
            System.out.println();

            for (String currentAuthor : authors){
                System.out.println("All books by " + currentAuthor);
                for (String currentISBN : myLibrary.getISBNsForAuthor(currentAuthor, totalBooks)){
                    System.out.println(myLibrary.getBookInfo(currentISBN));
                }
                System.out.println();
            }
            System.out.println();
            for (String currentAuthor : authors){
                System.out.println("First 2 books by " + currentAuthor);
                for (String currentISBN : myLibrary.getISBNsForAuthor(currentAuthor, 2)){
                    System.out.println(myLibrary.getBookInfo(currentISBN));
                }
                System.out.println();
            }
            System.out.println();

            for (String currentPublisher : publishers){
                System.out.println("All books published by " + currentPublisher);
                for (String currentISBN : myLibrary.getISBNsForPublisher(currentPublisher, totalBooks)){
                    System.out.println(myLibrary.getBookInfo(currentISBN));
                }
                System.out.println();
            }
            System.out.println();
            for (String currentPublisher : publishers){
                System.out.println("First book published by " + currentPublisher);
                for (String currentISBN : myLibrary.getISBNsForPublisher(currentPublisher, 1)){
                    System.out.println(myLibrary.getBookInfo(currentISBN));
                }
                System.out.println();
            }
            System.out.println();

            System.out.println("All books published after 2000");
            for (String currentISBN : myLibrary.getISBNsPublishedAfterYear((short) 2000, totalBooks)){
                System.out.println(myLibrary.getBookInfo(currentISBN));
            }
            System.out.println();
            System.out.println("First 5 books published after 2000");
            for (String currentISBN : myLibrary.getISBNsPublishedAfterYear((short) 2000, 5)){
                System.out.println(myLibrary.getBookInfo(currentISBN));
            }
            System.out.println();

            System.out.println("All books with at least 400 pages");
            for (String currentISBN : myLibrary.getISBNsWithMinimumPageCount(400, totalBooks)){
                System.out.println(myLibrary.getBookInfo(currentISBN));
            }
            System.out.println();
            System.out.println("First 5 books with at least 400 pages");
            for (String currentISBN : myLibrary.getISBNsWithMinimumPageCount(400, 5)){
                System.out.println(myLibrary.getBookInfo(currentISBN));
            }
            System.out.println();
        }
	    catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /*tests:
        getShelfNames()
        getISBNsOnShelf()
        getBookTitle()
        getShelfNames()
     */
    private static void displayLibrary(Library library){
        System.out.println("\nCOMPLETE LIBRARY");
        List<String> shelves = library.getShelfNames();
        for (String shelf : shelves) {
            List<String> bookIds = library.getISBNsOnShelf(shelf);

            System.out.println(String.format("'%s' (%d books):", shelf, bookIds.size()));
            for (String id : bookIds) {
                System.out.println(id + " " + library.getBookTitle(id) + " by " + library.getBookAuthor(id));
            }
            System.out.println();
        }
    }
}
