package systemdesign;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ruili1 on 8/28/17.

 Design and implement a data structure for a compressed string iterator.
 It should support the following operations: next and hasNext.

 The given compressed string will be in the form of each letter
 followed by a positive integer representing the number of this letter
 existing in the original uncompressed string.

 next() - if the original string still has uncompressed characters,
 return the next letter; Otherwise return a white space.
 hasNext() - Judge whether there is any letter needs to be uncompressed.

 Note:
 Please remember to RESET your class variables declared in StringIterator,
 as static/class variables are persisted across multiple test cases. Please see here for more details.

 Example:

 StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

 iterator.next(); // return 'L'
 iterator.next(); // return 'e'
 iterator.next(); // return 'e'
 iterator.next(); // return 't'
 iterator.next(); // return 'C'
 iterator.next(); // return 'o'
 iterator.next(); // return 'd'
 iterator.hasNext(); // return true
 iterator.next(); // return 'e'
 iterator.hasNext(); // return false
 iterator.next(); // return ' '


 Note: this solution has a problem: when the count of a char is very large, say 1234567890, it will time out.
 Thus, a more effective solution LC604_CompressedStringIterator_2 is implemented.
 */
public class LC604_CompressedStringIterator {

    class StringIterator {

        Queue<Character> queue = null;
        public StringIterator(String compressedString) {

            queue = new LinkedList<Character>();

            int i = 0;
            int prevCharIdx = 0;
            int currCharIdx = 0;
            int count;
            Character prevChar = compressedString.charAt(0);
            Character currChar = null;

            while(i < compressedString.length()) {
                Character c = compressedString.charAt(i);
                if (!Character.isDigit(c)) {
                    currCharIdx = i;
                    currChar = c;
                }

                if (currCharIdx > prevCharIdx) {
                    count = Integer.parseInt(compressedString.substring(prevCharIdx + 1, currCharIdx));

                    for (int j = 0; j < count; j++) {
                        queue.add(prevChar);
                    }
                    prevCharIdx = currCharIdx;
                    prevChar = currChar;
                }

                i++;
            }

            count = Integer.parseInt(compressedString.substring(currCharIdx + 1));
            for (int j = 0; j < count; j++) {
                queue.add(currChar);
            }
        }

        public char next() {

            if(hasNext()) {
                return queue.poll();
            }else{
                return ' ';
            }
        }

        public boolean hasNext() {

            return !queue.isEmpty();
        }

        public void print(){

            while(!queue.isEmpty()){
                System.out.print(queue.poll());
            }
        }
    }

    public static void main(String[] args){

        StringIterator iterator = new LC604_CompressedStringIterator().new StringIterator("x6");//L1e2t1C1o1d1e2
//        iterator.print();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
