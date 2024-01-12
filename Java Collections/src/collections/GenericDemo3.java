package collections;

public class GenericDemo3<T> {
	private T t;
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}

	
	public static void main(String[] args) {
		GenericDemo3<Integer> integerBox = new GenericDemo3<>();
		GenericDemo3<String> stringBox = new GenericDemo3<>();
		
		integerBox.set(10);
		stringBox.set("Hello World");
		
		Integer integer = integerBox.get();
		String string = stringBox.get();
		
		System.out.println("Integer Value :" + integer);
		System.out.println("String Value: "+ string);
	}
}
