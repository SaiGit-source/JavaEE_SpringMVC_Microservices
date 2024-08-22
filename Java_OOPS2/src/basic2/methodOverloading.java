package basic2;


class AdditionCalc 
{
	int add(int n1, int n2)
	{
		return	n1+n2;
	}
	int add(int n1, int n2, int n3){
		return n1+n2+n3;
	}
	
	double add(int n1, int n2, double n3){
		return n1+n2+n3; 
	}
	
	double add(int n1, int n2, int n3, double n4){
		return n1+n2+n3+n4; 
	}
	
	void add(int n1, double n2)
	{
		double res= n1+n2;
	}
}

public class methodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=10;
		int y=20;
		int z=30;
		int p = 23;
		double a=10.5;
		
		AdditionCalc cal=new AdditionCalc();
		
		System.out.println(cal.add(x, y, z));
		System.out.println(cal.add(x, y, a));
		System.out.println(cal.add(x, y, z, p)); 
		// we dont a method for adding 4 int's however 3 int + 1 
		// double method can accommodate this request because of implicit type-casting

	}

}
