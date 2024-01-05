package firstweek;


import java.util.Arrays;

public class DefaultMyList implements MyList {
	
	 private Object[] elements;
	    private int size;

	    public DefaultMyList() {
	        elements = new Object[10]; // Initial capacity
	        size = 0;
	    }
	@Override
	public void add(Object e) {
		ensureCapacity();
        elements[size++] = e;
		
	}

	private void ensureCapacity() {
		if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
		
	
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
		
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
            if (o == null ? elements[i] == null : o.equals(elements[i])) {
                removeElementAtIndex(i);
                return true;
            }
        }
        return false;
	}

	private void removeElementAtIndex(int index) {
	    System.arraycopy(elements, index + 1, elements, index, size - index - 1);
	    elements[--size] = null;  // Set the last element to null and decrement size
	}
		
	
	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elements, size);
	
	}

	@Override
	public int size() {
		 return size;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size; i++) {
            if (o == null ? elements[i] == null : o.equals(elements[i])) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean containsAll(MyList c) {
		for (Object element : c.toArray()) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
	}
	
	

}
