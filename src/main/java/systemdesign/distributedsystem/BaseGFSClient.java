package systemdesign.distributedsystem;

import java.util.Map;

/**
 * Created by ruili1 on 10/14/17.
 */
public class BaseGFSClient {

    private Map<String, String> chunk_list;

    public BaseGFSClient() {
    }

    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS

        return null;
    }

    public void writeChunk(String filename, int chunkIndex,
                           String content) {
        // Write a chunk to GFS
    }


}
