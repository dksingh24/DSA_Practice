package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyList {

    public static ArrayList<Integer>[] createAdjListGraph(int n, int m, boolean isDirected, Scanner s){
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        Arrays.setAll(adjList, i -> new ArrayList<>());
        for(int i=0; i<m; i++){
            int u = s.nextInt();
            int v = s.nextInt();

            adjList[u].add(v);
            if(!isDirected)
                adjList[v].add(u);
        }
        return adjList;
    }

    public static void display(ArrayList<Integer>[] adjList){
        for(int i=1; i<adjList.length; i++){
            System.out.print(i + " -> ");
            for(int j : adjList[i])
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = s.nextInt();

        System.out.print("Enter the number of edges : ");
        int m = s.nextInt();

        System.out.println("Choose the type of Graph : ");
        System.out.println("1. Undirected Graph");
        System.out.println("2. Directed Graph");
        // System.out.println("3. Undirected Weighted Graph");
        // System.out.println("4. Directed Weighted Graph");
        
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        // Arrays.setAll(adjList, i -> new ArrayList<>());

        switch (s.nextInt()) {
            case 1:
                adjList = createAdjListGraph(n, m, false, s);
                break;
            
            case 2:
                adjList = createAdjListGraph(n, m, true, s);
                break;

            default:
                System.out.println("Invalid Choice");
                break;
        }
        s.close();

        display(adjList);
    }
}
