import java.util.Arrays;

public class Stack<Type>{

    private int count = 0;
    private int max_len = 0;

    @SuppressWarnings("unchecked")
    private Type[] stack = (Type[]) new Object[0];

    /**
     * count - returns number of elements in stack
     * @return - returns how how many elements in stack right now
     */
    public int count(){
        return count;
    }

    /**
     * push one element type Type to stack
     * @param element - item
     */
    public void push(Type element){
        if (count == max_len){
            max_len = max_len * 2 + 1;
            stack = Arrays.copyOf(stack, max_len);
        }
        stack[count++] = element;
    }

    /**
     * push array of elements type Type to stack
     * @param element - array with items
     */
    public void pushStack(Type[] element){
        for (Type type : element) {
            if (count == max_len) {
                max_len = max_len * 2 + 1;
                stack = Arrays.copyOf(stack, max_len);
            }
            stack[count++] = type;
        }
    }

    /**
     * delete one element from stack
     */
    public void pop(){
        try {
            stack[count - 1] = stack[count - 1];
            count -= 1;
        }
        catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("stack empty");
        }
    }

    /**
     * popstack - delete items from stack
     * @param number - how many items we should delete
     */
    public void popStack(int number){
        try {
            stack[count - number] = stack[count - number];
            count -= number;
        }
        catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("there are not so many elements on the stack");
        }
    }

    /**
     * write stack
     */
    public void write(){
        for (int i = 0; i < count; i++)
            System.out.println(stack[i]);
        System.out.println();
    }
}
