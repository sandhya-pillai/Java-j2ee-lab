package book;
import java.util.*;
public class BCollection {

	public static ArrayList<Book> bc=new ArrayList<Book>();
	public static void main(String args[])
	{
		bc.add(new Book("A","A","A",10));
		bc.add(new Book("B","B","B",9));
		bc.add(new Book("D","C","C",8));
		bc.add(new Book("C","C","C",7));
		
		System.out.println("Before sorting");
		for(Book b: bc)
		{
			System.out.println(b);
			
		}
		
		Collections.sort(bc,new Book());
		System.out.println("After sorting");
		for(Book b: bc)
		{
			System.out.println(b);
			
		}
		
	}
}
