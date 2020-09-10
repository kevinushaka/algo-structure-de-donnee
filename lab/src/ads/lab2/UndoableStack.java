package ads.lab2;

public class UndoableStack<AnyType> {
    private static final String pushAction = "push";
    private static final String popAction = "pop";

    private ArrayStack<AnyType> stack;
    private ArrayStack<AnyType> popStack;
    private ArrayStack<String> actionStack;

    // Build an undoable stack
    public UndoableStack() {
        stack = new ArrayStack<AnyType>();
        popStack = new ArrayStack<AnyType>();
        actionStack = new ArrayStack<String>();
    }
    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    // Return the next value to be popped from the stack
    public AnyType peek() throws EmptyStackException {
        return stack.peek();
    }
    // Push the value x onto the stack.
    public void push(AnyType x) {
        actionStack.push("push");
         stack.push(x);
    }
    // Pop the stack and return the value popped
    public AnyType pop() throws EmptyStackException {
        // TO COMPLETE
        actionStack.push("pop");
        AnyType data=stack.pop();
        popStack.push(data);
        return data;
    }
    // Undo the last effective 'push' or 'pop'
    public void undo() throws EmptyStackException {
        // TO COMPLETE
        if(actionStack.isEmpty())
            return;
        if(actionStack.peek().equals("push")){
            stack.pop();
        }
        if(actionStack.peek().equals("pop")){
            stack.push(popStack.pop());
        }
    }

    public String toString() {
        return stack.toString();
    }
}

