package Stacks.Postfix;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Testing postfix expressions with\n" +
                "a = 2, b = 3, c = 4, d = 5, e = 6\n\n");

        testPostfix("a+b");
        testPostfix("(a + b) * c");
        testPostfix("a * b / (c - d)");
        testPostfix("a / b + (c - d)");
        testPostfix("a / b + c - d");
        testPostfix("a^b^c");
        testPostfix("(a^b)^c");
        testPostfix("a*(b/c+d)");

        System.out.println("Testing Question 6, Chapter 5:\n");
        testPostfix("(a+b)/(c-d)");         // Question 6a, Chapter 5
        testPostfix("a/(b-c)*d");           // Question 6b
        testPostfix("a-(b/(c-d)*e+f)^g");   // Question 6c
        testPostfix("(a-b*c)/(d*e^f*g+h)"); // Question 6d

        System.out.println("Testing Question 7, Chapter 5:\n");
        System.out.println("Q7a: ae+bd-/ : "   + Postfix.evaluatePostfix("ae+bd-/") + "\n");
        System.out.println("Q7b: abc*d*- : "   + Postfix.evaluatePostfix("abc*d*-") + "\n");
        System.out.println("Q7c: abc-/d* : "   + Postfix.evaluatePostfix("abc-/d*") + "\n");
        System.out.println("Q7d: ebca^*+d- : " + Postfix.evaluatePostfix("ebca^*+d-") + "\n");
        System.out.println("\n\nDone.");
    }  // end main

    public static void testPostfix(String infixExpression)
    {
        System.out.println("Infix:   " + infixExpression);
        String postfixExpression =  Postfix.convertToPostfix(infixExpression);
        System.out.println("Postfix: " + postfixExpression);
        System.out.println("\n");
    } // end testPostfix
}
