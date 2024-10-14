package Stacks;

import java.util.EmptyStackException;

public interface StackInterface<T> {
    /** Adds a new entry to the top of this stack.
     @param newEntry  An object to be added to the stack. */
    public void push(T newEntry);

    /** Removes and returns this stack's top entry.
     @return  The object at the top of the stack.
     @throws EmptyStackException if the stack is empty before the operation. */
    public T pop();

    /** Retrieves this stack's top entry.
     @return  The object at the top of the stack.
     @throws  EmptyStackException if the stack is empty. */
    public T peek();

    /** Detects whether this stack is empty.
     @return  True if the stack is empty. */
    public boolean isEmpty();

    /** Removes all entries from this stack. */
    public void clear();

    public void display();


/*
All my changes Start here
 */
     /** Removes the minimum value from the presented Array.
     @return The lowest value
     */
    public Integer removeMin();

    /**
     * "accepts a stack of integers and checks if the
     * elements in the stack occur in ascending
     * (non-decreasing) order from top to bottom"
     @retrun true if the elements in the stack
     occur in ascending (non-decreasing) order from top to bottom
     */
    public boolean isSorted();
}
