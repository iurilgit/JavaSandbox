package systemdesign;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by ruili1 on 8/28/17.
 *
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool searchRange(word)
 searchRange(word) can searchRange a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 searchRange("pad") -> false
 searchRange("bad") -> true
 searchRange(".ad") -> true
 searchRange("b..") -> true
 */
public class LC211_Dictionary {

    class TrieWithRegexSupport extends Trie {

        public TrieWithRegexSupport() {
            super();
        }

        /**
         * Returns if the word is in the data structure.
         * A word could contain the dot character '.' to represent any one letter.
         */
        @Override
        public boolean search(String word) {

            char[] chars = word.toCharArray();
            return search(root, chars);
        }

        private boolean search(Node node, char[] chars) {

            Map<Character, Node> currChildren = node.children;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '.') {
                    for (char key : currChildren.keySet()) {
                        if (search(currChildren.get(key), Arrays.copyOfRange(chars, i + 1, chars.length))) {
                            return true;
                        }
                    }
                    return false;
                } else if (!currChildren.containsKey(c)) {
                    return false;
                } else {
                    currChildren = currChildren.get(c).children;
                }
            }

            if(currChildren.containsKey(ENDING_CHAR)) {
                return true;
            }else{
                return false;
            }
        }
    }


    public static void main(String[] args) {

        Trie trie = new LC211_Dictionary().new TrieWithRegexSupport();
        trie.insert("apple");
        trie.insert("banana");
        trie.print();

        System.out.println(trie.search("app.le"));
    }


}
