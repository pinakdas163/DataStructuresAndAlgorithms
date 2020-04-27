package com.daspinak.ExtendedDataStructures;

import com.daspinak.datastructures.MyStack;

public class SortStack {
    public static void sortStack(MyStack<Integer> myStack) {
        if (!myStack.isEmpty()) {
            int val = myStack.pop();
            System.out.println("Inside memory " + val);
            sortStack(myStack);
            insertVal(myStack, val);
        }
    }

    private static void insertVal(MyStack<Integer> myStack, int value) {
        if (myStack.isEmpty() || value <= myStack.top()) {
            System.out.println("Added in the if " + value);
            myStack.push(value);
        } else {
            int item = myStack.pop();
            insertVal(myStack, value);
            System.out.println("Added in the else " + item);
            myStack.push(item);
        }
    }
}
