import java.util.Stack;

public class PostFixSolver {

    static public int solve(String expression){
        // 7 3 2 - -
        // 9 3 / 10 2 3 ∗ − +
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < expression.length(); i++){

            char c = expression.charAt(i);
            //System.out.println(c);
            if(c == ' '){
                continue;
            } else if(Character.isDigit(c)){
                // 452 + -
                int n = 0;

                while (Character.isDigit(c)){
                    n = n*10 + (c - '0');
                    i++;
                    c = expression.charAt(i);
                }
                i--;
                stack.push(n);
            } else {
                int right = stack.pop();
                int left = stack.pop();

//                switch (c){
//                    case '+':
//                        stack.push(right+left);
//                        break;
//                    case '-':
//                        stack.push(right-left);
//                        break;
//                    case '*':
//                        stack.push(right*left);
//                        break;
//                    case '/':
//                        stack.push(right/left);
//                        break;
//                }

                if(c == '+'){
                    stack.push(left + right);
                } else if (c == '-'){
                    stack.push(left - right);
                } else if (c == '*'){
                    stack.push(left * right);
                } else if (c == '/'){
                    stack.push(left / right);
                }
            }

            //System.out.println(stack.peek());
        }

        result = stack.pop();
        return result;
    }

}
