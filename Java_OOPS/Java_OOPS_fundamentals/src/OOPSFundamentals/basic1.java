package OOPSFundamentals;

class Calc
{
	int num1;  // Instance variables go into Heap
	int num2; // deleted by garbage collector once stackframe is gone from Stack memory after program execution 
	// Instance var are automatically initialized but not local variables
	// Scope is class
	void add()
	{
		num1=10;
		num2=20;
		int res=num1+num2; // local variable goes into Stack memory
		System.out.println(res);
	}
	
}


public class basic1 {

	public static void main(String[] args)
	{
		Calc c=new Calc();
		c.add();

	}

}
