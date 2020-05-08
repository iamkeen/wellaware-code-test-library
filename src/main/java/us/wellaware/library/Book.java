package us.wellaware.library;

import java.util.*;

public class Book implements Comparable<Book>
{
	public long isbn;
	public String title;
	public String author;
	public String genre;
	public String publisher;
	public int publicationYear;
	public int pageCount;
	public Shelf shelf;

	public Book(long isbn, String title, String author, String genre, String publisher, int publicationYear, int pageCount)
	{
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.pageCount = pageCount;
	}

	public String toString()
	{
		return "" + isbn + "\n" + title + "\n" + author + "\n" + genre + "\n" + publisher + "\n" + publicationYear + "\n" + pageCount + "\n\n";
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