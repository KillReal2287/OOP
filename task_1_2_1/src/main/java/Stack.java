import java.util.Arrays;

public class Stack<Type>{

    private int count = 0;
    private int max_len = 0;
    private Type[] stack = (Type[]) new Object[0];
    /**
     * returns number of elements in stack
     * @return - returns how many elements in stack right now
     */
    public int count(){
        return count;
    }
    /**
     * push one element "Type" to stack
     * @param element - item
     */
    public void push(Type element){
        if (count == max_len){
            max_len = max_len * 2 + 1;
            stack = Arrays.copyOf(stack, max_len);
        }
        stack[count] = element;
        count += 1;
    }

    /**
     * push array of elements "Type" to stack
     * @param element - array with items
     */
    public void pushStack(Stack<Type> element){

        int res = element.count();
        max_len += res*2;
        count += res;
        stack = Arrays.copyOf(stack, max_len);

        for (int i = 0; i < res; i++)
            stack[count - i - 1] = element.pop();
    }

    /**
     * delete one element from stack
     */
    public Type pop(){
        if (count == 0)
            throw new IndexOutOfBoundsException("stack is empty");
        else{
            count -= 1;
            return stack[count];
        }
    }

    /**
     * delete items from stack
     * @param number - how many items we should delete
     */
    public Stack<Type> popStack(int number){
        Stack<Type> answer = new Stack<>();
        if (count - number < 0){
            if (count == 0)
                throw new IndexOutOfBoundsException("stack is empty");
            else
                throw new IndexOutOfBoundsException("there are not so many elements on the stack");
        }
        else{
            for (int i = 0; i < number; i++)
                answer.push(stack[count - number + i]);
            count -= number;
        }
        return answer;
    }

    /**
     * write current stack
     */
    public void write(){
        for (int i = 0; i < count; i++)
            System.out.println(stack[i]);
        System.out.println();
    }
}