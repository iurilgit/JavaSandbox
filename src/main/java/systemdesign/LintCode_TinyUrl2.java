package systemdesign;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 10/14/17.
 *
 * Given a long url, make it shorter. To make it simpler, let's ignore the domain name.

 You should implement two methods:

 longToShort(url). Convert a long url to a short url.
 shortToLong(url). Convert a short url to a long url starts with http://tiny.url/.
 You can design any shorten algorithm, the judge only cares about two things:

 The short key's length should equal to 6 (without domain and slash).
 And the acceptable characters are [a-zA-Z0-9]. For example: abcD9E
 No two long urls mapping to the same short url and no two short urls mapping to the same long url.
 Have you met this question in a real interview? Yes
 Example
 Given url = http://www.lintcode.com/faq/?id=10, run the following code (or something similar):

 short_url = longToShort(url) // may return http://tiny.url/abcD9E
 long_url = shortToLong(short_url) // return http://www.lintcode.com/faq/?id=10
 The short_url you return should be unique short url and start with http://tiny.url/
 and 6 acceptable characters. For example "http://tiny.url/abcD9E" or something else.

 The long_url should be http://www.lintcode.com/faq/?id=10 in this case.

 As a follow up for Tiny URL, we are going to support custom tiny url,
 so that user can create their own tiny url.

 Notice:

 Custom url may have more than 6 characters or less than 6 characters in path.

 */
public class LintCode_TinyUrl2 {
    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */

    static String alphabetStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static char[] alphabet = alphabetStr.toCharArray();
    static int alphabetSize = alphabet.length;
    static String BASE_URL = "http://tiny.url/";

    Map<String, String> longToShort = null;
    Map<String, String> shortToLong = null;

    public LintCode_TinyUrl2(){

        longToShort = new HashMap<String, String>();
        shortToLong = new HashMap<String, String>();
    }

    public String longToShort(String url) {

        if(longToShort.containsKey(url)){
            return BASE_URL + longToShort.get(url);
        }else{
            while(true){
                String shortUrl = createShort(url);
                if(!shortToLong.containsKey(shortUrl)){
                    shortToLong.put(shortUrl, url);
                    longToShort.put(url, shortUrl);
                    return BASE_URL + shortUrl;
                }
            }
        }
    }

    private String createShort(String url){

        char[] chars = new char[6];
        for(int i = 0; i < 6; i++){
            chars[i] = alphabet[(int)(Math.random()*alphabetSize)];
        }

        return String.valueOf(chars);
    }

    public String createCustom(String longUrl, String key) {

        if(key == null || longUrl == null || key.length() != 6){
            return null;
        }

        if(longToShort.containsKey(longUrl) && !longToShort.get(longUrl).equals(key)){
            return null;
        }

        if(shortToLong.containsKey(key) && !shortToLong.get(key).equals(longUrl)){
            return null;
        }

        if(!shortToLong.containsKey(key)){
            shortToLong.put(key, longUrl);
            longToShort.put(longUrl, key);
        }
        return BASE_URL + key;
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {

        String temp = url.substring(BASE_URL.length());

        if(shortToLong.containsKey(temp)){
            return shortToLong.get(temp);
        }else{
            return null;
        }
    }

    public static void main(String[] args){

        LintCode_TinyUrl2 tinyUrlService = new LintCode_TinyUrl2();

//        String longUrl = "www.google.com";
//        String shortUrl1 = tinyUrlService.longToShort(longUrl);
//        System.out.println(shortUrl1);
//
//        longUrl = "www.ebay.com";
//        String shortUrl2 = tinyUrlService.longToShort(longUrl);
//        System.out.println(shortUrl2);
//
//        System.out.println(tinyUrlService.shortToLong(shortUrl1));
//        System.out.println(tinyUrlService.shortToLong(shortUrl2));

        System.out.println(tinyUrlService.createCustom("http://www.lintcode.com/", "lccode"));
        System.out.println(tinyUrlService.longToShort("http://www.lintcode.com/problem/"));
        System.out.println(tinyUrlService.shortToLong("http://tiny.url/lccode"));
        System.out.println(tinyUrlService.createCustom("http://www.lintcode.com/", "lc"));
        System.out.println(tinyUrlService.createCustom("http://www.lintcode.com/en/ladder/", "lccode"));
    }
}

