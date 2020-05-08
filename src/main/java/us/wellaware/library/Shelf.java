package us.wellaware.library;

import java.util.*;

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

	public String toString()
	{
		return genre + " - " + number;
	}
}