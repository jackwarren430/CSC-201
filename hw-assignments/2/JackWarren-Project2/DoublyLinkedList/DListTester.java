public class DListTester {
	public static void main(String[] args) {

		System.out.println("Testing append");
		System.out.println("---------------------");
		DLinkedList list = new DLinkedList();
		System.out.println(list);
		list.append("hello");
		System.out.println(list);
		list.append("world");
		System.out.println(list);
		System.out.println("---------------------");
		System.out.println("testing clear");
		list.clear();
		System.out.println("list: " + list);
		System.out.println("---------------------");
		System.out.println("testing get");
		list.append("hello");
		list.append("world");
		list.append("japan");
		System.out.println("list: " + list);
		System.out.println("get index 1: " + list.get(1));
		System.out.println("index 3: " + list.get(3));
		System.out.println("---------------------");
		System.out.println("Testing remove");
		System.out.println("List: " + list);
		System.out.println("removing index 0");
		list.remove(0);
		System.out.println("list: " + list);
		System.out.println("removing index 1");
		list.remove(1);
		System.out.println("list: " + list);
		System.out.println("removing index 0");
		list.remove(0);
		System.out.println("list: " + list);
		System.out.println("removing index 0 again");
		list.remove(0);
		System.out.println("---------------------");
		System.out.println("Testing insert");
		System.out.println("inserting 1 into empty list");
		list.insert(0, 1);
		System.out.println("list: " + list);
		System.out.println("inserting various items");
		list.insert(1, 2);
		//System.out.println("list: " + list);
		list.insert(1, 3);
		//System.out.println("list: " + list);
		list.insert(0, 4);
		System.out.println("list: " + list);
		System.out.println("---------------------");
		System.out.println("Testing replace");
		System.out.println("replacing 4 at index 0 with 5");
		list.replace(0, 5);
		System.out.println("list: " + list);
		System.out.println("replacing 3 at index 2 with 5");
		list.replace(2, 5);
		System.out.println("list: " + list);
	}
}