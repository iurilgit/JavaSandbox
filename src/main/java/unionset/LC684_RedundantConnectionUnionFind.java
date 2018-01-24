package unionset;

/**
 * Created by ruili1 on 10/1/17.
 *
 * This is the same qustion as LC684_RedundantConnection.
 * But solution leverages union find data structure.
 */
public class LC684_RedundantConnectionUnionFind {

    public static int[] findRedundantConnection(int[][] edges) {

        // define parents (the started vertice that connects all
        int[] parents = new int[2001];
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
        }

        int[] redundantEdge = new int[2];
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(find(parents, u) == find(parents, v)){
                redundantEdge = edge;
            }else{
                parents[find(parents, u)] = find(parents, v);
            }
        }

        return redundantEdge;
    }

    public static int find(int[] parents, int v){

        while(parents[v] != v){
            v = parents[v];
        }
        return v;
    }

    public static void main(String[] args){

//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
//        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[][] edges = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
//        int[][] edges = {{1,5},{3,4},{3,5},{4,5},{2,4}};
        int[] redundantEdge = findRedundantConnection(edges);

        System.out.print(redundantEdge[0] + "," + redundantEdge[1]);
    }
}
