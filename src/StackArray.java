
public class StackArray <E> implements Stack<E>{
	
	private Object[] array; // Cannot have generic arrays in java
	private int top;
	
	public StackArray(){
		array = new Object[2];
		top=0;
	}

	@Override
	public E pop() {
		if(top < 1){
//			throw new IndexOutOfBoundsException();
			return null;
		}
		E element = (E)array[top];
		array[top] = null;
		top--;
		return element;
	}

	@Override
	public void push(E e) {
		if(top >= array.length -1){
			resize();
		}
		top++;
		array[top] = e;
	}
	
	private void resize(){
		Object[] oldArr = array;
		array = new Object[array.length * 2];
		for(int i = 0; i < oldArr.length; i++){
			array[i] = oldArr[i];
		}
	}
}
