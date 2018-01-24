package systemdesign;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 8/29/17.
 *
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service.
 There is no restriction on how your encode/decode algorithm should work.
 You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class LC535_TinyUrl {

    public class Codec {

        Map<String, String> index = null;           // long to short mapping
        Map<String, String> invertedIndex = null;   // short to long mapping

        final String BASE_URL = "http://tinyurl.com/";
        final char[] ENCODING_CHARS = new String("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        final int ENCODING_BASE = ENCODING_CHARS.length;

        public Codec(){
            index = new HashMap<String, String>();
            invertedIndex = new HashMap<String, String>();
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {

            if(index.containsKey(longUrl)){
                return index.get(longUrl);
            }

            long urlNum = index.size();
            urlNum ++;
            String compressed = compressNum(urlNum);
            String shortUrl = BASE_URL + compressed;
            index.put(longUrl, shortUrl);
            invertedIndex.put(shortUrl, longUrl);

            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {

            if(invertedIndex.containsKey(shortUrl)){
                return invertedIndex.get(shortUrl);
            }else{
                return null;
            }
        }

        private String compressNum(long x){

            String s = "";
            while(x > 0){
                char xMod = ENCODING_CHARS[(int)(x % ENCODING_BASE)];
                s = xMod + s;
                x = x / ENCODING_BASE;
            }

            while(s.length() < 6){
                s = '0' + s;
            }

            return s;
        }

        public int size(){

            return index.size();
        }
    }

    public static void main(String[] args){

        Codec codec = new LC535_TinyUrl().new Codec();
        String longUrl = "www.google.com";
        System.out.println(codec.encode(longUrl));
        System.out.println(codec.encode(longUrl));
        System.out.println(codec.size());
        longUrl = "www.ebay.com";
        System.out.println(codec.encode(longUrl));
        System.out.println(codec.decode("http://tinyurl.com/000001"));
        System.out.println(codec.decode("http://tinyurl.com/000002"));
    }
}
