public class Main{
    public static void main(String[] args) {
//        Stack<Integer> integerStack = new LinkedStack<Integer>();
        //Stack<String> stringStack = new LinkedStack<String>();
//        integerStack.push(2);
//        integerStack.push(5);
//        integerStack.push(4);
//        integerStack.push(7);
//
//        Stack<Integer> sortedIntegerStack = sortIntegerStackUsingAStack(integerStack);
//        while(!sortedIntegerStack.isEmpty()){
//            System.out.println(sortedIntegerStack.pop());
//        }

        Rectangle rectangle1 = new Rectangle(1,2,3,4);
        Rectangle rectangle2 = new Rectangle(0,1,3,6);
        //return this.x < rectangle.x;

        System.out.println(rectangle1.isLeftOf(rectangle2));


        Circle circle1 = new Circle(1,2,3);
        Circle circle2 = new Circle(2,2,3);
        //return this.x < circle.x;

        System.out.println(circle1.isLeftOf(circle2));

        System.out.println(rectangle1.isLeftOf(circle2));

        Square square = new Square(3,5);

        System.out.println(square.isLeftOf(circle2));

        Shape s;
        Rectangle r;
        s = new Shape();
        r = new Rectangle(1,2,3,4);

        //r = s;



    }

    public static Stack<Integer> sortIntegerStackUsingAStack(Stack<Integer> stack){

        // 7 , 4 , 5 , 2 =>
        // 7 , 5 , 4 , 2

        Stack<Integer> tmpStack = new LinkedStack<>();
        while(!stack.isEmpty())
        {
            // pop out the first element
            int tmp = stack.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek()
                    > tmp)
            {
                // pop from temporary stack and
                // push it to the input stack
                stack.push(tmpStack.pop());
            }

            // push temp in tempory of stack
            tmpStack.push(tmp);
        }
        return tmpStack;


    }
}