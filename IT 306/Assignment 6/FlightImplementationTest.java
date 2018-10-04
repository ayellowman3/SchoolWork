import static org.junit.Assert.*;

import org.junit.Test;

public class FlightImplementationTest {

	@Test
	public void test() {
		UnsortedPriorityQueue upq = new UnsortedPriorityQueue();
		upq.add(new Flight("A", false));
		upq.add(new Flight("B", true, 1));
		upq.add(new Flight("C", true, 0));
		String answer = "Value: F#C, key: 0\n"+
						"Value: F#B, key: 1\n"+
						"Value: F#A, key: 1000000\n";
				
		assertEquals(answer, FlightImplementation.print(upq));
		
		upq.add(new Flight("A", false));
		upq.add(new Flight("C", true, 0));
		upq.add(new Flight("B", true, 1));
		answer = "Value: F#C, key: 0\n"+
						"Value: F#B, key: 1\n"+
						"Value: F#A, key: 1000000\n";
				
		assertEquals(answer, FlightImplementation.print(upq));
		upq.add(new Flight("B", true, 1));
		upq.add(new Flight("A", false));
		upq.add(new Flight("C", true, 0));
		answer = "Value: F#C, key: 0\n"+
						"Value: F#B, key: 1\n"+
						"Value: F#A, key: 1000000\n";
				
		assertEquals(answer, FlightImplementation.print(upq));
		upq.add(new Flight("B", true, 1));
		upq.add(new Flight("C", true, 0));
		upq.add(new Flight("A", false));
		answer = "Value: F#C, key: 0\n"+
						"Value: F#B, key: 1\n"+
						"Value: F#A, key: 1000000\n";
				
		assertEquals(answer, FlightImplementation.print(upq));
		
		upq.add(new Flight("C", true, 0));
		upq.add(new Flight("A", false));
		upq.add(new Flight("B", true, 1));
		answer = "Value: F#C, key: 0\n"+
						"Value: F#B, key: 1\n"+
						"Value: F#A, key: 1000000\n";
				
		assertEquals(answer, FlightImplementation.print(upq));
		
		upq.add(new Flight("C", true, 0));
		upq.add(new Flight("B", true, 1));
		upq.add(new Flight("A", false));
		answer = "Value: F#C, key: 0\n"+
						"Value: F#B, key: 1\n"+
						"Value: F#A, key: 1000000";
				
		assertEquals(answer, FlightImplementation.print(upq));
	}

}
