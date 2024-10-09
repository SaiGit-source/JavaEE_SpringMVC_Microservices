package TryNewFeature;

import java.io.BufferedWriter;
import java.io.FileWriter;

// the idea here is to close all the resources in the finally block, because it executes no matter exception happened or not, or exception handled or not
// this new feature writing try(BufferedWriter writer=new BufferedWriter(new FileWriter("D:\\java.txt"))) will automatically close the resources no matter what
// to demonstrate this feature, we could Override close() method and see what happens

class Abc implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Close method is invoked by default with try feature");
	}
	
}

public class AutocloseableExample {

	public static void main(String[] args) throws Exception {
		
		// this is the normal way
		BufferedWriter writer=null;
		
		try{
			writer = new BufferedWriter(new FileWriter("C:\\Java_basics.txt")); // here you got to use real path otherwise it will fail
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			writer.close();
		}
		
		// this is the new feature try with resources. here we dont need the finally block, resource gets closed automatically
		
		try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Java_basics.txt"))) {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// when i run this block, close() method will be executed eve though we didnt explicitly call them
		
		try(Abc abc = new Abc()){
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
