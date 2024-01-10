package maps.lrucache;

import java.util.LinkedHashMap;

public class DefaultLruCache extends LinkedHashMap<Integer, Integer> implements LruCache {

	private int capacity;
	
	public DefaultLruCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity=capacity;
	}
	
	
	@Override
	public int get(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void put(int key, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCapacity(int capacity) {
		// TODO Auto-generated method stub
		
	}

}
