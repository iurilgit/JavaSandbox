package unionset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ruili1 on 9/30/17.
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

 The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
 with one additional edge added. The added edge has two different vertices chosen from 1 to N,
 and was not an edge that already existed.

 The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v]
 with u < v, that represents an undirected edge connecting nodes u and v.

 Return an edge that can be removed so that the resulting graph is a tree of N nodes.
 If there are multiple answers, return the answer that occurs last in the given 2D-array.
 The answer edge [u, v] should be in the same format, with u < v.

 ---
 Idea:

 Construct a list of sets to manage vertices that are connected with each other.
 The sets are not interconnected with each other.
 For each new edge, check if the two vertices are one of the following cases:
 - they each exist in one set but the two sets are not connected: merge two sets.
 - they do not exist in any of the set: create a new set
 - one of them exists in one set, but the other does not exist in any set: put both in the same set
 - they both exist in the same connected set: they are candidate for redundant edge
Go through all edges and return the last redundant edge. If no such edge is found, return [0, 0].

 */
public class LC684_RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {

        List<HashSet<Integer>> verticeSets = new ArrayList<HashSet<Integer>>();
        int[] redundantEdge = new int[2];
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            int[] verticeSetIndices = checkAgainstVerticeSets(verticeSets, edge);
            int uIdx = verticeSetIndices[0];
            int vIdx = verticeSetIndices[1];

            if(uIdx == -1 && vIdx == -1){
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(u);
                set.add(v);
                verticeSets.add(set);
            }else if(uIdx != -1 && vIdx == -1){
                verticeSets.get(uIdx).add(v);
            }else if(uIdx == -1 && vIdx != -1) {
                verticeSets.get(vIdx).add(u);
            }else{
                if(uIdx != vIdx){
                    verticeSets.get(uIdx).addAll(verticeSets.get(vIdx));
                    verticeSets.remove(vIdx);
                }else{
                    redundantEdge = edge;
                }
            }
        }

        return redundantEdge;
    }

    private static int[] checkAgainstVerticeSets(List<HashSet<Integer>> verticeSets, int[] edge){

        int[] setIdx = {-1, -1};
        for(int i = 0; i < verticeSets.size(); i++){
            Set<Integer> set = verticeSets.get(i);
            if(set.contains(edge[0])){
                setIdx[0] = i;
            }
            if(set.contains(edge[1])){
                setIdx[1] = i;
            }
        }

        return setIdx;
    }

    public static void main(String[] args){

//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
//        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
//        int[][] edges = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        int[][] edges = {{1,5},{3,4},{3,5},{4,5},{2,4}};
        int[] redundantEdge = findRedundantConnection(edges);

        System.out.print(redundantEdge[0] + "," + redundantEdge[1]);
    }
}
