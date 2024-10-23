package service;

public class Java implements ICourse {

	public Java()
	{
		System.out.println("Java Bean Created");
	}
	
	@Override
	public Boolean getTheCourse(Double amount) {
		System.out.println("Java Course is purchased and amount paid is "+ amount);
		return true;
	}

}
