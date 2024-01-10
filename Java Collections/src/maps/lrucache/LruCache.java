package maps.lrucache;

public interface LruCache {
	
	/*
	 * return the value of the key
	 */
	
	
	int get(int key);
	
	/**
	 * Update the value of the key if it exists
	 * @param key
	 * @param value
	 */
	
	void put(int key, int value);
	
/**
 * Capacity
 * @param  set capacity of cache
 */
	void setCapacity(int capacity);

}
