import java.util.Stack;

public class SortTester {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(7);
		stack.push(2);
		stack.push(6);
		stack.push(1);

		stack = StackSorting.sort(stack);

		while (!stack.empty()){
			System.out.print(stack.pop() + ", ");
		}
	}
}