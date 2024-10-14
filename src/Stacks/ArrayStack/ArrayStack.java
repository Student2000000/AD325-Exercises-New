package Stacks.ArrayStack;

import Stacks.StackInterface;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
 A class of stacks whose entries are stored in an array.
 @author Frank M. Carrano and Timothy M. Henry
 @version 5.1
 */
public final class ArrayStack<T> implements StackInterface<T> {

    private T[] stack;    // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor

    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty

    public void clear()
    {
        checkIntegrity();

        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        } // end while
        //	Assertion: topIndex is -1
    } // end clear

    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException ("ArrayStack object is corrupt.");
    } // end checkIntegrity

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    } // end checkCapacity

    // Doubles the size of the array stack if it is full
    // Precondition: checkIntegrity has been called.
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity

    public void display () {           //print the stack elements
        for(int i = topIndex; i>=0;i--) {
            System.out.print(stack[i] + " ");
        }
    }
/*
All Changes 10/12 start here
StackInterface<String> myStack = new ArrayStack<>();
 */

    public Integer removeMin() {
        if (isEmpty()) {
            return null;
        }

        StackInterface<Integer> storage_Stack = new ArrayStack<>();
        int min_val = 10000000;

        while (!isEmpty()) {
            Integer current_data = (Integer) pop();
            if (current_data < min_val) {
                min_val = current_data;
            }
            storage_Stack.push(current_data);
        }

        while (!storage_Stack.isEmpty()) {
            Integer storage_Data = storage_Stack.pop();
            push((T) storage_Data);

        }
        return min_val;
    }
/*
All Changes 10/13 start here
StackInterface<String> myStack = new ArrayStack<>();
 */

   public int getTopIndex(){
        return topIndex;
   }

    public boolean isSorted() {


        if (isEmpty() || topIndex == 0) {
            return true;
        }

        StackInterface<T> storage_Stack = new ArrayStack<>();
        boolean isSorted = true;

        T prev_Val = pop();
        storage_Stack.push(prev_Val);


        while (!isEmpty()) {
            T current_data = pop();

            if ((Integer) current_data < (Integer) prev_Val) {
                isSorted = false;
            }

            storage_Stack.push(current_data);
            prev_Val = current_data;

        }

        while (!storage_Stack.isEmpty()) {
            push(storage_Stack.pop());
        }

        return isSorted;
    }



} // end ArrayStack

