package main;

import services.Interface_Deliver; // we need to import because it is in a different package

public class AmazonCommon {
	Interface_Deliver service; // we cannot create an object from Interface
	
	
	public AmazonCommon(Interface_Deliver service) {
		super();
		this.service = service; // to resolve ambiguity since both variable names are the same, we use the 'this' keyword
	}
	// if parameterized constructor is specified, the default constructor wont be there. we will have to explicitly define zero param constructor in this case
	
	public AmazonCommon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setiDeliver(Interface_Deliver iDeliver) {
		service = iDeliver;
	}
	
	// here we cannot have the dependent classes like FedEx or UPS thats why we are using the Interface
	
	public Boolean AmazonDelivery(double amount) { // this signature matches the Interface method signature
		return service.deliverProduct(amount);
		// deliverProduct() is the method from Interface. Interface says the return type is Boolean as well
	}
	
	

}
