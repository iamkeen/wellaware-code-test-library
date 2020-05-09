package us.wellaware.library;
import java.util.*;

public class Book implements Comparable<Book>
{
	private String isbn;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private int publicationYear;
	private int pageCount;

	public Book(String isbn, String title, String author, String genre, String publisher, int publicationYear, int pageCount)
	{
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.pageCount = pageCount;
	}

	public String getISBN(){
		return isbn;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String getGenre(){
		return genre;
	}

	public String getPublisher(){
		return publisher;
	}

	public int getPublicationYear(){
		return publicationYear;
	}

	public int getPageCount(){
		return pageCount;
	}

	public String toString() {
		return "" + isbn + "\\" + title + "\\" + author + "\\" + genre + "\\" + publisher + "\\" + publicationYear + "\\" + pageCount + "\\";
	}

	public int compareTo(Book b)
	{
		if (this.author.compareTo(b.author) == 0)
		{
			return this.title.compareTo(b.title);
		}
		else
		{
			return this.author.compareTo(b.author);
		}
	}
}