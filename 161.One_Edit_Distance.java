class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if(s.equals(t) || Math.abs(m -n) > 1) return false;
        
        if(m < n) return isOneEditDistance(t, s);
        
        for(int i = 0; i < n; ++i) { // n <= m
            if(s.charAt(i) != t.charAt(i)) {
                if(m == n) { // replace
                    return t.substring(i+1).equals(s.substring(i+1));
                } else { // delete from t
                    return t.substring(i).equals(s.substring(i+1));
                }
            }
        }
        return true; // s has one extra last char in the end, just remove the last char
    }
}
