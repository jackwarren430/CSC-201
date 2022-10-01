public class AList implements MyList {
	private static final int DEFAULT_SIZE = 10;
	private Object[] arr = new Object[10];
	private int length = 0;

	public void clear(){
		arr = new Object[10];
		length = 0;
	}

	public void append(Object e){
		if (length > arr.length){
			extendArr();
		}
		arr[length] = e;
		length++;
	}

	public Object remove(int pos){
		if (length <= 0){
			return null;
		}
		Object hold = arr[pos];
		for (int i = pos; i < length - 1; i++){
			arr[i] = arr[i + 1];
		}
		arr[length - 1] = null;
		length--;
		return hold;
	}

	public void insert(Object e, int pos){
		if (pos > length || pos < 0){
			return;
		}
		if (length > arr.length){
			extendArr();
		}
		Object hold = arr[length - 1];
		for(int i = length - 2; i > pos; i--){
			arr[i] = arr[i + 1];
		}
		arr[pos] = e;
		length++;
	}

	public int length(){
		return length;
	}

	public boolean isEmpty(){
		return length == 0;
	}

	private void extendArr(){
		Object[] newArr = new Object[length * 2];
		for (int i = 0; i < length; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public String toString(){
		String toReturn = "";
		for(int i = 0; i < length; i++){
			toReturn += arr[i] + ", ";
		}
		return toReturn;
	}
}