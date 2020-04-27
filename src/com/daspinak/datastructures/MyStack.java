package com.daspinak.datastructures;

public class MyStack<T> {
    private int maxSize;
    private int currentSize;
    private int top;
    private T[] arr;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.arr = (T[]) new Object[this.maxSize];
        this.currentSize = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = top; i > -1; i--) {
                System.out.println("Item ->" + this.arr[i]);
            }
        }
    }

    public void push (T value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        top += 1;
        currentSize++;
        this.arr[top] = value;
        //System.out.println("Item added successfully");
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = this.arr[top];
        top -= 1;
        currentSize--;
        return data;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == (this.maxSize - 1);
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }

        return this.arr[top];
    }
}
