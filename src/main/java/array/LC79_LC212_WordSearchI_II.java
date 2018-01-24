package array;

import java.util.*;

/**
 * Created by ruili1 on 12/17/17.
 *
 I:

 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 II:
 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 ---
 solution:
 I: nothing fancy, just try match for each char in a backtracking way.
 II: nothing fancy, just call exist() from solution I for each word. But it times out if the word list contains a lot of words.
 However, for a large set of words, this solution is too slow. So a better way is to build a trie from the board,
 then it's super easy to check if a word is in it.
 */
public class LC79_LC212_WordSearchI_II {

    public static boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();

        int height = board.length;
        int width = 0;
        if(height > 0){
            width = board[0].length;
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                char[][] boardCopy = copyMatrix(board);
                if(true == search(boardCopy, i, j, chars)){
                    return true;
                }
            }
        }

        return false;
    }

    private static char[][] copyMatrix(char[][] matrix){

        char[][] copy = new char[matrix.length][];
        for(int i = 0; i < matrix.length; i++){
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        return copy;
    }

    private static boolean search(char[][] board, int m, int n, char[] word){

        if(word.length == 0 || m < 0 || m >= board.length || n < 0 || n >= board[0].length || board[m][n] == 0){
            return false;
        }

        char firstChar = word[0];
        if(board[m][n] == firstChar){
            if(board[m][n] == word[0]){
                char[] restOfWord = Arrays.copyOfRange(word, 1, word.length);
                if(restOfWord.length == 0){
                    return true;
                }
                board[m][n] = 0;
                if(search(board, m+1, n, restOfWord)
                        || search(board, m, n+1, restOfWord)
                        || search(board, m-1, n, restOfWord)
                        || search(board, m, n-1, restOfWord)){
                    return true;
                }else{
                    board[m][n] = firstChar;
                }
            }
        }

        return false;
    }

    public static List<String> findWords(char[][] board, String[] words) {

        Set<String> wordsFound = new HashSet<String>();
        for(String word : words){
            if(exist(board, word)){
                wordsFound.add(word);
            }
        }

        return new ArrayList<String>(wordsFound);
    }

    public static void main(String[] args){

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE")); // true
        System.out.println(exist(board, "ABCB")); // false
        System.out.println(exist(board, "EED")); // true

        char[][] board2 = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        System.out.println(exist(board2, "ABCESEEEFS")); // true

        // LC212_WordSearchII
        char[][] board3 = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board3, words)); // {"eat","oath"}

        char[][] board4 = {{'a','a'}};
        String[] words2 = {"a"};
        System.out.println(findWords(board4, words2)); // {"a"}

    }
}
