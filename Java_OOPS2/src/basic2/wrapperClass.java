package basic2;

public class wrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 10;
		// converting primitive into wrapper class object is boxing
		Integer n2 = n1; // this is autoboxing because it automatically get converted
		Integer n3 = new Integer(n1); // this is deprecated
		Integer n4 = Integer.valueOf(n1); // this is only boxing, not happening automatically
		
		Integer n5 = Integer.valueOf(10);
		int n6 = n5;// this is Autounboxing
		// Unboxing is converting wrapper class objects into primitives such as 'int'
		
		int n7 = n5.intValue(); // this is unboxing not automatically happening
				

	}

}
