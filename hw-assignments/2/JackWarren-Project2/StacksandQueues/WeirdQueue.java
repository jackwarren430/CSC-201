import java.util.Stack;

public class WeirdQueue{

    private Stack<Object> normal_stack;
    private Stack<Object> inverse_stack;
    private int size;
    
    public WeirdQueue(){
        size = 0;
        normal_stack = new Stack<Object>();
        inverse_stack = new Stack<Object>();
    }

    public void enqueue(Object item){
        normal_stack.push(item);
        size++;
    }

    public Object dequeue(){
        if (size == 0){
            System.out.println("ERROR: cannot pop stack because it's empty");
            return null;
        }
        for (int i = 0; i < size; i++){
            inverse_stack.push(normal_stack.pop());
        }
        Object hold = inverse_stack.pop();
        size--;
        for (int i = 0; i < size; i++){
            normal_stack.push(inverse_stack.pop());
        }
        return hold;
    }

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