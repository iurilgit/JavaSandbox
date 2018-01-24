package stack;

/**
 * Created by ruili1 on 8/21/17.
 *
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 */

import java.util.Stack;

public class LC155_MinStack {

    class MinStack {

        Stack<Long> stack;
        long min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            min = Integer.MAX_VALUE;
            stack = new Stack<Long>();
        }

        public void push(int x) {

            if(stack.isEmpty()){
                stack.push((long)x);
                min = x;
                return;
            }

            if (x >= min){
                stack.push((long)x);
            }else{
                stack.push(2 * (long)x - min);
                min = x;
            }
        }

        public void pop() {

            if (stack.isEmpty()) {
                min = Integer.MIN_VALUE;
                return;
            }

            long x = stack.peek();
            if (x < min) {
                min = 2 * min - x;
            }
            stack.pop();

            if(stack.isEmpty()) {
                min = Integer.MIN_VALUE;
            }
        }

        public Integer top() {

            if (stack.isEmpty()) {
                min = Integer.MIN_VALUE;
                return null;
            }

            long x = stack.peek();
            if (x < min) {
                x = min;
                min = 2 * x - min;
            } else {
                x = stack.peek();
            }

            return (int)x;
        }

        public int getMin() {

            return (int)min;
        }
    }

    public static void main(String[] args){

//        int x = Integer.MIN_VALUE;
//        int y = 2*x - Integer.MIN_VALUE;
//        System.out.println(y);

//        stack.LC155_MinStack lc155 = new stack.LC155_MinStack();
        MinStack minStack = new LC155_MinStack().new MinStack(); //lc155.new MinStack();
//
//        minStack.push(3);
//        System.out.println("after push 3, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.push(5);
//        System.out.println("after push 5, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.push(2);
//        System.out.println("after push 2, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.push(1);
//        System.out.println("after push 1, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.push(1);
//        System.out.println("after push 1, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.push(-1);
//        System.out.println("after push -1, top = " + minStack.top() + ", min = " + minStack.getMin());
//
//        minStack.pop();
//        System.out.println("after pop, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.pop();
//        System.out.println("after pop, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.pop();
//        System.out.println("after pop, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.pop();
//        System.out.println("after pop, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.pop();
//        System.out.println("after pop, top = " + minStack.top() + ", min = " + minStack.getMin());
//        minStack.pop();
//        System.out.println("after pop, top = " + minStack.top() + ", min = " + minStack.getMin());

//        minStack.push(-1);
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());

        minStack.push(Integer.MAX_VALUE);
        minStack.push(Integer.MIN_VALUE);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
