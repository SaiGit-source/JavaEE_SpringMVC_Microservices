package basic2;
// Static var or block gets created during class loading time and they are allocated in Heap during class loading once
// they are not called during object creation
// thats why they are called as non-instance or class variables as well
// the other way to look into it as, they are static once initialized
// so static vars are object-independent

class DemoStatic {
	static int p, q, r; // non-instance var
	int x, y, z; // instance var
	
	static { // static init block
		p=10;
		q=20;
		r=30;
		System.out.println("Static initiation block");
	}
	
	static void static_disp(){ // static method
		System.out.println("Static disp method");
		System.out.println("p: "+p);
		System.out.println("q: "+q);
		System.out.println("r: "+r);
	}
	
// Object portion ***************************
	
	{ // Java initiation block
		// it gets called whenever an object is created, same like Constructor() but it gets executed before the Constructor()
		System.out.println("Java initialization block");
	}
	
	DemoStatic(){
		System.out.println("Constructor block");
		x=10;
		y=20;
		z=30;
	}
	
	void object_disp() {// Object method or non-static
		System.out.println("Non-static method");
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		System.out.println("z: "+z);
		System.out.println("Static var in Non-static method");
		System.out.println("p: "+p);
		System.out.println("q: "+q);
		System.out.println("r: "+r);
	}
	
};

class StudentStatic {
	int id; // comes to life only when object is created
	String name;
	static int count=0; // static var we want to remember the previous value at the same time increment when object is being created. so we put this var in Java initialization block as opposed to Static block
	// Static var is created once during class loading and not during object creation
	{
		System.out.println("Java initialization block in Student");
		count++; // we put in Java initialization block as opposed to static block
	}
	
	StudentStatic(int id, String name){
		this.id = id;
		this.name = name;
		System.out.println("Student constructor"); 
	}
	
	void student_disp() {
		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Count of students: "+count);
	}
	
}

public class staticExample {
	static int a; // static var or static method is read before main() method if they are in main() method class
	static {
		a=10;
		System.out.println("Static block in main class");
		System.out.println(a);	// it prints before main method
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main method");
		DemoStatic.static_disp(); // No object initialization here because it is a static method
		DemoStatic d1 = new DemoStatic();
		d1.object_disp();
		DemoStatic d2 = new DemoStatic();
		d2.object_disp(); // Only here the instance var come to life on Heap unlike Static var
		System.out.println("********************");
		System.out.println("Student example"); 		
		StudentStatic st1 = new StudentStatic(23, "Rohan"); 
		st1.student_disp();
		StudentStatic st2 = new StudentStatic(33, "Abc"); 
		st2.student_disp();
		StudentStatic st3 = new StudentStatic(43, "Xyz"); 
		st3.student_disp(); // here count static var is used in the object method (non-static method still increments
		
	}

}
