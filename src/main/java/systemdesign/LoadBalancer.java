package systemdesign;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ruili1 on 10/14/17.
 *
 * Implement a load balancer for web servers. It provide the following functionality:

 Add a new server to the cluster => add(server_id).
 Remove a bad server from the cluster => remove(server_id).
 Pick a server in the cluster randomly with equal probability => pick().
 */
public class LoadBalancer {


    Set<Integer> servers = null;

    public LoadBalancer() {

        servers = new HashSet<Integer>();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {

        servers.add(server_id);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {

        servers.remove(server_id);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {

        List<Integer> list = new ArrayList<Integer>(servers);

        int idx = (int)(Math.random()*list.size());
        return list.get(idx);
    }
}
