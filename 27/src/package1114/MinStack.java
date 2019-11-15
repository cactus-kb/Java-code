package package1114;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int x) {
        //stack栈内一定会入栈
        //第一次MinStack一定会放元素，其余的每次比较之后再放小的元素
        stack.push(x);
        if (minstack.empty()) {
            minstack.push(x);
        } else {
            if (stack.peek() >= x) {
                minstack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        int num = stack.pop();
        if (num == stack.peek()) {
            minstack.pop();
        }
    }

    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getmin() {
        if (minstack.empty()) {
            return -1;
        }
        return minstack.peek();
    }
}
