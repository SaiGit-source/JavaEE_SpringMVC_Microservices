import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Employee;

public class OnlyXML {

	public static void main(String[] args)
	{
		//BeanFactory
		//ApplicationContext
		
		// constructor values are defined in the XML file for the bean
		
		/*
		 * 	Employee Bean created
		 	***************************
			Employee [empid=2, name=Name, salary=5454.4, city=Jacksonville]
			Employee task....
		 */
		
		
		ApplicationContext container=new ClassPathXmlApplicationContext("applicationconfig.xml");

		System.out.println("***************************");
		Employee emp1 = container.getBean("emp1",Employee.class);
		System.out.println(emp1);
		System.out.println(emp1.employeeTask());
		
	}

}
