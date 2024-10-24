package service;

public class Employee 
{
	private Integer empid;
	
	private String name;
	
	private Double salary;
	
	private String city;

	public Employee(Integer empid, String name, Double salary, String city) {
		super();
		System.out.println("Employee Bean created");
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
	
	
	public String employeeTask()
	{
		return "Employee task....";
	}	
	
}
