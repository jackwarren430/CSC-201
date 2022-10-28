public class myIntHT {
	
	private Integer[] hashtable;

	public myIntHT(int size){
		hashtable = new Integer[size];
	}

	public Integer find(Integer val){
		int index = hashCode(val);
		if (hashtable[index] == null) { return null; }
		return hashtable[index];
	}

	public void delete(Integer val){
		hashtable[hashCode(val)] = null;
	}

	public void insert(Integer val){
		int index = hashCode(val);
		while (hashtable[index] == null){
			if (index >= hashtable.length - 1){
				index = 0;
			} else {
				index++;
			}
		}
		hashtable[index] = val;
	}

	private int hashCode(Integer val){
		return val % hashtable.length;
	}

}