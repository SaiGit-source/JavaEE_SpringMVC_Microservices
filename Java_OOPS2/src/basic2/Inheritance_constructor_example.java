package basic2;

class Alpha
{
	int a, b; // instance variables will go into heap
	
	public Alpha(){
		a=10;
		b=100;
		System.out.println("Zero parameter parent Alpha");
	}
	
	public Alpha(int a, int b){
		this.a = a;
		this.b = b;
		System.out.println("parameterized parent Alpha");
	}
	
}

class Beta extends Alpha
{
	int x, y;
	
	public Beta()
	{
		x=10;
		y=20;
		System.out.println("Zero parameter child Beta");
	}
	
	public Beta(int x, int y)
	{
		this.x = x;
		this.y = y;
		System.out.println("parameterized child Beta");
	}
	
	public Beta(int x)
	{
		super(35, 45);
		this.x = x;
		this.y = 30;
		System.out.println("parameterized child Beta with parameterized parent Alpha");
	}
	
	public void disp() {
		System.out.println("a: "+a); // it gets a and b from parent
		System.out.println("b: "+b);
		System.out.println("x: "+x);
		System.out.println("y: "+y);
	}
}


public class Inheritance_constructor_example {

	public static void main(String[] args) 
	{
		Beta b = new Beta(); // child has inherited parent variables as well and they are all initialized to 0 in Heap
		b.disp();
		
		System.out.println();
		
		Beta b1 = new Beta(200, 300); // child has inherited parent variables as well and they are all initialized to 0 in Heap
		b1.disp(); // Beta(int x, int y) have a super() method by default, so it goes to parent Alpha() constructor
		
		System.out.println();
		
		Beta b2 = new Beta(250); // since Beta(int x) has a super(20, 30) parameterized method it will go to parent parameterized constructor
		b2.disp();
		
		System.out.println("Not creating a child object");
		
		new Beta().disp(); //this also works, not explicitly creating a child object
	}

}
