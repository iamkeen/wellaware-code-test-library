package us.wellaware.library;
import java.util.*;

public class Shelf
{
	private ArrayList<String> booksOnShelf = new ArrayList<String>();
	private String genre;
	private int number;

	public Shelf(String genre, int number)
	{
		this.genre = genre;
		this.number = number;
	}

	public String getGenre(){
		return genre;
	}

	public int getNumber(){
		return number;
	}

	public ArrayList<String> getBooksOnShelf(){
		return booksOnShelf;
	}

	public String toString()
	{
		return genre + " - " + number;
	}
}