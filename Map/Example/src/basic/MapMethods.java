package basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// four classes implement the Map<> interface -> HashMap, Hashtable, TreeMap and LinkedHashMap

interface Alpha{
	interface Beta{
		static void disp() {
			System.out.println("inner interface static method()");
		}
	}
}


public class MapMethods {

	public static void main(String[] args) {
		Alpha.Beta.disp(); // to invoke inner interface method()
		
		Map<Integer, String> hm1 = new HashMap<>();
		hm1.put(1,  "Java");
		hm1.put(2,  "SpringBoot");
		hm1.put(3,  "Maven");
		
		System.out.println(hm1);
		
		// iterate only values
		
		Collection<String> val = hm1.values(); // returns Collection<Object>
		Iterator<String> itrVal  = val.iterator();
		
		while(itrVal.hasNext()) {
			System.out.println("Val: "+itrVal.next());
		}
		
		// iterate only keys
		
		Set keys = hm1.keySet(); // returns Set
		Iterator<Integer> itrKey  = keys.iterator();
		
		while(itrKey.hasNext()) {
			System.out.println("Key: "+itrKey.next());
		}
		
		// iterate both key and value -> key, val together is called as Entry
		
		Set entry = hm1.entrySet() ; // returns Set
		Iterator<Entry> itrEntry  = entry.iterator();
		
		while(itrEntry.hasNext()) {
			// System.out.println("Entry: "+itrEntry.next());
			Map.Entry<Integer, String> pair = itrEntry.next(); // key-val together is Entry
			System.out.println("Key: "+pair.getKey()+" Val: "+pair.getValue());

		}

	}

}
