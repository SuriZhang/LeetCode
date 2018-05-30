// my solution
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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        
        List<Interval> result = new ArrayList<>();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        Interval temp = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval inter = intervals.get(i);
            if(inter.start <= temp.end){
                temp.start = Math.min(inter.start, temp.start);
                temp.end = Math.max(inter.end, temp.end);
            } else{
                result.add(temp);
                temp = inter;
            }
        }
        result.add(temp);
        return result;
    }
}

// faster ver.
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        List<Interval> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        for(int i = 0; i < n ; i++) {
            if(i == n - 1 || end[i] < start[i+1]) {
                result.add(new Interval(start[i], end[i]));
            } else if(end[i] >= start[i+1]) {
                start[i+1] = start[i];
            }

        }
        return result;

    }
}
