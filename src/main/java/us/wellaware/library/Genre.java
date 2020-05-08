package us.wellaware.library;

import java.util.*;

public class Genre
{
    public ArrayList<Book> books = new ArrayList<Book>();
    public String name;
    public ArrayList<Shelf> shelves = new ArrayList<Shelf>();

    public Genre(String name)
    {
        this.name = name;
    }

}
