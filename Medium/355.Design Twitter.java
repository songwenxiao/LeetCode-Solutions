public class Twitter {
    
    
    /* new class*/
    class tweet{
        long postTime;
        int tweetId;
        tweet next;
        tweet(int Id, long time){
            this.tweetId=Id;
            this.postTime=time;
            this.next=null;
        }
    }
    
    long time;
    HashMap<Integer,tweet> userTweet;
    HashMap<Integer,Set<Integer>> follow;
    
    /** Initialize your data structure here. */
    public Twitter() {
        time=0;
        userTweet=new HashMap<Integer,tweet>();
        follow=new HashMap<Integer,Set<Integer>>();
    }

    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(userTweet.containsKey(userId)){
            tweet tmp=new tweet(tweetId,time++);
            tmp.next=userTweet.get(userId);
            userTweet.put(userId,tmp);
        }
        else {
            tweet tmp=new tweet(tweetId,time++);
            userTweet.put(userId,tmp);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<Integer>();
        PriorityQueue<tweet> feedQueue=new PriorityQueue<tweet>(
            new Comparator<tweet>(){
                public int compare(tweet a, tweet b){
                    if(a.postTime-b.postTime>0) return -1;
                    else return 1;
                }
            });
        if(userTweet.containsKey(userId)) feedQueue.offer(userTweet.get(userId));
        if(follow.containsKey(userId)){
            for(Integer followee : follow.get(userId)){
                if(userTweet.containsKey(followee)) feedQueue.offer(userTweet.get(followee));
            }
        }
        while(!feedQueue.isEmpty() && feed.size()<10){
            tweet top=feedQueue.poll();
            feed.add(top.tweetId);
            if(top.next!=null) feedQueue.offer(top.next);
        }
        return feed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(follow.containsKey(followerId)) follow.get(followerId).add(followeeId);
        else {
            Set<Integer> tmp=new HashSet<Integer>();
            tmp.add(followeeId);
            follow.put(followerId,tmp);
            }
        }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(follow.containsKey(followerId)) follow.get(followerId).remove(followeeId);
    }
}

