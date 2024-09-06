package services;

public class FedEx implements Interface_Deliver {

	@Override
	public Boolean deliverProduct(double amount) {
		System.out.println("Hi FedEx delivered your package, amount is "+amount);
		return true;
	}

}
