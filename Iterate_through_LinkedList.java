//How to Iterate through LinkedList Instance in Java?

import java.util.*;
 
public class InbuiltLinklist{
 
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Paypal");
		linkedList.add("Google");
		linkedList.add("Yahoo");
		linkedList.add("IBM");
		linkedList.add("Facebook");
 
		// ListIterator approach
		System.out.println("ListIterator Approach: ==========");
		Iterator<String> it = linkedList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
 
		System.out.println("\nLoop Approach: ==========");
		// Traditional for loop approach
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}
 
		// Java8 Loop
		System.out.println("\nJava8 Approach: ==========");
 
		// forEach Performs the given action for each element of the Iterable until all elements have been processed or
		// the action throws an exception.
		linkedList.forEach(System.out::println);
	}
 
}
