package us.wellaware.library;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/*
    - Need:
        - Book object
            - contains data regarding book
                - isbn, title, author, genre, publisher, publication year, page count
*/

public class Book
{
	public long isbn;
	public String title;
	public String author;
	public String genre;
	public String publisher;
	public int publicationYear;
	public int pageCount;

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

	//TODO: equals for book's title
}