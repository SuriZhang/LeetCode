class Solution {
    public String minWindow(String S, String T) {
        int len = S.length();
        int[] lastSeen = new int[26];
        // initialize as -1
        Arrays.fill(lastSeen, -1);
        // next[i][letter] = first occurrence of letter in S[i:]
        int[][] next = new int[len][26]; 
        
        // construct next 2D-array
        for(int i = len-1; i >= 0; --i) {
            lastSeen[S.charAt(i) - 'a'] = i;
            for(int letter = 0; letter < 26; ++letter) {
                next[i][letter] = lastSeen[letter];
            }
        }
        
        // all possible windows - all occurrences of T[0] in S
        List<int[]> windows = new ArrayList();
        for(int i = 0; i < len; ++i) {
            if(S.charAt(i) == T.charAt(0)) {
                windows.add(new int[]{i,i});
            }
        }
        
        
        for(int j = 1; j < T.length(); ++j) {
            int letter = T.charAt(j) - 'a';
            for(int[] window : windows) {
                // window[1] = end of W
                if(window[1] < len-1 && next[window[1]+1][letter] >= 0) {
                    // next[window[1]+1][letter] - if S[winodw[1]+1] contains 'letter'
                    // update end of substring index
                    window[1] = next[window[1]+1][letter];
                } else {
                    // this window will not be a valid result, set begin & end index to -1
                    window[0] = window[1] = -1;
                    break;
                }
            }
        }
        
        int[] ans = {-1, len};
        // finding the best window
        for(int[] window : windows) {
            if(window[0] == -1) break;
            // update ans to find the shortest window
            if(window[1] - window[0] < ans[1] - ans[0]) ans = window;
        }
        return ans[0] >= 0 ? S.substring(ans[0], ans[1] + 1) : "";
    }
}
