package basics;

public class MutableStrings {

	public static void main(String[] args) {
		// two options: StringBuilder and StringBuffer
		// the difference is only with respect to multi-threading
		// StringBuilder's methods are non-synchoronous that means it allows multiple threads to run
		// StringBuffer's methods are synchoronous so multi-threading is not possible
		
		StringBuffer sb1 = new StringBuffer("Abc");
		sb1.append(" Alien"); // same string is getting extended no new String object is being created unlike mutable
		System.out.println(sb1.capacity());
		
		StringBuilder sb2 = new StringBuilder("Abc");
		System.out.println(sb1.capacity()); // when capacity goes beyond 19 lets say, then new capacity = old capacity * 2 + 2
		StringBuilder sb4 = new StringBuilder("Abc");
		// whenever we have the 'new' keyword memory is allocated in the Heap area
		// so duplicate objects with the same content is allowed
		System.out.println(sb2.equals(sb4));
		// in Immutable strings equals() method compares contents, while in Mutable strings it compares references
		// In Immutable strings, the equals() method is overridden while in Mutable strings it is inherited so the default behavior to compare only references is exhibited 
		
	}

}
