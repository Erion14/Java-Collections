package generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyListParameterized<T> implements MyListParameterized<T>, ListIterableParameterized<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;

	@Override
	public void add(T element) {
		final Node<T> lastNode = last;
		final Node<T> newNode = new Node<>(lastNode, element, null);
		last = newNode;
		if (lastNode == null) {
			first = newNode;
		} else {
			lastNode.next = newNode;
		}
		size++;
	}

	@Override
	public void clear() {
		for (Node<T> x = first; x != null; ) {
			Node<T> next = x.next;
			x.data = null;
			x.next = null;
			x.previous = null;
			x = next;
		}
		last = null;
		first = null;
		size = 0;
	}

	@Override
	public boolean remove(Object obj) {
		if (obj == null) {
			for (Node<T> x = first; x != null; x = x.next) {
				if (x.data == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node<T> x = first; x != null; x = x.next) {
				if (x.data.equals(obj)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}

	public Object removeNodeByIndex(int index) {
		return unlink(getNodeByIndex(index));
	}

	Object unlink(Node<T> element) {
		Object obj = element.data;
		Node<T> next = element.next;
		Node<T> previous = element.previous;

		if (previous == null) {
			first = next;
		} else {
			previous.next = next;
			element.previous = null;
		}
		if (next == null) {
			last = previous;
		} else {
			next.previous = previous;
			element.next = null;
		}

		element.data = null;
		size--;
		return obj;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		int index = 0;
		for (Node<T> x = first; x != null; x = x.next) {
			result[index++] = x.data;
		}
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			for (Node<T> x = first; x != null; x = x.next) {
				if (x.data == null) {
					return true;
				}
			}
		} else {
			for (Node<T> x = first; x != null; x = x.next) {
				if (x.data.equals(o)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean containsAll(MyListParameterized<?> c) {
		Object[] array = c.toArray();
		for (int i = 0; i < array.length; i++) {
			if (!contains(array[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		if (first == null) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		sb.append('{');

		for (Node<T> x = first; x != null; x = x.next) {
			sb.append('[')
			  .append(x.data);

			if (x.next == null) {
				break;
			}
			sb.append(']')
			  .append(',')
			  .append(' ');
		}

		return sb.append(']')
				 .append('}')
				 .toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratorImpl<>();
	}

	public Node<T> getNodeByIndex(int index) {
		if (index > (size - 1)) {
			return null;
		}

		if (index < (size >> 1)) {
			Node<T> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node<T> x = last;
			for (int i = size - 1; i > index; i--) {
				x = x.previous;
			}
			return x;
		}
	}

	@Override
	public ListIteratorParameterized<T> listIterator() {
		return new ListIteratorImplParameterized<>();
	}

	private class ListIteratorImplParameterized<T> extends IteratorImpl<T> implements ListIteratorParameterized<T> {

		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public T previous() {
			cursor -= 1;
			Node<T> previous = (Node<T>) getNodeByIndex(cursor);
			if (previous == null) {
				cursor = 0;
				throw new NoSuchElementException();
			}
			lastRet = cursor;
			return previous.data;
		}

		@Override
		public void set(T element) {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			Node<T> x = (Node<T>) getNodeByIndex(lastRet);
			x.data = element;
			lastRet = -1;
		}

	}

	private class IteratorImpl<T> implements Iterator<T> {

		int cursor = 0;
		int lastRet = -1;

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public T next() {
			Node<T> next = (Node<T>) getNodeByIndex(cursor);
			if (next == null) {
				throw new NoSuchElementException();
			}
			lastRet = cursor;
			cursor += 1;
			return next.data;
		}

		@Override
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			DefaultMyListParameterized.this.removeNodeByIndex(lastRet);
			if (lastRet < cursor) {
				cursor--;
			}
			lastRet = -1;
		}

	}

	private static class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> previous;

		public Node(Node<T> previous, T data, Node<T> next) {
			this.next = next;
			this.previous = previous;
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}
}
