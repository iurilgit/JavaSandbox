package string;

/**
 * Created by ruili1 on 9/9/17.
 */
public class LC657_JudgeRouteCircle {

    public static boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        char[] chars = moves.toCharArray();
        for(char c : chars){
            switch (c){
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    break;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args){

        String moves = "LL";
        System.out.println(judgeCircle(moves));

    }
}
