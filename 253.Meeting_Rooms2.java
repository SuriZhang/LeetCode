/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    // based on fast solution from 252
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int count = 0;
        if(len == 0){
            return count;
        }
        int[] starts = new int[len];
        int[] ends = new int[len];
        for(int i = 0; i < len; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        // sort start & end time to check overlap
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int j = 0;
        for(int i = 0; i < len; ++i) {
            if(starts[i] < ends[j]) { // overlap, need more room
                count++;
            } else { // current room fits
                j++;
            }
        }
        return count;
    }


    // alternative solution using a priority queue

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        if(intervals.length == 1) return 1;
        // sort by finish time
        Arrays.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    });
        
        // intervals is now sorted by start time
        int rooms = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(Interval i: intervals){
            while(pq.peek() != null && pq.peek() <= i.start){ 
		// check the current meeting with earliest start time do not overlap with the new one
		// remove current 
                pq.poll();
            }
	    // there is an overlap, need a new room
            pq.add(i.end);
	    // update room count
            rooms = rooms < pq.size() ? pq.size() : rooms;
        }
        return rooms;
    }
}
