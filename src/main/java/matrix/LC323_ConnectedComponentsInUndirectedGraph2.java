package matrix;

import array.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruili1 on 1/21/18.
 */
public class LC323_ConnectedComponentsInUndirectedGraph2 {

    public static int numberOfConnectedComponents(int[] nodes, List<int[]> edges){

        int label = -1;
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] == 0){
                nodes[i] = label;
                dfs(nodes, edges, i, label);
                label--;
            }
        }

        return -label-1;
    }

    public static void dfs(int[] nodes, List<int[]> edges, int i, int label){

        for(int[] edge : edges){
            if(edge[0] == i || nodes[edge[1]] == 0){
                nodes[edge[1]] = label;
                dfs(nodes, edges, edge[1], label);
            }
        }
    }

    public static int numberOfConnectedComponents2(int[] nodes, List<int[]> edges) {

        int count = nodes.length;

        for(int i=0; i<count; i++){
            nodes[i]=i;
        }

        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];

            int xRoot = getRoot(nodes, x);
            int yRoot = getRoot(nodes, y);

            if(xRoot!=yRoot){
                count--;
                union(nodes, xRoot, yRoot);
            }
        }

        return count;
    }

    private static void union(int[] arr, int x, int y){

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == x){
                arr[i] = y;
            }
        }
    }

    private static int getRoot(int[] arr, int i){

        while(arr[i]!=i){
            arr[i]= arr[arr[i]];
            i=arr[i];
        }
        return i;
    }

    public static void main(String[] args){

        // edges
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{0, 3});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{0, 5});

        // nodes
        int[] nodes = new int[6];

        int connectedComponentNum = numberOfConnectedComponents2(nodes, edges);
        Utils.printArray(nodes);
        System.out.println(connectedComponentNum);
    }
}
