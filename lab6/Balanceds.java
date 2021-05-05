
public class Balanceds {

    public static boolean isBalanced(final String s) {
        final ArrayStack<Character> stack = new ArrayStack<Character>(
                s.length());
        for (final char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty()) {
                    final char ch = stack.pop();
                    if ((ch == '(' && c == ')') || (ch == '{' && c == '}')
                            || (ch == '{' && c == '}')) {
                        continue;
                    }
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(final String[] args) {
        final String test = "(({}))";
        System.out.println("The string " + test + " is balanced: "
                + Balanceds.isBalanced(test));
    }
}