import java.util.Stack;
public class StackSorting{
    public static Stack<Integer> sort(Stack<Integer> s){
        //implement this function.
        Stack<Integer> s2 = new Stack<Integer>();
        Integer hold = null;
        Boolean check = true;

        while (check){
            check = false;
            while (!s.empty()) {
                hold = s.pop();
                if (s.empty()){
                    s2.push(hold);
                } else if (s.peek() > hold){
                    s2.push(s.pop());
                } else {
                    s2.push(hold);
                }
            }
            while (!s2.empty()) {
                hold = s2.pop();
                if (!s2.empty() && hold > s2.peek()){
                    check = true;
                }
                s.push(hold);
            }

        }

        return s;
    }
}