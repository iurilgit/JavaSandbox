package systemdesign.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ruili1 on 10/8/17.
 */
public class Tweet{

    static int counter = 1;

    public int id = 0;
    public int user_id;
    public String text;

    public Tweet(){

    }

    public Tweet(int user_id, String tweet_text) {

        this.id = counter++;
        this.user_id = user_id;
        this.text = tweet_text;
    }

    public static Tweet create(int user_id, String tweet_text) {

        return new Tweet(user_id, tweet_text);
    }


    @Override
    public String toString(){
//        return id + ": [" + user_id +"] " + text;
        return String.valueOf(id);
    }

    class TweetComparator implements Comparator<Tweet> {

        public int compare(Tweet o1, Tweet o2) {

            if(o1.id > o2.id) {
                return -1;
            }else if(o1.id == o2.id) {
                return 0;
            }else {
                return 1;
            }
        }
    }

    public static void main(String[] args){

        Tweet t1 = new Tweet(5, "i am first one");
        System.out.println(t1.toString());
        Tweet t2 = new Tweet(5, "i am second one");
        System.out.println(t2.toString());

        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets.add(t1);
        tweets.add(t2);
        System.out.println(tweets);
        Collections.sort(tweets, new Tweet().new TweetComparator());
        System.out.println(tweets);
    }
}