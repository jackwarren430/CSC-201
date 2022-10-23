import java.util.Stack;

public class SortTester {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		// stack.push(5);
		// stack.push(7);
		// stack.push(2);
		// stack.push(6);
		// stack.push(1);

		// while (!stack.empty()){
		// 	System.out.print(stack.pop() + ", ");
		// }

		stack.push(5);
		stack.push(7);
		stack.push(2);
		
		stack = StackSorting.sort(stack);

		System.out.println("\n");
		while (!stack.empty()){
			System.out.print(stack.pop() + ", ");
		}
	}
}