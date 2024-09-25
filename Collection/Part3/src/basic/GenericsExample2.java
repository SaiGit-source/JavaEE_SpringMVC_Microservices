package basic;

interface Alpha<T>{
	
}

class Generics<T> implements Alpha<Integer>{ // it takes the datatype as input
	T ref; // variable
	public Generics(T ref) {// T is the datatype in this case
		this.ref = ref;
	}
	
	public void dispDataType() {
		System.out.println("The type of T is: "+ref.getClass().getName());
	}
	
	public void dispVal() {
		System.out.println("The var value is: "+ref);
	}
	
}

public class GenericsExample2 {

	public static void main(String[] args) {
		Generics<Integer> gen = new Generics<>(35);
		gen.dispDataType(); // displays Integer
		gen.dispVal();
		
		Generics<String> str = new Generics<>("Springboot"); // similarly i can pass in String as well
		str.dispDataType(); // displays String
		str.dispVal();


	}

}
