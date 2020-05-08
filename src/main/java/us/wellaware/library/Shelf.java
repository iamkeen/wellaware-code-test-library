package us.wellaware.library;

import java.util.*;

/*
- Shelf object
    - contains 
        - genre (Science fiction)
        - number (1)
        - books objects
        - counter of books on shelf
*/

public class Shelf
{
	public ArrayList<Book> books = new ArrayList<Book>();
	public String genre;
	public int number;

	public Shelf(String genre, int number)
	{
		this.genre = genre;
		this.number = number;
	}
}