package com.daspinak;

import com.daspinak.datastructures.GraphUsingAdjacencyList;

// Main class to run all the implementations
public class Base {
    public static void main(String[] args) {
        GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
//        g.addEdge(0,1);
//        g.addEdge(0,2);
//        g.addEdge(1,3);
//        g.addEdge(2,3);
//        g.addEdge(2,4);
//        g.addEdge(2,5);
//        g.addEdge(5,0);

        System.out.println(g.dfsTraversal(0));
    }
}
