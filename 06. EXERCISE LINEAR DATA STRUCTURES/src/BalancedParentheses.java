import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("");
        ArrayDeque<String> stack = new ArrayDeque<>();

        if (input.length % 2 == 1)
        {
            System.out.println("NO");
            return;
        }

        for (String symbol : input)
        {
            switch (symbol)
            {
                case "(":
                case "{":
                case "[":
                    stack.push(symbol);
                    break;
                default:
                    if ((symbol.equals(")") || symbol.equals("}") || symbol.equals("]")) && stack.size() > 0)
                    {
                        if (stack.peek().equals("(") && symbol.equals(")") || stack.peek().equals("[") && symbol.equals("]") || stack.peek().equals("{") && symbol.equals("}"))
                        {
                            stack.pop();
                        }
                        else
                        {
                            System.out.println("NO");
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("NO");
                        return;
                    }
                    break;
            }
        }
        System.out.println("YES");
    }
}
