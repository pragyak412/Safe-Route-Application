package com.example.saferoute1;
//import java.util.*;
//import java.lang.*;
//import java.io.*;


import android.util.Log;

import java.util.ArrayList;

public class Dijkstra{

    private static final int NO_PARENT = -1;
    ArrayList<Integer> path = new ArrayList<Integer>();

    // Function that implements Dijkstra's
    // single source shortest path
    // algorithm for a graph represented
    // using adjacency matrix
    // representation
    public void dijkstraAlgo(int[][] adjacencyMatrix,
                             int startVertex, int destIndex)
    {
        int nVertices = adjacencyMatrix[0].length;

        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;

        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not
        // have a parent
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all
        // vertices
        for (int i = 1; i < nVertices; i++)
        {

            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            // Mark the picked vertex as
            // processed
            added[nearestVertex] = true;

            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents,  destIndex);
    }

    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private  void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents, int destIndex)
    {
//        int nVertices = distances.length;
//        System.out.print("Vertex\t Distance\tPath");

        int vertexIndex = destIndex;
        Log.e("startVertex " , startVertex + " -> ");
        Log.e("destIndex " ,vertexIndex + " \t\t ");
        Log.e(" distances " ,distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);


    }

    // Function to print shortest path
    // from source to currentVertex
    // using parents array
    private  void printPath(int currentVertex,
                                  int[] parents)
    {

        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        Log.e(" " , currentVertex + " ");
        path.add(currentVertex);
    }



}

// This code is contributed by Harikrishnan Rajan
