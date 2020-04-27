package com.daspinak.extendedDataStructures;

class TwoStacks<V> {
    private int maxSize;
    private int top1;
    private int top2;
    private V[] array;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        this.top1 = -1;
        this.top2 = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    //insert at top of first stack
    public void push1(V value) {
        if (isFull()) {
            System.out.println("Stack full, unable to push");
            return;
        }
        array[++top1] = value;
    }

    //insert at top of second stack
    public void push2(V value) {
        if (isFull()) {
            System.out.println("Stack full, unable to push");
            return;
        }
        array[--top2] = value;
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (isEmpty()) {
            System.out.println("Stack empty, nothing to pop");
            return null;
        }

        return array[top1--];
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (isEmpty()) {
            System.out.println("Stack empty, nothing to pop");
            return null;
        }

        return array[top2++];
    }

    private boolean isFull() {
        return  (this.top2 - this.top1) <= 1;
    }

    public boolean isEmpty() {
        return this.top1 == -1 && this.top2 == maxSize;
    }
}

