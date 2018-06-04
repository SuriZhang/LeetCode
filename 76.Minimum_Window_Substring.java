class Solution {
    private boolean containsAll(int[] s, int[] t) {
        for(int i = 0; i < 256; ++i) {
            if(t[i] > s[i]) return false;
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 ||
                t == null || t.length() == 0) {
            return "";
        }
        // simplified map
        int[] source = new int[256];
        int[] target = new int[256];
        
        // initialization 
        for(int i = 0; i < t.length(); ++i) {
            target[t.charAt(i)] ++;
        }
 
        int ans = s.length() + 1;
        String res = "";
        int i = 0, j = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && !containsAll(source, target)) {
                source[s.charAt(j)]++;
                if (j < s.length()) j++;
                else break;
            }
            if (containsAll(source, target)) {
                if (ans > j - i) {
                    ans = Math.min(ans, j - i);
                    res = s.substring(i, j);
                }
            }
            source[s.charAt(i)]--;
        }
        return res;
    }
    
}
