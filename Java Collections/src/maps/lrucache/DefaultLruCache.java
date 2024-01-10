package maps.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultLruCache extends LinkedHashMap<Integer, Integer> implements LruCache {

	private int capacity;
	
	public DefaultLruCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity=capacity;
	}
	
	
	@Override
	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	@Override
	public void put(int key, int value) {
		super.put(key, value);
		
	}
	public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
		
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity=capacity;
		
	}
	
	public static void main(String[] args) {
		DefaultLruCache lruCache = new DefaultLruCache(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		// cache is {1=1, 2=2, 3=3}
		System.out.println("Cache: " + lruCache);
		
		// Get Method
		System.out.println("Get value for key 2: " + lruCache.get(2));
		
		System.out.println("Cache after get(2): " + lruCache);

		//Put method to exceed the capacity of the Cache and to trigger the eviction
		lruCache.put(4, 4);
		
		// Cache after the eviction
		System.out.println("Cache after exceeding capacity: " + lruCache);
		
		//Returning -1 when the key doesn't exist
		System.out.println("Get Value for key 1 after eviction: " + lruCache.get(1));
		
		//Testing for removing the least used 
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(4));
		lruCache.put(5, 5); // Now 3 should be removed from cache
		System.out.println(lruCache); // return {2=2, 4=4, 5=5}
	}

}
