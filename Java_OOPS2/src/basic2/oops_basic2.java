package basic2;

class Calc
{
	int num1;  // Instance variables go into Heap
	int num2;
	int res; // deleted by garbage collector once stackframe is gone from Stack memory after program execution 
	// Instance var are automatically initialized but not local variables
	// Scope is class
	void add1(int n1, int n2) // here n1, n2 are declared inside method only so local variables
	{
		int res=n1+n2; // local variable goes into Stack memory
		System.out.println(res);
	}
	
	int add2(int n1, int n2)
	{
		int res=n1+n2; // local variable goes into Stack memory
		// System.out.println(res);
		return res;
	}
	
	int add3(int n1, int n2)
	{
		res=n1+n2; // local variable goes into Stack memory
		// System.out.println(res);
		return res;
	}
	
}


public class oops_basic2 {

	public static void main(String[] args)
	{
		Calc c=new Calc(); // c is holding a reference of an object so reference object
		c.add1(10, 20);
		int result = c.add2(10,20); // you can collect int variable or not
		// result is declared in stack area local variable
		int result1 = c.add3(10,20);
		System.out.println("result from main " + result);
		System.out.println("result from main " + result1);
	}

}
