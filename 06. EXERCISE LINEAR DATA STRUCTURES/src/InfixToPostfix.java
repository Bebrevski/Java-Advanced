import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String symbol : sequence) {
            if (Character.isDigit(symbol.charAt(0)) || Character.isLetter(symbol.charAt(0))) {
                queue.offer(symbol);
            } else {
                if (stack.isEmpty()) {
                    stack.push(symbol);
                } else {
                    String lastOperator = stack.peek();
                    switch (symbol) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                stack.push(symbol);
                            } else {
                                queue.offer(stack.pop());
                                stack.push(symbol);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                queue.offer(stack.pop());
                                stack.push(symbol);
                            } else {
                                stack.push(symbol);
                            }
                            break;
                        case "(":
                            stack.push(symbol);
                            break;
                        case ")":
                            while (!stack.peek().equals("(")) {
                                queue.offer(stack.pop());
                            }
                            stack.pop();
                            break;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
