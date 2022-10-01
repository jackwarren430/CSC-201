public class AListTester {
	public static void main(String[] args) {
		AList list = new AList();

		list.append("hello");
		System.out.println(list);
		list.insert("blah", 1);
		System.out.println(list);
		list.insert("first", 0);
		System.out.println(list.length());
		System.out.println(list);
		list.remove(0);

		System.out.println(list);

	}
}