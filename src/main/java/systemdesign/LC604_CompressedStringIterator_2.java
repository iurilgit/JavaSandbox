package systemdesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruili1 on 8/28/17.
 *
 * smarter version. instead of reconstruct the uncompressed string, it keeps the char and count in a list.
 */
public class LC604_CompressedStringIterator_2 {

    class StringIterator {

        class CharOccurence{
            char c;
            int occurence;

            CharOccurence(char c, int occurence){

                this.c = c;
                this.occurence = occurence;
            }
        }

        List<CharOccurence> list;

        public StringIterator(String compressedString) {

            list = new ArrayList<CharOccurence>();

            int i = 0;
            int prevCharIdx = 0;
            int currCharIdx = 0;
            int count;
            Character prevChar = compressedString.charAt(0);
            Character currChar = null;

            while (i < compressedString.length()) {
                Character c = compressedString.charAt(i);
                if (!Character.isDigit(c)) {
                    currCharIdx = i;
                    currChar = c;
                }

                if (currCharIdx > prevCharIdx) {
                    count = Integer.parseInt(compressedString.substring(prevCharIdx + 1, currCharIdx));
                    list.add(new CharOccurence(prevChar, count));

                    prevCharIdx = currCharIdx;
                    prevChar = currChar;
                }

                i++;
            }

            count = Integer.parseInt(compressedString.substring(currCharIdx + 1));
            list.add(new CharOccurence(currChar, count));

        }

        public char next() {

            if (hasNext()) {
                list.get(0).occurence--;
                char c = list.get(0).c;
                if (list.get(0).occurence == 0) {
                    list.remove(0);
                }

                return c;
            } else {
                return ' ';
            }
        }

        public boolean hasNext() {

            return !list.isEmpty();
        }

        public void print() {

            for (CharOccurence charOccurence : list) {
                System.out.println(charOccurence.c + "[" + charOccurence.occurence + "]");
            }
        }

    }

    public static void main(String[] args){

        StringIterator iterator = new LC604_CompressedStringIterator_2().new StringIterator("x6");//
        iterator.print();

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
