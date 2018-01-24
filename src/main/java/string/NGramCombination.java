package string;

/**
 * Created by iurilgit on 1/10/17.
 */
public class NGramCombination {

    public static int f(int n){

        if(n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (n == 3)
            return 4;
        else
            return f(n-1) + f(n-2) + f(n-3);
	}

    public static void main(String[] args) throws Exception{
        System.out.println(f(4));
    }
}
