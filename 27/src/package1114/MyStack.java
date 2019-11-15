package package1114;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    public Queue<Integer> queue1;

    public Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue1.isEmpty()) {
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        int oldData = 0;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size -1; i++) {
                queue2.offer(queue1.poll());
            }
            oldData = queue1.poll();
        }else if(!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size-1; i++) {
                queue1.offer(queue2.poll());
            }
            oldData = queue2.poll();
        }
        return oldData;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        int oldData = 0;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size ; i++) {
                oldData = queue1.poll();
                queue2.offer(oldData);
            }
        }else if(!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size ; i++) {
                oldData = queue2.poll();
                queue1.offer(oldData);
            }
        }
        return oldData;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}

