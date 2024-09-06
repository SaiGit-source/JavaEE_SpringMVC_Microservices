package services;

public class DHL implements Interface_Deliver {

	@Override
	public Boolean deliverProduct(double amount) {
		System.out.println("Hi DHL delivered your package, amount is "+amount);
		return true;
	}

}
