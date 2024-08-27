package basic2;

class Person{
	String name;
	
	public Person() {
		super();
		System.out.println("Zero parameter constructor");
	}
	
	public Person(String name) {
		this.name=name;
		System.out.println("One parameter");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

class Demo{
	int num1;
	int num2;
	
	Demo(){
		super(); // all classes will have super() by default even if it is not specified
		System.out.println("Zero parameter constructor");
		// this() or super() must be the first lines of constructors
	}
	
	Demo(int num1){
		this(); // this or super either one will be there
		// this() will refer to super() class first
		this.num1 = num1;
		this.num2 = 44;
		System.out.println("One parameter constructor");
	}
	
	Demo(int num1, int num2){
		this(num1); // this will go to Demo(int num1) one parameter constructor first
		this.num1=num1;
		this.num2=num2;
		System.out.println("Two parameter constructor");
	}
	
	void disp()
	{
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
	}

}


public class constructors_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo demo0 = new Demo();
		demo0.disp(); // it prints the default int values 0
		Demo demo1 = new Demo(4);
		demo1.disp(); // this() method first goes to super() so it prints "Zero parameter constructor"
		Demo demo2 = new Demo(3, 5);
		demo2.disp(); // this goes into One parameter constructor, but one parameter constructor takes into super() constructor, then prints Two parameter constructor
// in a way we could think this() as the constructor_name(), this(num1) is constructor_name(int num1)
		
		Person person1 = new Person();
		person1.setName("Abc");
		System.out.println(person1.getName());
		Person person2 = new Person("Mno"); // here we are instantiating with "Mno"
		System.out.println(person2.getName());
		person2.setName("Xyz"); // here we are replacing with "Xyz" also know as 'setter injection'
		System.out.println(person2.getName()); // and it did get replaced
		
		
	}

}
