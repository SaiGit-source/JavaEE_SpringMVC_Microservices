package basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Passport{
	private String name;
	private String city;
	private String country;
	
	public Passport(String name, String city, String country) {
		super();
		this.name = name;
		this.city = city;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Passport [name=" + name + ", city=" + city + ", country=" + country + "]";
	}
	
}

public class PassportAppln {

	public static void main(String[] args) {
		Map<Integer, Passport> passportMap = new HashMap<>();
		Integer id1 = Integer.valueOf(101);
		Integer id2 = Integer.valueOf(201);
		Integer id3 = Integer.valueOf(301);
		
		Passport p1 = new Passport("Abc", "Portland", "USA");
		Passport p2 = new Passport("Xyz", "Fort Lauderdale", "USA");
		Passport p3 = new Passport("Pqr", "Providence", "USA");
		
		passportMap.put(id1, p1);
		passportMap.put(id2, p2);
		passportMap.put(id3, p3);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Passport number: ");
		Integer userN = Integer.valueOf(scan.nextInt());
		
		Set<Entry<Integer, Passport>> pptEntry = passportMap.entrySet();
		Boolean flag = false;
		
		Iterator itr = pptEntry.iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Passport> pair = (Entry<Integer, Passport>) itr.next();
			Integer key = pair.getKey();
			if (key.equals(userN)) {// this is Integer object so use equals(), which compares data
				System.out.println("User verified");
				System.out.println(passportMap.get(key));
				flag=true;
				break;
			}
		}
		
		if(flag==false) {
			System.out.println("User not found");
		}
		
	}

}
