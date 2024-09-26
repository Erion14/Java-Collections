package generics;

public interface MyListParameterized<T> extends Iterable<T> {

	void add(T e);
	
	
	void clear();
	
	boolean remove(Object o);
	
	Object[] toArray();	
	
	int size();
	
	boolean contains(Object o);
	
	
	boolean containsAll(MyListParameterized<?> c);
	
}
