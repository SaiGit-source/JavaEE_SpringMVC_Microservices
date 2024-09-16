package basics;

public class ImmutableStrings {

	public static void main(String[] args) {
		// two kinds of strings Mutable and Immutable
		// Immutable strings that dont change often like name, father's name etc
		// doesn't mean it is constant like 'final' keyword
		// basically it will create another string object if you extend the same string, old string wont be replaced in the memory instead new string obj will be created in memory
		
		// two kinds of immutable
		// string literal and new keyword
		String str1 = "Abc";
		String str2 = "Abc";
		// for string literals, string objects are created in String constant pool (SCP).
		// in SCP, before creating another obj, it will scan first for the content, if "Abc" is already there it wont create a duplicate, instead will point to the same obj in the memory
		System.out.println(str1==str2); // comparing memory refs not data
		// ans is true because both Objs are referring to the same memory location in SCP
		System.out.println(str1.equals(str2)); // true
		
		String str3 = new String("Abc");
		String str4 = new String("Abc");
		// String is a class so objects are initiated in the Heap area this time, not in SCP because of new keyword
		// in the general Heap area, duplicates are allowed
		// therefore, two objs are created and referring to two different memory locations
		System.out.println(str3==str4); // false
		System.out.println(str3.equals(str4)); // true because equals() compares the data
		
		String str5 = new String("Abc"); // obj in Heap area
		String str6 = "Abc"; // obj in SCP area
		System.out.println(str5==str6); // false because two diff memory locations
		System.out.println(str5.equals(str6));// true because contents are the same
		
		String str7 = "Abc";
		String str8 = "abc";
		System.out.println(str7==str8); // Java is case-sensitive so false diff memory locations, they are not seen as duplicates in SCP
		System.out.println(str7.equals(str8)); // false
		System.out.println(str7.equalsIgnoreCase(str8)); // we ignore case so true
		
		// Concatenation
		String s1 = "Abc";
		s1 = s1.concat(" Alien"); // here i am able to assign a new memory address to s1 but the string in the old memory will not get replaced however, it will eventually become referenceless and gets removed by Garbage collector
		// whenever a ref variable is involved like s1 there will be another copy on Heap as well. it behaves like new keyword even though it is not there
		String s2 = "Abc Alien"; // it is in SCP
		System.out.println(s1==s2);// false because one is on Heap and other on SCP
		System.out.println(s1.equals(s2)); // true
		
		String s3 = s1+s2; // now ref variables are there like s1 and s2 so it gets created on Heap not SCP
		System.out.println(s3);// whenever i print an object of a class such as String it should print only the address but why is it printing the value because toString() method is overridden in the String class
		String s4 = "Abc"+" Alien"+123; // this gets created on SCP due to String literal
		String s5 = "Abc"+" Alien"+123;
		System.out.println(s4==s5); // true due to same memory shared by two diff variables
		
		System.out.println();
		// String methods() like length(), toUpperCase(), toLowerCase(), substring, toCharArray(), charAt(), contains(), startWith(), indexOf(), lastIndexOf()
		String s6 = "america";
		System.out.println(s6.toUpperCase());
		System.out.println(s6.substring(2)); // no need to specify end Index
		System.out.println(s6.contains("erica")); // true if contains substring very handy
		System.out.println(s6.indexOf('a')); // first occurence of 'a'
		System.out.println(s6.lastIndexOf('a')); // last occurence of 'a'
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
