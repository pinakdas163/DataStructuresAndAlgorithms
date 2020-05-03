package com.daspinak.datastructures;

public class MyQueue<T> {
    private int maxSize;
    private int first;
    private int last;
    private T arr[];
    private int currentSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.first = -1;
        this.last = -1;
        this.arr = (T[]) new Object[maxSize];
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            int i = 0;
            int index = this.first;
            while (i < currentSize) {
                System.out.println("Item at " + index + " position is " + this.arr[index] + " with priority " + ++i);
                index = (++index) % this.maxSize;
            }
        }
    }

    public void enqueue(T value) {
        if (isFull()) {
            //System.out.println("Queue is full");
            return;
        }

        this.last = (++this.last) % this.maxSize;
        if (isEmpty()) {
            this.first = this.last;
        }
        this.arr[last] = value;
        //System.out.println("Item " + value + " added successfully");
        this.currentSize++;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public T dequeue() {
        if (isEmpty()) {
            //System.out.println("Queue is empty, nothing to deque");
            return null;
        }

        T val = this.arr[first];
        this.currentSize--;
        if (isEmpty()) {
            this.last = -1;
            this.first = -1;
        } else {
            this.first = (++this.first) % this.maxSize;
        }
        //System.out.println("Item " +  val + " is removed from queue");
        return val;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean isFull() {
        return this.currentSize == this.maxSize;
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }

        return arr[first];
    }
}
