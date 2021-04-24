package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
public class ShortestPath {


        static final int V = 8;
        int minDistaneCovered(int distance[], Boolean shortestPathSet[])
        {
            // Initialize min value
            int minimum = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (shortestPathSet[v] == false && distance[v] <= minimum) {
                    minimum = distance[v];
                    min_index = v;
                }

            return min_index;
        }


        void printSolution(int distance[])
        {
            System.out.println("Vertex \t\t Distance from source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + distance[i]);
        }

        void dijkstra(int graph[][], int src)
        {
            int distance[] = new int[V];

            Boolean shortestPathSet[] = new Boolean[V];


            for (int i = 0; i < V; i++) {
                distance[i] = Integer.MAX_VALUE;
                shortestPathSet[i] = false;
            }


            distance[src] = 0;

            // Find shortest path for all vertices
            for (int sum = 0; sum < V - 1; sum++) {

                int u = minDistaneCovered(distance, shortestPathSet);

                // Mark the picked vertex as processed
                shortestPathSet[u] = true;


                for (int v = 0; v < V; v++)

                    if (!shortestPathSet[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v])
                        distance[v] = distance[u] + graph[u][v];
            }

            // print the constructed distance array
            printSolution(distance);
        }

        // main method
        public static void main(String[] args)
        {

            int graph[][] = new int[][] { { 0, 6, 0, 0, 0, 0, 0, 9, 0 },
                    { 6, 0, 9, 0, 0, 0, 0, 11, 0 },
                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                    { 0, 0, 5, 0, 9, 14, 0, 0, 0 },
                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                    { 0, 0, 4, 10, 10, 0, 2, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            ShortestPath p = new ShortestPath();
            p.dijkstra(graph, 0);
        }
    }


