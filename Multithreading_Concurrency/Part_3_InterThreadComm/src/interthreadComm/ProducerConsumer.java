package interthreadComm;

// in the previous multi-threading examples, we were able to achieve only intra-communications thats threads within the same class were able to communicate
// here we will achieve inter-communications, Producer should produce only if Consumer consumes that data therefore they got to communicate with each other
// inter-thread communication is achieved by wait() and notify() methods

/* Example output -> Producer does not keep on producing data, it produces only when Consumer has consumed that data. this is inter-thread communication
 * 	Producer has produced data: 145745
	Producer in wait state
	Consumer has consumed data: 145745
	Consumer in wait state
	Producer has produced data: 145747
	Producer in wait state
	Consumer has consumed data: 145747
	Consumer in wait state
 */

class Queue{
	// this is the mediator class
	enum Status {PRODUCE, CONSUME};
	Status status = Status.CONSUME;
	int data;
	
	synchronized public void produce(int i) {
		// for inter-thread communication, we need to use the 'synchronized' keyword
		try {
		if (status==Status.PRODUCE) {
			data = i;
			System.out.println("Producer has produced data: "+data);
			status=Status.CONSUME;
			notify(); // notify the consumer to consumer data
		}
		else {
				System.out.println("Producer in wait state");
				wait(); // make Producer thread to wait until notify
				} 
			}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized public void consume() {
		try {
		if (status==Status.CONSUME) {
			System.out.println("Consumer has consumed data: "+data);
			status=Status.PRODUCE;
			notify(); // notify the produce to produce next data
		}
		else {
				System.out.println("Consumer in wait state");
				wait(); // make Consumer thread to wait until notify
				} 
			}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}

class Producer extends Thread{
	
	// we need the mediator class Queue object here. but we dont want to create the object here
	// Queue q = new Queue(); // this is tight coupling
	
	int i=1;
	Queue q;

	public Producer(Queue q) {
		this.q = q; // constructor dependency injection
	}
	
	public void run() {
		while(true) {
			q.produce(i++);
		}
	}
}


class Consumer extends Thread{
	
	// we need the mediator class Queue object here. but we dont want to create the object here
	// Queue q = new Queue(); // this is tight coupling
	Queue q;

	public Consumer(Queue q) {
		this.q = q; // constructor dependency injection
	}
	
	public void run() {
		while(true) {
			q.consume();
		}
	}
}


public class ProducerConsumer {
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		/*
		Producer producer = new Producer(q); // passing in the object dependency injection
		Consumer consumer = new Consumer(q);
		
		producer.start(); // it extends the Thread class
		consumer.start();
		*/
		
		// Anonymous object is used when only one method is invoked 
		new Producer(queue).start();
		new Consumer(queue).start();
		
	}

}
