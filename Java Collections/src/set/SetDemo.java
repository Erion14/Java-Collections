package set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		System.out.println("Add 1: " + set.add(1));
		System.out.println("Add 1: " + set.add(1));
		System.out.println("Add 2: " + set.add(2));
		System.out.println("Add 3: " + set.add(3));
		System.out.println(set);
		
	}
}
