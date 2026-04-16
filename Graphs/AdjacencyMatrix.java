package Graphs;

import java.util.Scanner;

public class AdjacencyMatrix {

    public static int[][] createAdjMatGraph(int n , int m, boolean isWeighted, boolean isDirected, Scanner s){
        int[][] adjMat = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int u = s.nextInt();
            int v = s.nextInt();
            int w = isWeighted ? s.nextInt() : 1;

            adjMat[u][v] = w;
            if(!isDirected)
                adjMat[v][u] = w;
        }
        return adjMat;
    }

    public static void display(int [][] adjMat){
        for(int i=1; i<adjMat.length; i++){
            for(int j=0; j<adjMat[0].length; j++){
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of vertices in the graph : ");
        int n = s.nextInt();

        System.out.println("Enter number of edges in the graph : ");
        int m = s.nextInt();

        System.out.println("Choose the type of Graph : ");
        System.out.println("1. Undirected Graph");
        System.out.println("2. Undirected Weighted Graph");
        System.out.println("3. Directed Graph");
        System.out.println("4. Directed Weighted Graph");

        int [][] adjMat = new int[n+1][n+1];

        switch (s.nextInt()) {
            case 1:
                adjMat = createAdjMatGraph(n, m, false, false, s);
                break;
            
            case 2:
                adjMat = createAdjMatGraph(n, m, true, false, s);
                break;

            case 3: 
                adjMat = createAdjMatGraph(n, m, false, true, s);
                break;

            case 4:
                adjMat = createAdjMatGraph(n, m, true, true, s);
                break;

            default:
                System.out.println("Invalid Choice");
                break;
        }

        display(adjMat);

    }
}
