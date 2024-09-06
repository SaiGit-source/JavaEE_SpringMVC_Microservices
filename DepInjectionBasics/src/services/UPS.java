package services;

public class UPS implements Interface_Deliver {
	// all the child classes have their own implementations

	@Override
	public Boolean deliverProduct(double amount) {
		System.out.println("Hi UPS delivered your package, amount is "+amount);
		return true;
	}

}
