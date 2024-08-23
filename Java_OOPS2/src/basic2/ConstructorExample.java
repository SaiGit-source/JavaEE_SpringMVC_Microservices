package basic2;
class Dog {
	String name;
	String color;
	
	Dog (String name, String color)
	{
		this.name=name;
		this.color=color;
	}
	// here we have basic constructor with this keyword but no setters
	// this constructor replaced setters
	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}	
}

class Learner 
{
	private int id;
	private String name;
	private String city;
	// no constructor here, still Java is generating in background by default

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	
}


public class ConstructorExample {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Learner learner=new Learner();
		learner.setId(1);
		learner.setName("Rohan");
		learner.setCity("bengaluru");
		System.out.println(learner.getCity());
		
		Dog d1 = new Dog("Jim", "White");
		System.out.println(d1.color);
		
		

		
				

	}

}
