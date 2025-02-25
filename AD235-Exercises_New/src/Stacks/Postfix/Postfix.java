package Stacks.Postfix;


import Week2.StackInterface;
import Week2.Stacks.LinkedStack.LinkedStack;

public class Postfix
{
    /** Creates a postfix expression that represents a given infix expression.
     Segment 5.16.
     @param infix  A string that is a valid infix expression.
     @return  A string that is the postfix expression equivalent to infix. */
    public static String convertToPostfix(String infix)
    {
        StackInterface<Character> operatorStack = new LinkedStack<>();
        StringBuilder postfix = new StringBuilder();
        int characterCount = infix.length();
        char topOperator;

        for (int index = 0; index < characterCount; index++)
        {
            boolean done = false;
            char nextCharacter = infix.charAt(index);

            if (isVariable(nextCharacter))
                postfix = postfix.append(nextCharacter);
            else
            {
                switch (nextCharacter)
                {
                    case '^':
                        operatorStack.push(nextCharacter);
                        break;

                    case '+': case '-': case '*': case '/':
                    while (!done && !operatorStack.isEmpty())
                    {
                        topOperator = operatorStack.peek();

                        if (getPrecedence(nextCharacter) <= getPrecedence(topOperator))
                        {
                            postfix = postfix.append(topOperator);
                            operatorStack.pop();
                        }
                        else
                            done = true;
                    } // end while

                    operatorStack.push(nextCharacter);
                    break;

                    case '(':
                        operatorStack.push(nextCharacter);
                        break;

                    case ')': // Stack is not empty if infix expression is valid
                        topOperator = operatorStack.pop();
                        while (topOperator != '(')
                        {
                            postfix = postfix.append(topOperator);
                            topOperator = operatorStack.pop();
                        } // end while
                        break;

                    default: break; // Ignore unexpected characters
                } // end switch
            } // end if
        } // end for

        while (!operatorStack.isEmpty())
        {
            topOperator = operatorStack.pop();
            postfix = postfix.append(topOperator);
        } // end while

        return postfix.toString();
    } // end convertToPostfix

    // Indicates the precedence of a given operator.
    // Precondition: operator is a character that is (, ), +, -, *, /, or ^.
    // Returns an integer that indicates the precedence of operator:
    //         0 if ( or ), 1 if + or -, 2 if * or /, 3 if ^,
    //         -1 if anything else. */
    private static int getPrecedence(char operator)
    {
        switch (operator)
        {
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^':           return 3;
        } // end switch

        return -1;
    } // end getPrecedence

    private static boolean isVariable(char character)
    {
        return Character.isLetter(character);
    } // end isVariable

    /** Evaluates a given postfix expression.
     Segment 5.18
     @param postfix  a string that is a valid postfix expression.
     @return  the value of the postfix expression. */
    public static double evaluatePostfix(String postfix)
    {
        StackInterface<Double> valueStack = new LinkedStack<>();
        int characterCount = postfix.length();

        for (int index = 0; index < characterCount; index++)
        {
            char nextCharacter = postfix.charAt(index);

            switch(nextCharacter)
            {
                case 'a': case 'b': case 'c': case 'd': case 'e':
                valueStack.push(valueOf(nextCharacter));
                break;

                case '+': case '-': case '*': case '/': case '^':
                Double operandTwo = valueStack.pop();
                Double operandOne = valueStack.pop();
                Double result = compute(operandOne, operandTwo, nextCharacter);
                valueStack.push(result);
                break;

                default: break; // Ignore unexpected characters
            } // end switch
        } // end for

        return (valueStack.peek()).doubleValue();
    } // end evaluatePostfix

    private static double valueOf(char variable)
    {
        switch (variable)
        {
            case 'a': return 2.0;
            case 'b': return 3.0;
            case 'c': return 4.0;
            case 'd': return 5.0;
            case 'e': return 6.0;
        } // end switch

        return 0; // Unexpected character
    } // end valueOf

    private static Double compute(Double operandOne, Double operandTwo, char operator)
    {
        double result;

        switch (operator)
        {
            case '+':
                result = operandOne.doubleValue() + operandTwo.doubleValue();
                break;

            case '-':
                result = operandOne.doubleValue() - operandTwo.doubleValue();
                break;

            case '*':
                result = operandOne.doubleValue() * operandTwo.doubleValue();
                break;

            case '/':
                result = operandOne.doubleValue() / operandTwo.doubleValue();
                break;

            case '^':
                result = Math.pow(operandOne.doubleValue(), operandTwo.doubleValue());
                break;

            default:    // Unexpected character
                result = 0;
                break;
        } // end switch

        return result;
    } // end compute
} // end Postfix
