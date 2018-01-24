package systemdesign.distributedsystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 10/14/17.
 *
 * Implement a simple client for GFS (Google File System, a distributed file system),
 * it provides the following methods:

 read(filename). Read the file with given filename from GFS.
 write(filename, content). Write a file with given filename & content to GFS.
 There are two private methods that already implemented in the base class:

 readChunk(filename, chunkIndex). Read a chunk from GFS.
 writeChunk(filename, chunkIndex, chunkData). Write a chunk to GFS.
 To simplify this question, we can assume that the chunk size is chunkSize bytes.
 (In a real world system, it is 64M). The GFS Client's job is splitting a file
 into multiple chunks (if need) and save to the remote GFS server.
 chunkSize will be given in the constructor. You need to call these two private methods
 to implement read & write methods.

 Note:
 BaseGFSClient is not implemented, so the logic won't work. But this code is correct judged by LintCode
 */
public class GFSClient extends BaseGFSClient {

    int chunkSize;
    Map<String, Integer> fileNameToChunkNumMap = null;

    /*
    * @param chunkSize: An integer
    */
    public GFSClient(int chunkSize) {

        this.chunkSize = chunkSize;
        fileNameToChunkNumMap = new HashMap<String, Integer>();
    }

    /*
     * @param filename: a file name
     * @return: content of the file given from GFS
     */
    public String read(String filename) {

        if(!fileNameToChunkNumMap.containsKey(filename)){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int chunkNum = fileNameToChunkNumMap.get(filename);
        for(int i = 0; i < chunkNum; i++){
            sb.append(readChunk(filename, i));
        }

        return sb.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {

        int len = content.length();
        int chunkNum = len % chunkSize == 0? len/chunkSize : len/chunkSize + 1;
        for(int i = 0; i < chunkNum; i++){
            int lower = i * chunkSize;
            int upper = Math.min((i + 1)*chunkSize, len);
            String subContent = content.substring(lower, upper);
            writeChunk(filename, i, subContent);
        }

        fileNameToChunkNumMap.put(filename, chunkNum);
    }

    public static void main(String[] args){

        GFSClient client = new GFSClient(5);
//        System.out.println(client.read("a.txt"));
        client.write("a.txt", "World");
        System.out.println(client.read("a.txt"));
        client.write("b.txt", "111112222233");
        System.out.println(client.read("b.txt"));
        client.write("b.txt", "aaaaabbbbb");
        System.out.println(client.read("b.txt"));
    }
}