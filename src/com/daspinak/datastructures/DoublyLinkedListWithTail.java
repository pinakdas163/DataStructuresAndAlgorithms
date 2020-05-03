package com.daspinak.datastructures;

public class DoublyLinkedListWithTail<T> {
    private Node headNode;
    private Node tailNode;
    private int currentSize;

    public class Node {
        private T data;
        private Node prev;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }
    }

    public DoublyLinkedListWithTail() {
        this.headNode = null;
        this.tailNode = null;
        this.currentSize = 0;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public T getHeadNodeData() {
        if (headNode == null) {
            return null;
        }
        return headNode.data;
    }

    public T getTailNodeData() {
        if (tailNode == null) {
            return null;
        }
        return tailNode.data;
    }

    public boolean isEmpty() {
        return this.headNode == null && this.tailNode == null;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.tailNode = newNode;
        } else {
            this.headNode.prev = newNode;
            newNode.next = this.headNode;
        }

        this.headNode = newNode;
        this.currentSize++;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }

        if (this.currentSize == 1) {
            this.tailNode = null;
        }

        this.headNode.prev = null;
        this.headNode = this.headNode.next;
        this.currentSize--;
    }

    public void insertAtTail(T data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.headNode = newNode;
        } else {
            this.tailNode.next = newNode;
            newNode.prev = this.tailNode;
        }

        this.tailNode = newNode;
        this.currentSize++;
    }

    public void deleteAtTail() {
        if (isEmpty()) {
            return;
        }

        if (this.currentSize == 1) {
            this.headNode = null;
        } else {
            tailNode.prev.next = tailNode.next;
        }

        tailNode = tailNode.prev;
        this.currentSize--;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("The doubly linked list with a tail is empty");
        } else {
            System.out.println("The doubly linked list with a tail consists:");
            Node node = headNode;
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public void printListReverse() {
        if (isEmpty()) {
            System.out.println("The doubly linked list with a tail is empty");
        } else {
            System.out.println("The doubly linked list with a tail consists:");
            Node node = this.tailNode;
            while (node != null) {
                System.out.println(node.data);
                node = node.prev;
            }
        }
    }

    public boolean dataExist(T data) {
        Node temp = headNode;

        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
}
