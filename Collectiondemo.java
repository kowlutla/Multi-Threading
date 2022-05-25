import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class Collectiondemo 
{
	public static void main(String args[])
	{
//		Collection <Object>value=new ArrayList<Object>();
//		value.add(3);
//		value.add("Kowlutla");
//		value.add(3.3);
//		Iterator i=value.iterator();
//		while(i.hasNext())
//		{
//			System.out.println(i.next());
//		}
//		value.remove("Kowlutla");
//		for(Object j:value)
//		{
//			System.out.println(j);
//		}
		try 
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("No of elements to store: ");
			int k=Integer.parseInt(br.readLine());
			List<Integer>values=new ArrayList<Integer>();
			System.out.println("- - - Enter elements into list - - -");
			for(int i=1;i<=k;i++)
			{
				System.out.print("Element "+i+" : ");
				int n=Integer.parseInt(br.readLine());
				values.add(n);
			}
			System.out.println("- - - Printing elements of list using Iterator - - -");
			Iterator i=values.iterator();
			while(i.hasNext())
			{
				System.out.print(i.next()+"  ");
			}
			System.out.println("\n- - -Printing elements of list using Enhanced for loop - - -");
			for(Object value:values)
			{
				System.out.print(value+"  ");
			}
			//System.out.println("\n- - -Printing elements of list using  for loop - - -");
			System.out.print("\n"+values);
			values.add(1,10);
			System.out.println("\n"+values);
			System.out.println("\n- - - printing elements of list using for each loop - - -");
			values.forEach(System.out::print);
			//Sorting elements
			Collections.sort(values);
			System.out.println("\n- - - Sorted List - - -");
			values.forEach(System.out::println);
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
//COLLECTION: group of objects as its elements is called collection
//GENERICS: Mentioning the what type of data in your collection is called generics
//LIST: List is interface which is extended from collection