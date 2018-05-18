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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.end - o2.end;
        }
    });
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i - 1].end > intervals[i].start) return false;
        }
        return true;
    }
}
