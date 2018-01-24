import java.util.*;

/**
 * Created by iurilgit on 8/22/17.
 */
public class Test {

    public static void printGrid(int[][] grid){

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){

        int a = 5;
        int b = 3;

        System.out.println(a ^ b);
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        Collections.sort(list);
//        System.out.println(list);

//        int i = 0;
//        String s = String.valueOf(i);
//
//        Integer i2 = 1;
//        String s2 = i2.toString();
//
//        char[] array = {'a', 'b'};
//        String s3 = String.valueOf(array);

//            int[] nums = {2,1};
//            Arrays.sort(nums);
//            for(int num : nums){
//                System.out.println(num);
//            }

//        String s = "test";
//        char[] chars = s.toCharArray();
//        char[] subChars = Arrays.copyOfRange(chars, 1, 4);
//        String subStr = s.substring(1, 4);
//        System.out.println(new String(subChars));
//        System.out.println(subStr);

//        int[][] grid = new int[3][3];
//        grid[0][0] = 1;
//        printGrid(grid);

//        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
//
//        min.add(5);
//        min.add(1);
//
//        System.out.println(min.peek());

//        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
//        map.put(0, "A");
//        map.put(2, "C");
//        map.put(1, "B");
//
//        SortedMap<Integer, String> submap = map.subMap(0, 0);
//        List<String> values = new ArrayList<String>();
//        for(int key : submap.keySet()){
//            values.add(submap.get(key));
//        }
//        System.out.println(values);

//        String a = "abc";
//        String b = a.substring(0, 4);
//        System.out.println(b);

//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
//        map.put(1,10);
//        map.put(2, 20);
//        map.put(3, 30);
//        System.out.println(map.keySet());
//
//        map.remove(1);
////        = map.getOrDefault(1, -1);
//        map.put(1, 11);
//
//        System.out.println(map.keySet());

    }
}
