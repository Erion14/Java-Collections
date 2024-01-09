package maps;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "two");
		map.put(1, "one");
		map.put(3, "three");
		map.put(4, null);

		
		System.out.println("Get element from map - get(1): " + map.get(1));

		
		System.out.println("Iterating over map keys demo: ");
		for (Integer key : map.keySet()) {
			System.out.println(key);
		}

		
		System.out.println("Iterating over map entries demo: ");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Entry key: " + entry.getKey() + "\t" + "Entry value: "
					+ entry.getValue());
		}

		
		System.out.println(
				"getOrDefault method demo with key 4: " + map.getOrDefault(4, "default"));
		System.out.println(
				"getOrDefault method demo with key 5: " + map.getOrDefault(5, "default"));

	
		map.putIfAbsent(4, "four");
		System.out
				.println("After putIfAbsent method was called for key 4: " + map.get(4));

}
}