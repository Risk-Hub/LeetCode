class Node{
    int tweet;
    Node next;
    public Node(int tweet) {
        this.tweet = tweet;
        this.next = null;
    }
}
class Twitter {
    Map<Integer,Node> allPosts;
    Map<Integer,ArrayList<Integer>> follower;
    Map<Integer,List<Integer>> personalPosts;
    List<Integer> globalPosts;
    public Twitter() {
        allPosts = new HashMap<>();
        follower = new HashMap<>();
        personalPosts = new HashMap<>();
        globalPosts = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        //simply post karo
        //post karte waqt userId ke followers mein bhi post jaane chahiye aur saath hi saath followers ka same post dobara nhi aana chahiye
        Node head = allPosts.get(userId);
        if(head == null){
            head = new Node(tweetId);
        }
        else {
            Node temp = new Node(tweetId);
            temp.next = head;
            head = temp;
        }
        allPosts.put(userId,head);

        List<Integer> post = personalPosts.get(userId);
        if(post == null){
            post = new ArrayList<>();
        }
        post.add(tweetId);
        personalPosts.put(userId,post);
        
        globalPosts.add(tweetId);

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry: follower.entrySet()){
            if(entry.getValue().contains(userId)){
                list.add(entry.getKey());
            }
        }
        for(int followers: list){
            head = allPosts.get(followers);
            Node newTweet = new Node(tweetId);
            newTweet.next = head;
            head = newTweet;
            allPosts.put(followers,head);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        //Simply get news feed kar do
        Node head = allPosts.get(userId);
        List<Integer> feeds = new ArrayList<>();
        while (head != null && feeds.size() != 10){
            feeds.add(head.tweet);
            head = head.next;
        }
        return feeds;
    }

    public void follow(int followerId, int followeeId) {
        //Followers ki tracking honi chahiye
        //Follow karte waqt follower ki post mein followee ki posts display honi chahiye
        ArrayList<Integer> followees = follower.get(followerId);
        if(followees == null){
            followees = new ArrayList<>();
        }
        if(followees.contains(followeeId)){
            return;
        }
        followees.add(followeeId);
        follower.put(followerId,followees);

        Node head = allPosts.get(followerId);
        List<Integer> post = personalPosts.get(followeeId);
        if(head == null && post != null){
            for(int posts: post){
                Node newTweet = new Node(posts);
                newTweet.next = head;
                head = newTweet;
            }
        }
//        else if(head != null && post == null){
//            
//        }
        else if(head != null && post != null){
            List<Integer> list = new ArrayList<>();
            while (head != null){
                list.add(head.tweet);
                head = head.next;
            }
            for(int i = 0;i < globalPosts.size();i++){
                if(list.contains(globalPosts.get(i))){
                    Node newTweet = new Node(globalPosts.get(i));
                    newTweet.next = head;
                    head = newTweet;
                }
                else if(post.contains(globalPosts.get(i))){
                    Node newTweet = new Node(globalPosts.get(i));
                    newTweet.next = head;
                    head = newTweet;
                }
            }
        }
        allPosts.put(followerId,head);
    }

    public void unfollow(int followerId, int followeeId) {
        //unfollow karte waqt followee ki posts followers se hatt jaani chahiye
        //Unfollow karte waqt followers list se remove hona chahiye
        Node head = allPosts.get(followerId);
        List<Integer> post = personalPosts.get(followeeId);
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.tweet);
            head = head.next;
        }
        for(int posts: post){
            list.remove((Integer) posts);
        }
        
        for(int i = list.size() - 1;i >= 0;i--){
            Node newTweet = new Node(list.get(i));
            newTweet.next = head;
            head = newTweet;
        }
        allPosts.put(followerId,head);

        ArrayList<Integer> followees = follower.get(followerId);
        if(followees != null){
            followees.remove((Integer) followeeId);
            follower.put(followerId,followees);
        }
    }
}