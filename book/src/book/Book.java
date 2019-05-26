package book;
import java.util.Comparator;
public class Book implements Comparator<Book>{
	
	String title;
	String author;
	String publisher;
	int price;
	
	public Book()
	{
	}
	public Book(String t,String a,String p,int pr)
	{
		title=t;
		author=a;
		publisher=p;
		price=pr;
	}
	
	public int compare(Book a,Book b)
	{
		return a.title.compareTo(b.title);
	}
	
	public String toString()
	{
		return " "+title+" "+author+" "+publisher+" "+price;
	}

}
