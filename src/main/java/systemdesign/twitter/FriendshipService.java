package systemdesign.twitter;

import java.util.*;

/**
 * Created by ruili1 on 10/8/17.
 *
 */
public class FriendshipService {

    Map<Integer, TreeSet<Integer>> followerMap = null;// a-> {b, c} means a follows b and c (key is followers)
    Map<Integer, TreeSet<Integer>> followingMap = null; // a -> {b, c} means b and c are following a (key is the user who is followed)


    public FriendshipService() {

        followerMap = new HashMap<Integer, TreeSet<Integer>>();
        followingMap = new HashMap<Integer, TreeSet<Integer>>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     * Note: return all the users that user_id is following,
     * more specifically, get values in followerMap for key user_id
     */
    public List<Integer> getFollowers(int user_id) {

        if(followerMap.containsKey(user_id)) {
            return new ArrayList<Integer>(followerMap.get(user_id));
        }else{
            return new ArrayList<Integer>();
        }
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     * Note: return all the followers who are following user_id,
     * more specifically, get the value of followingMap for key user_id
     */
    public List<Integer> getFollowings(int user_id) {

        if(followingMap.containsKey(user_id)) {
            return new ArrayList<Integer>(followingMap.get(user_id));
        }else{
            return new ArrayList<Integer>();
        }
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * follow(!, 3) means 1 follows 3
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {

        // update followerMap
        TreeSet<Integer> users = new TreeSet<Integer>();
        if(followerMap.containsKey(from_user_id)){
            users = followerMap.get(from_user_id);
        }
        users.add(to_user_id);
        followerMap.put(from_user_id, users);

        // update followingMap
        users = new TreeSet<Integer>();
        if(followingMap.containsKey(to_user_id)){
            users = followingMap.get(to_user_id);
        }
        users.add(from_user_id);
        followingMap.put(to_user_id, users);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {

        // update followerMap
        if(followerMap.containsKey(from_user_id)){
            TreeSet<Integer> users = followerMap.get(from_user_id);
            users.remove(to_user_id);
            if(users.isEmpty()){
                followerMap.remove(from_user_id);
            }else{
                followerMap.put(from_user_id, users);
            }
        }

        // update followingMap
        if(followingMap.containsKey(to_user_id)){
            TreeSet<Integer> users = followingMap.get(to_user_id);
            users.remove(from_user_id);
            if(users.isEmpty()){
                followingMap.remove(to_user_id);
            }else{
                followingMap.put(to_user_id, users);
            }
        }
    }

    public void print(){

        // print followingMap
        for(Integer fromUserId : followingMap.keySet()){
            for(Integer toUserId : followingMap.get(fromUserId)) {
                System.out.println(fromUserId + " follows " + toUserId);
            }
        }
    }

    public static void main(String[] args){

        FriendshipService service = new FriendshipService();
        service.follow(1, 3);
        service.print();
        System.out.println(service.getFollowers(1));
        System.out.println(service.getFollowings(3));
        service.follow(2, 3);
        service.print();
        System.out.println(service.getFollowings(3));
        service.unfollow(1, 3);
        service.print();
        System.out.println(service.getFollowings(3));
        service.print();
    }
}