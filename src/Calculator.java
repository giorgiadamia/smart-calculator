import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    public static BigInteger calculate(ArrayList<String> postfixExpression) {
        Stack<BigInteger> stack = new Stack<>();
        final String regexSign = "[+\\-*/]";
        for (String incomingElement : postfixExpression) {
            if (incomingElement.matches("[0-9]+|-[0-9]+")) {
                BigInteger tempVal = new BigInteger(incomingElement);
                stack.push(tempVal);
            }
            if (incomingElement.matches(regexSign)) {
                BigInteger secondNumber = stack.pop();
                BigInteger firstNumber = stack.pop();
                if (incomingElement.equals("+"))
                    stack.push(sum(firstNumber, secondNumber));
                if (incomingElement.equals("-"))
                    stack.push(subtract(firstNumber, secondNumber));
                if (incomingElement.equals("*"))
                    stack.push(multiply(firstNumber, secondNumber));
                if (incomingElement.equals("/"))
                    stack.push(divide(firstNumber, secondNumber));
            }
        }
        return stack.pop();
    }

    private static BigInteger sum(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.add(secondNumber);
    }

    private static BigInteger multiply(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.multiply(secondNumber);
    }

    private static BigInteger subtract(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.subtract(secondNumber);
    }

    private static BigInteger divide(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.divide(secondNumber);
    }

}