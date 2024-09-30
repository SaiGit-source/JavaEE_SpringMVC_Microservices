package enums;
// Enums are group of named constants. for example, Week type

public class enumExample1 {
	enum Week {
		MON, TUE, WED, THU, FRI, SAT, SUN;
	}
	
	public static void main(String[] args) {
		Week[] weekAr = Week.values();
		
		for (Week w:weekAr) {
			System.out.println("Index: "+w.ordinal() + " -> " + w);
		}
		
		// ordinal() -> prints the index of Enums
		
		/*
		  	Index: 0 -> MON
			Index: 1 -> TUE
			Index: 2 -> WED
			Index: 3 -> THU
			Index: 4 -> FRI
			Index: 5 -> SAT
			Index: 6 -> SUN
		 */

	}

}
