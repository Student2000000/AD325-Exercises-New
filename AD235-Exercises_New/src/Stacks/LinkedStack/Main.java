package Stacks.LinkedStack;
import Week2.StackInterface;

public class Main {
    public static void main(String[] args) {
        testStackOperations();
        System.out.println("\n\nDone.");
    }  // end main

    public static void testStackOperations() {
        System.out.println("Create a stack: ");
        StackInterface<String> myStack = new LinkedStack<>();
        System.out.println("isEmpty() returns " + myStack.isEmpty());

        System.out.println("\nAdd to stack to get\n" +
                "Joe Jane Jill Jess Jim");
        myStack.push("Jim");
        myStack.push("Jess");
        myStack.push("Jill");
        myStack.push("Jane");
        myStack.push("Joe");

        myStack.display();

        System.out.println("\nisEmpty() returns " + myStack.isEmpty());

        System.out.println("\nTesting peek and pop:");
        while (!myStack.isEmpty()) {
            String top = myStack.peek();
            System.out.println("\n" + top + " is at the top of the stack.");

            top = myStack.pop();
            System.out.println(top + " is removed from the stack.");
        } // end while

        System.out.print("\nThe stack should be empty: ");
        System.out.println("isEmpty() returns " + myStack.isEmpty());

        System.out.println("\nAdd to stack to get\n" +
                "Jim Jess Joe\n");
        myStack.push("Joe");
        myStack.push("Jess");
        myStack.push("Jim");

        System.out.println("\nTesting clear:");
        myStack.clear();

        System.out.println("The stack should be empty: ");
        System.out.println("\nisEmpty() returns " + myStack.isEmpty());

        System.out.println("\n myStack.peek() returns ");
        System.out.println(myStack.peek());
        System.out.println("\n myStack.pop()  returns ");
        System.out.println(myStack.pop());
    }
}
