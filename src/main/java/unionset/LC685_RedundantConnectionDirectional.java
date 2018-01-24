package unionset;

/**
 * Created by ruili1 on 10/1/17.
 *
 * Similar to LC684 except the edges are directional {u, v} means u -> v.
 *
 * ----
 * Idea:
 *
 */
public class LC685_RedundantConnectionDirectional {

    public static int[] findRedundantDirectedConnection(int[][] edges) {

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

        int[][] edges = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        int[] redundantEdge = findRedundantDirectedConnection(edges);

        System.out.print(redundantEdge[0] + "," + redundantEdge[1]);
    }
}
