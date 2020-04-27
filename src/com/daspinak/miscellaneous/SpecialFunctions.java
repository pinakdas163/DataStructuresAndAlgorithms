package com.daspinak.miscellaneous;

import com.daspinak.datastructures.MyQueue;
import com.daspinak.datastructures.MyStack;

public class SpecialFunctions {
    public static Object[] findBin(int number) {
        MyQueue<String> myQueue = new MyQueue<>(number);
        for (int i = 1; i <=number; i++) {
            myQueue.enqueue(getBin(i));
        }
        return myQueue.getArr();
    }

    public static String getBin(int num) {
        if (num == 1) {
            return "1";
        } else {
            int rem = num % 2;
            int q = num / 2;
            return getBin(q) + rem;
        }
    }

    public static int evaluatePostfixChallenge(String expr) {
        int length = expr.length();
        MyStack<Integer> myStack = new MyStack<>(length);
        for (int i = 0; i < length; i++) {
            char str = expr.charAt(i);
            if (Character.isDigit(str)) {
                int num = Character.getNumericValue(str);
                myStack.push(num);
            } else {
                int num1 = myStack.pop();
                int num2 = myStack.pop();
                if (str == '/') {
                    int num3 = num2 / num1;
                    myStack.push(num3);
                } else if (str == '*') {
                    int num3 = num2 * num1;
                    myStack.push(num3);
                } else if (str == '+') {
                    int num3 = num2 + num1;
                    myStack.push(num3);
                } else if (str == '-') {
                    int num3 = num2 - num1;
                    myStack.push(num3);
                }
            }
        }

        int res = (int) myStack.pop();
        return res == 0 ? 0 : res;
    }

    public static boolean isBalanced(String exp) {
        boolean balanced = false;

        int length = exp.length();
        MyStack<Character> stack = new MyStack<>(length);
        expLoop: for (int i = 0; i < length; i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.top() == '(') {
                        stack.pop();
                        balanced = true;
                        break;
                    } else {
                        balanced = false;
                        break expLoop;
                    }
                case '}':
                    if (stack.top() == '{') {
                        stack.pop();
                        balanced = true;
                        break;
                    } else {
                        balanced = false;
                        break expLoop;
                    }
                case ']':
                    if (stack.top() == '[') {
                        stack.pop();
                        balanced = true;
                        break;
                    } else {
                        balanced = false;
                        break expLoop;
                    }
            }
        }

        return balanced;
    }
}
