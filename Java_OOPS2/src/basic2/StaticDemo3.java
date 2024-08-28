package basic2;

class Demo4 {
	static {
		System.out.println("Static Block 1");
	}
	static {
		System.out.println("Static Block 2");
	}
	
	{
		System.out.println("Non-Static Block 1");
	}
	{
		System.out.println("Non-Static Block 2");
	}
	{
		System.out.println("Non-Static Block 3");
	}
	
}

class Demo3{
	static {
		disp();
	}
	
	static int a = 10;
	
	public static void disp() {
		System.out.println(a);
	}
}

public class StaticDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo3.disp(); // when static block is read during class-loading time, a's value is 0 in the memory
		Demo3 d4 = new Demo3();
		d4.disp(); // since static int a=10 is already read once and stored in memory, second time it prints 10
		// static var can be accessed through both Obj reference and class reference
		Demo4 d1 = new Demo4(); // Static block is printed only once or when only the first object is initialized thats when the class Demo4 is loaded for the first time
		Demo4 d2 = new Demo4(); // here Static block is not executed

	}

}
