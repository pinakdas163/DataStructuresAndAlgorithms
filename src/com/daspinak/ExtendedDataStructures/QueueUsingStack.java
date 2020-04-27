package com.daspinak.ExtendedDataStructures;

import com.daspinak.datastructures.MyStack;

class QueueUsingStack <V> {
    private int maxSize;
    private int currentSize;
    private MyStack<V> myStack1;
    private MyStack<V> myStack2;

    public QueueUsingStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.myStack1 = new MyStack<>(maxSize);
        this.myStack2 = new MyStack<>(maxSize);
    }

    public void enqueue(V value) {
        // Write -- Your -- Code
        if (this.isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.myStack1.push(value);
        System.out.println("Value inserted: " + value);
        this.currentSize++;
    }

    public V dequeue() {
        // Write -- Your -- Code
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        if (myStack2.isEmpty()) {
            while (!myStack1.isEmpty()) {
                myStack2.push(myStack1.pop());
            }
        }
        this.currentSize--;
        V val = this.myStack2.pop();
        System.out.println("Value removed: " + val);
        return val;
    }

    public boolean isFull() {
        return this.currentSize == this.maxSize;
    }

    public boolean isEmpty() {
        //Write -- Your -- Code
        return this.currentSize == 0;
    }
}
