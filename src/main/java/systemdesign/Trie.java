package systemdesign;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 8/28/17.
 */
public class Trie {

    static final char ENDING_CHAR = '/';

    class Node{

        char c = ENDING_CHAR;
        Map<Character, Node> children = null;
        //Boolean isLeaf = null;

        public Node(){

            children = new HashMap<Character, Node>();
        }

        public Node(char c){

            this();
            this.c = c;
        }

        public boolean isLeaf(){

            return children == null || children.isEmpty();
        }
    }

    Node root;

    public Trie(){

        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        char[] chars = word.toCharArray();
        Map<Character, Node> currChildren = root.children;
        for(char c : chars){
            if(!currChildren.containsKey(c)){
                currChildren.put(c, new Node(c));
            }
            currChildren = currChildren.get(c).children;
        }
        currChildren.put(ENDING_CHAR, new Node());
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        char[] chars = word.toCharArray();
        Map<Character, Node> currChildren = root.children;
        for(char c : chars){
            if(!currChildren.containsKey(c)){
                return false;
            }
            currChildren = currChildren.get(c).children;
        }
        if(currChildren.containsKey(ENDING_CHAR)) {
            return true;
        }else{
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        char[] chars = prefix.toCharArray();
        Map<Character, Node> currChildren = root.children;
        for(char c : chars){
            if(!currChildren.containsKey(c)){
                return false;
            }
            currChildren = currChildren.get(c).children;
        }

        return true;
    }

    public void print(){

        printTrie(root, 2);
    }

    private void printTrie(Node node, int offset) {

        System.out.println(StringUtils.leftPad(String.valueOf(node.c), offset, ' '));
        // here you can play with the order of the children
        for(char c : node.children.keySet()) {
            printTrie(node.children.get(c), offset + 2);
        }
    }

    public static void main(String[] args){

        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("appld");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("bandana");

        trie.print();

        System.out.println(trie.search("apple"));   //true
        System.out.println(trie.search("appl"));    // false
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("bandana")); // true
        System.out.println(trie.search("ban"));     // false

        System.out.println(trie.startsWith("ap"));      // true
        System.out.println(trie.startsWith("app"));     // true
        System.out.println(trie.startsWith("appl"));    // true
        System.out.println(trie.startsWith("ba"));  //true
        System.out.println(trie.startsWith("bd"));  //false
    }

}
