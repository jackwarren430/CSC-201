import java.util.Stack;
public class StackSorting{

    //  static method takes in a stack and returns the sorted version
    public static Stack<Integer> sort(Stack<Integer> s){
        //implement this function.
       
        //  instance variables
        //      second stack to help sort
        //      hold var to eneble comparisons
        //      bool var to check if the stack is sorted
        Stack<Integer> s2 = new Stack<Integer>();
        Integer hold = null;
        Boolean check = true;

        //  continues the sort until stack is sorted
        //      the sorting method is essentially bubble sort
        while (check){
            check = false;
            //  takes top element as hold and compares it to next element
            while (!s.empty()) {
                //  if hold is null then pop the first stack
                hold = hold == null ? s.pop() : hold;
                if (s.empty()){
                    //  no comparison made - adds to second stack
                    s2.push(hold);
                    hold = null;
                } else if (s.peek() > hold){
                    //  hold is less than next element
                    s2.push(s.pop());
                } else {
                    //  hold is greater than next element
                    s2.push(hold);
                    hold = null;
                }
            }
            if (hold != null){
                //  special case if the last element added to s2 was not hold
                s2.push(hold);
                hold = null;
            }
            //  adds elements back to first stack while checking to see if it's sorted
            while (!s2.empty()) {
                hold = s2.pop();
                if (!s2.empty() && hold > s2.peek()){
                    check = true;

                }
                s.push(hold);
            }
            hold = null;

        }

        return s;
    }
}