package com.daspinak.datastructures;

public class GraphUsingAdjacencyList {
    private DoublyLinkedListWithTail<Integer>[] adjacencyList;
    private int noOfVertices;

    public GraphUsingAdjacencyList(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjacencyList = new DoublyLinkedListWithTail[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            adjacencyList[i] = new DoublyLinkedListWithTail<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source > noOfVertices || destination > noOfVertices || this.adjacencyList[source].dataExist(destination)) {
            return;
        }

        adjacencyList[source].insertAtTail(destination);
    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < noOfVertices; i++) {
            if (adjacencyList[i]!=null) {
                System.out.print("|" + i + "| => ");
                DoublyLinkedListWithTail<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.getData() + "] -> ");
                    temp = temp.getNext();
                }
                System.out.println("null");
            } else {
                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }

    public String bfsTraversal(int source) {
        String result = "";
        boolean[] visited = new boolean[noOfVertices];

        DoublyLinkedListWithTail<Integer> list = null;
        MyQueue<Integer> queue = new MyQueue<>(noOfVertices);
        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int index = queue.dequeue();
            result += index;
            list = adjacencyList[index];

            DoublyLinkedListWithTail<Integer>.Node node = list.getHeadNode();
            while (node != null) {
                int ix = node.getData();
                if (visited[ix] == false) {
                    queue.enqueue(ix);
                    visited[ix] = true;
                }

                node = node.getNext();
            }
        }

        return result;
    }

    public String dfsTraversal(int source) {
        String result = "";
        boolean[] visited = new boolean[noOfVertices];
        MyStack<Integer> stack = new MyStack<>(noOfVertices);
        stack.push(source);
        DoublyLinkedListWithTail<Integer> list;
        DoublyLinkedListWithTail<Integer>.Node node;

        while (!stack.isEmpty()) {
            source = stack.pop();
            result += source;
            visited[source] = true;
            list = adjacencyList[source];
            node = list.getTailNode();

            while (node != null) {
                int vertex = node.getData();
                if (visited[vertex] == false) {
                    stack.push(vertex);
                }
                node = node.getPrev();
            }
        }

        return result;
    }
}
