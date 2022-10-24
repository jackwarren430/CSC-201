import java.util.Stack;

public class WeirdQueue{

    //  3 instance variables
    //      the stack that is used for enqueues
    //      the stack that is used for dequeues
    //      size variable
    private Stack<Object> normal_stack;
    private Stack<Object> inverse_stack;
    private int size;
    
    //  initialization
    public WeirdQueue(){
        size = 0;
        normal_stack = new Stack<Object>();
        inverse_stack = new Stack<Object>();
    }

    //  running time is always O(1)
    //      just pushes to enqueue stack
    //  there really aren't any possible errors for this method
    public void enqueue(Object item){
        normal_stack.push(item);
        size++;
    }

    
    //  running time is always O(n) - n is number of elements in stack
    //      for this method I flip the stack upside down by pushing each "pop"
    //      from the enqueue stack to the dequeue stack, then pop the top element.
    //  the only error that could occur is if the stack is empty
    public Object dequeue(){
        if (size == 0){
            //  accounting for if stack is empty
            System.out.println("ERROR: cannot pop stack because it's empty");
            return null;
        }
        //  flips stack to inverse stack
        for (int i = 0; i < size; i++){
            inverse_stack.push(normal_stack.pop());
        }
        //  pops top element
        Object hold = inverse_stack.pop();
        size--;
        //  adds elements back to first stack
        for (int i = 0; i < size; i++){
            normal_stack.push(inverse_stack.pop());
        }
        return hold;
    }

    //  made a toString in order to test
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < size; i++){
            inverse_stack.push(normal_stack.pop());
        }
        for (int i = 0; i < size; i++){
            Object hold = inverse_stack.pop();
            toReturn += hold + ", ";
            normal_stack.push(hold);
        }
        return toReturn;
    }
}