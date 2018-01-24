package systemdesign;

import java.util.*;

/**
 * Created by ruili1 on 10/12/17.
 */
public class MiniCassandra {

    public class Column {

        public int key;
        public String value;

        public Column(int key, String value) {

            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){

            return "(" + key + ", " + value + ")";
        }
    }

    Map<String, TreeMap<Integer, Column>> map = null;

    public MiniCassandra() {

        map = new HashMap<String, TreeMap<Integer, Column>>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String raw_key, int column_key, String column_value) {

        TreeMap treeMap = new TreeMap<Integer, Column>();
        if(map.containsKey(raw_key)){
            treeMap = map.get(raw_key);
        }

        treeMap.put(column_key, new Column(column_key, column_value));
        map.put(raw_key, treeMap);
    }

    /*
     * @param raw_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {

        column_end++;

        List<Column> values = new ArrayList<Column>();
        if(column_end < column_start){
            return values;
        }

        if(!map.containsKey(raw_key)){
            return values;
        }

        SortedMap<Integer, Column> submap = map.get(raw_key).subMap(column_start, column_end);
        for(Integer key : submap.keySet()){
            values.add(submap.get(key));
        }

        return values;
    }

    public static void main(String[] args){

        MiniCassandra cassandra = new MiniCassandra();
        cassandra.insert("google", 1, "haha");
        cassandra.insert("lintcode", 1, "Good");
        cassandra.insert("google", 2, "hehe");

        System.out.println(cassandra.query("google", 0, 1));
        System.out.println(cassandra.query("google", 0, 2));
        System.out.println(cassandra.query("go", 0, 1));
        System.out.println(cassandra.query("lintcode", 0, 10));
    }
}