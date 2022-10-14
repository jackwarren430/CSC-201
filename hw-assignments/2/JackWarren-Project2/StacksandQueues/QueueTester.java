public class QueueTester {
	public static void main(String[] args) {
		WeirdQueue q = new WeirdQueue();
		System.out.println("Beginning WeirdQueue test\nadding items");
		q.dequeue();
		q.enqueue("sausage");
		q.enqueue("hotdog");
		q.enqueue("borstick");
		System.out.println("queue: " + q);
		System.out.println("popping everything");
		q.dequeue();
		System.out.println("list: " + q);
		q.dequeue();
		System.out.println("list: " + q);
		q.dequeue();
		System.out.println("list: " + q);
	}
}