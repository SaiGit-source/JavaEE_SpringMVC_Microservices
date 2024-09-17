package basics;

public class ImmutableString2 {

	public static void main(String[] args) {
		String s1 = "Abc";
		String s2 = "Abc";
		System.out.println(s1.compareTo(s2));
		// compareTo() method compares each character in both strings.
		// it converts to Ascii values then does A=65-A=65 etc
		// once it sees a difference it stops
		
		
		String s3 = "Cba";
		String s4 = "Abc";
		System.out.println(s3.compareTo(s4));
		// C is 67 and A is 65 so difference should be 2. however it stops comparing character-by-character once it sees a difference
		// negative values if s2 is bigger than s1 lexicographically
		

	}

}
