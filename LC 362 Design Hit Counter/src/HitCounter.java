import java.util.LinkedList;
import java.util.Queue;

class HitCounter {
    Queue<Integer> que;
    /** Initialize your data structure here. */
    public HitCounter() {
        que = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        que.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        // 1 ~ 300 300 - 1 = 299
        while (!que.isEmpty() && timestamp - que.peek() >= 300) {
            que.poll();
        }
        return que.size();
    }
}